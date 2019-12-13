package ch01;

import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Jvm命令行的解析类，解析以下三种参数
 */
public class Parser {
    private final String TAG = ">>>";
    public final String mVersion = "MyJVM version 0.0.1";
    public String mName;
    public String[] mClassPath;
    public String mXJre;
    public Cmd cmd = new Cmd();

    /**
     * parseCmd实现了三个功能：
     * -v/-verson 输出mVersion
     * -h/-help help 或者 class 为空，输出printUsage()
     * 或者调用startJVM 打印 classpath ,class ,args
     *
     * @param args
     */

    public Cmd parseCmd(String[] args) {


        //使用commons-cli工具解析控制台命令
        Options options = new Options();

        options.addOption("h", "help", false, "print help message");
        options.addOption("v", "version", false, "print version and exit");
        options.addOption("cp", "classpath", true, "");
        options.addOption("X", "Xjre", true, "Jar path");

        CommandLineParser parser = new DefaultParser();

        try {

            // 设置option和命令字符串
            CommandLine commandLine = parser.parse(options, args);

            // 输入的是help
            if (commandLine.hasOption("help")) {
                cmd.helpFlag = true;
            }

            if (commandLine.hasOption("version")) {
                cmd.versinFlag = true;
            }

            if (commandLine.hasOption("classpath")) {
                cmd.cpOperatin = commandLine.getOptionValue("classpath");
            }

            // 设置Jre参数
            if (commandLine.hasOption("Xjre")) {
                mXJre = commandLine.getOptionValue("Xjre");
            }

            // 解析其他的参数
            if (commandLine.getArgList().size() > 0) {
                // 第一个参数指定的是class
                cmd.clazz = commandLine.getArgs()[0];

                // cmd前面输入java，args从第3个开始计算
                commandLine.getArgList().forEach(System.err::println);
                if (commandLine.getArgList().size() > 2) {
                    cmd.args = commandLine.getArgList().subList(2, commandLine.getArgList().size())
                            .toArray(new String[0]);
                }
            }
        } catch (ParseException e) {
            System.err.println(TAG + e.getMessage());
            e.printStackTrace();
        }
        return cmd;
    }
}
