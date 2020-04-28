package ch04.classpath;

import ch04.classpath.beans.Entry;
import ch04.utils.Log;

import java.io.File;
import java.util.Objects;

public class ClassPath {
    /**
     * Classpath结构体有三个字段，分别存放三种类路径，Parse（）函数使用-Xjre选项解析和启动类路径和拓展类路径
     * 使用-classpath/-cp 选项解析用户类路径，代码如下
     */
    // jre/lib
    Entry bootClassspath;
    // jre/lib/ext
    Entry extClasspath;
    Entry userClasspath;

    public ClassPath parse(String jreOption, String cpOption) {
        System.out.println("Classpath:parse......" + jreOption + "," + cpOption);
        ClassPath cp = new ClassPath();
        cp.parseBootAndExtClasspath(jreOption);
        cp.parseUserClasspath(cpOption);
        return cp;
    }

    /**
     * 注意，传递给ReadClass方法的类名不包含“class"后缀，最后String（）方法返回用户路径的字符串表示
     *
     * @param className
     * @return
     */
    public byte[] readClass(String className) {
        System.out.println("read class name= " + className);
        byte[] data = null;

        if ((data = bootClassspath.readClass(className)) != null) {
            Log.log("bootstrap load");
            return data;
        } else if ((data = extClasspath.readClass(className)) != null) {
            Log.log("ext load");
            return data;
        } else if ((data = userClasspath.readClass(className)) != null) {
            Log.log("classpath load");
            return data;
        } else {
            new ClassNotFoundException();
            return null;
        }
    }

    /**
     * 设置classpath，先查找cp选项，在设置当前路径
     *
     * @param cpOption
     */
    private void parseUserClasspath(String cpOption) {
        System.out.println("setCpOption " + cpOption);

        if (cpOption == null || cpOption.equals("")) {
            cpOption = ".";
        }

        // class文件
        this.userClasspath = ReadClass.newEntry(cpOption);
    }

    /**
     * 获取jre路径，设置jre/lib和jre/lib/ext为bootStrapClasspath和extClasspath、
     *
     * @param jreOption
     */
    private void parseBootAndExtClasspath(String jreOption) {
        System.out.println("jreOption...." + jreOption);

        String jreDir = getJreDir(jreOption);

        System.out.println("the used jre dir " + jreDir);

        // jre/lib/*
        // jar使用WildcardEntiry解析
        String jreLibPath = jreDir + File.separator + "lib" + File.separator + "*";
        this.bootClassspath = ReadClass.newEntry(jreLibPath);

        // jre/lib/ext/*
        String jreExtPath = jreDir + File.separator + "lib" + File.separator + "ext" + File.separator + "*";
        this.extClasspath = ReadClass.newEntry(jreExtPath);
        System.out.println("bootClasspath " + jreLibPath);
        System.out.println("extClasspath  " + jreExtPath);
    }

    /**
     * 优先使用用户输入的Xjre选项作为jre目录，如果没有输入该选项，则在当前目录下寻找jre目录
     */
    private String getJreDir(String jreOption) {
        Log.log("jreOption: " + jreOption);
        if (jreOption != null && !Objects.equals(jreOption, "") && new File(jreOption).exists()) {
            Log.log("use XjreOption as jre" + jreOption);
            return jreOption;
        }
        if (new File("./jre").exists()) {
            Log.log("use local dir as jre" + new File("./jre").getAbsolutePath());
            return "./jre";
        }
        if (System.getenv("JAVA_HOME") != null) {
            Log.log("use System envs" + System.getenv("JAVA_HOME") + File.separator + "jre");
            return System.getenv("JAVA_HOME") + File.separator + "jre";
        }

        new Exception("Can not find jre folder!");
        return null;
    }

    public boolean exists(String path) {
        if (new File(path).exists()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.userClasspath.toString();
    }
}
