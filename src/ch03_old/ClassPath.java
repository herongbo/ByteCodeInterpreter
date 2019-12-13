package ch03_old;

import ch03_old.entry.Entry;
import ch03_old.entry.WildcardEntry;

import java.io.File;
import java.util.Objects;

public class ClassPath {
    /**
     * Classpath结构体有三个字段，分别存放三种类路径，Parse（）函数使用-Xjre选项解析和启动类路径和拓展类路径
     * 使用-classpath/-cp 选项解析用户类路径，代码如下
     */
    Entry bootClassspath;
    Entry extClasspath;
    Entry userClasspath;

    public ClassPath parse(String jreOption, String cpOption) {
        System.out.println("parse......"+jreOption+","+cpOption);
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
        System.out.println("read class name= "+className);
        if (bootClassspath.readClass(className) != null) {
            System.out.println("bootstrappathload");
            return bootClassspath.readClass(className);
        }
        if (extClasspath.readClass(className) != null) {
            System.out.println("extload");
            return extClasspath.readClass(className);
        }
        return userClasspath.readClass(className);
    }

    private void parseUserClasspath(String cpOption) {
        System.out.println("setcpOption  "+cpOption);
        if (cpOption == null || cpOption.equals("")) {
            cpOption = ".";
        }
        this.userClasspath = ReadClass.newEntry(cpOption);
    }

    private void parseBootAndExtClasspath(String jreOption) {
        System.out.println("jreOption...."+jreOption);
        String jreDir = getJreDir(jreOption);
        System.out.println("the used jre dir "+jreDir);

        // jre/lib/*
        String jreLibPath = jreDir + File.separator + "lib" + File.separator + "*";
        this.bootClassspath = new WildcardEntry(jreLibPath);

        // jre/lib/ext/*
        String jreExtPath = jreDir + File.separator + "lib" + File.separator + "ext" + File.separator + "*";
        this.extClasspath = new WildcardEntry(jreExtPath);
        System.out.println("bootClasspath "+jreLibPath);
        System.out.println("extClasspath  "+jreExtPath);
    }

    //优先使用用户输入的Xjre选项作为jre目录，如果没有输入该选项，则在当前目录下寻找jre目录
    private String getJreDir(String jreOption) {
        if (Objects.equals(jreOption, "") && new File(jreOption).exists()) {
            return jreOption;
        }
        if (new File("./jre").exists()) {
            return "./jre";
        }
        if (System.getenv("JAVA_HOME") != null) {
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
