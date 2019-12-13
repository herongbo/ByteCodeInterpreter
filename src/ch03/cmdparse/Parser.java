package ch03.cmdparse;

import ch03.utils.Log;
import org.apache.commons.cli.*;

public class Parser {
    private final String TAG = ">>>";
    public final String mVersion = "MyJVM version 0.0.1";
    public String mName;
    public String[] mClassPath;
    public String mXJre;
    public Cmd cmd = new Cmd();

    /**
     * parseCmd实现了三个功能：
     * v 输出Version
     * help 或者 class 为空，printUsage()
     * 或者 调用startJVM 打印 classpath ,class ,args
     *
     * @param args
     */

    public Cmd parseCmd(String[] args) {


        //使用commons-cli解析控制台命令
        Options options = new Options();

        options.addOption("h", "help", false, "print help message");
        options.addOption("v", "version", false, "print version and exit");
        options.addOption("cp", "classpath", true, "");
        options.addOption("X", "Xjre", true, "parth to jre");

        CommandLineParser parser = new DefaultParser();

        try {

            // 设置option和命令字符串
            CommandLine commandLine = parser.parse(options, args);

            // 输入的是help
            if (commandLine.hasOption("help")) {
                cmd.helpFlag = true;
            }

            if (commandLine.hasOption("version")) {
                cmd.versionFlag = true;
            }

            if (commandLine.hasOption("classpath")) {
                cmd.cpOption = commandLine.getOptionValue("classpath");
            }

            if (commandLine.hasOption("Xjre")) {
                Log.simpleLog("found -Xjre " + commandLine.getOptionValue("Xjre"), false);
                cmd.XjreOption = commandLine.getOptionValue("Xjre");
            }

            // 对剩剩下的参数继续处理
            // 注意，命令开头可能是以java开头
            if (commandLine.getArgList().size() > 1) {
                // args[0]是java
                // 第二个参数指定的是class
                cmd.clazz = commandLine.getArgs()[1];

                // 解析以后剩余的参数
                commandLine.getArgList().forEach(System.err::println);

                if (commandLine.getArgList().size() > 2) {
                    cmd.args = commandLine.getArgList()
                            .subList(2, commandLine.getArgList().size())
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
