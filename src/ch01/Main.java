package ch01;

import ch02.classfileentry.ClassPath;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Parser parser = new Parser();
            String line = sc.nextLine();
            String[] cmdArgs = line.split(" ");

            // 解析输入
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
        System.out.printf("classpath:%s class:%s args:%s", cmd.cpOperatin, cmd.clazz, Arrays.asList(cmd.args).toString());
        ClassPath classPath = new ClassPath();
    }

    /**
     * 输出命令的用法
     */
    public static void printUsage(String args) {
        System.out.printf(">>> Usage:%s [-options] class [args...]\n", args);
    }

}
