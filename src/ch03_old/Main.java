package ch03_old;

import ch03_old.entry.ClassFile;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (true)
        {
            Parser parser = new Parser();
            // 指定文件路径，可以读到
//            String[] cmdArgs = {
//                    "-cp",
//                    "C:\\Users\\JDUSER\\IdeaProjects\\用故事给技术加点料\\out\\production\\用故事给技术加点料\\",
//                    "Two_DataDriver"};
            String[] cmdArgs = {
                    "-Xjre",
                    "C:\\Program Files\\Java\\jre1.8.0_191\\lib\\",
                    "com.sun.nio.zipfs.ZipFileStore"};
            Cmd cmd = parser.parseCmd(cmdArgs);

            if (cmd.versinFlag) {
                System.out.println("version 0.0.1");
            } else if (cmd.helpFlag) {
                printUsage(cmd.clazz);
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
        System.err.println(">>> " + "startJvm !!!");
        ClassPath classPath = new ClassPath();
        classPath = classPath.parse(cmd.XjreOption, cmd.cpOperatin);
        System.out.printf("classpath:[%s] class:[%s] args:[%s]\n", cmd.cpOperatin, cmd.clazz, Arrays.toString(cmd.args));

        String className = cmd.clazz.replaceAll("\\.", "/");
        System.out.println("%%%" + className + "%%%");
        byte[] classData = classPath.readClass(className);
        if (classData == null) {
            System.out.printf("Cold not find or load main class %s\n", cmd.clazz);
            return;
        }
        System.out.print("class data:");
        System.out.println(classData.length);
        System.out.println(new ByteToString().getString(classData));
        ClassFile classFile = new ClassFile();
        classFile.parse(classData);

        System.err.println(classFile.toString());
    }

    /**
     * 输出命令的用法
     */
    public static void printUsage(String args) {
        System.out.printf(">>> Usage:.%s [-options] class [args...]\n", args);
    }

}
