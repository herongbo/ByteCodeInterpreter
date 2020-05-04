package ch05;

import ch05.classfile.beans.MemberInfo;
import ch05.classpath.ClassPath;
import ch05.cmdparse.Cmd;
import ch05.cmdparse.Parser;
import ch05.utils.ByteToString;
import ch05.utils.Log;
import ch05.classfile.ClassFile;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (true)
        {
            Parser parser = new Parser();
            // 设置classpath 执行类
            //测试 extClasspath
//            String[] cmdArgs = {"java","-Xjre","C:\\Program Files\\Java\\jre1.8.0_191\\","sun.security.ec.CurveDB"};
            // 测试 bootstrapClassPath
//            String[] cmdArgs = {"java","java.util.Scanner"};
            // 测试ClassPath
//            String[] cmdArgs = {"java", "-cp", "C:\\Users\\JDUSER\\Downloads\\jvm\\out\\production\\jvm", "ch02.cmdparse.Parser"};
//            String[] cmdArgs = {"java", "-cp", "C:\\Users\\JDUSER\\Documents\\我的坚果云\\Desktop\\coding\\mycode\\workspace\\xf\\bin\\xf", "Number"};
            String[] cmdArgs = {"java", "-cp", "C:\\Users\\JDUSER\\Documents\\我的坚果云\\Desktop\\coding\\mycode\\workspace\\xf\\bin\\xf", "Run"};
//            String[] cmdArgs = {"java", "-cp", "C:\\Users\\JDUSER\\Desktop", "GaussTest"};

            // 打印原始命令
            System.out.println(Arrays.asList(cmdArgs));

            // 命令行解析到Cmd类
            Cmd cmd = parser.parseCmd(cmdArgs);

            // 输出版本号
            if (cmd.versionFlag) {
                System.out.println("version 0.0.2");
                // 帮助信息
            } else if (cmd.helpFlag) {
                printUsage(cmd.clazz);
                // 启动虚拟机
            } else {
                startJvm(cmd);
            }
        }
    }

    /**
     * 启动Jvm
     *
     * @param cmd
     */
    public static void startJvm(Cmd cmd) {
        Log.log("starting Jvm");

        // 打印classpath信息
        System.out.printf("classpath: [%s] class:[%s] args:[%s]\n", cmd.cpOption, cmd.clazz, Arrays.toString(cmd.args));
        System.out.printf("xjre: [%s] class:[%s] args:[%s]\n", cmd.XjreOption, cmd.clazz, Arrays.toString(cmd.args));

        ClassPath classPath = new ClassPath();
        // jreOption 和 classOption都由classpath解析
        classPath = classPath.parse(cmd.XjreOption, cmd.cpOption);

        //  讲包名替换为文件路径，得到真实的className
        String className = cmd.clazz.replaceAll("\\.", "/");

        // class的真实文件
        System.out.println("%%%" + className + "%%%");

//        // parent委派模型加载类
//        byte[] classData = classPath.readClass(className);
//        if (classData == null) {
//            System.out.printf("Cold not find or load main class %s\n", cmd.clazz);
//            return;
//        }
//
//        System.out.print("class data:");
//        System.out.println(classData.length);
//        System.out.println(new ByteToString().getString(classData));
//        ClassFile classFile = new ClassFile();
//        classFile.parse(classData);
        ClassFile classFile = loadClass(className,classPath);
        MemberInfo mainMethod = getMainMethod(classFile);
        if (mainMethod != null){
            new Interpreter().interpret(mainMethod);
        }else {
            System.err.printf("Main method not found in class %s \n",cmd.clazz);
        }
    }

    public static ClassFile loadClass(String className,ClassPath classPath){
        // parent委派模型加载类
        byte[] classData = classPath.readClass(className);
        if (classData == null) {
            System.out.printf("Cold not find or load main class %s\n", className);
        }
        System.out.print("class data:");
        System.out.println(classData.length);

        ClassFile classFile = new ClassFile();
        classFile = classFile.parse(classData);
        System.out.println(classFile.methods == null);
        return classFile;
    }

    public static MemberInfo getMainMethod(ClassFile classFile){
        for (MemberInfo method : classFile.methods) {
            System.out.println(method.Name());
            System.out.println(method.Descriptor());
            if (method.Name().equals("main") && method.Descriptor().equals("([Ljava/lang/String;)V")){
                return method;
            }
        }
        return null;
    }

    /**
     * 打印帮助信息
     */
    public static void printUsage(String args) {
        System.out.printf(">>> Usage: %s [-options] class [args...]\n", args);
    }

}
