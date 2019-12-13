package ch03_old;

import org.apache.commons.cli.*;

public class Parser {
    private final String TAG = ">>>";
    public String mName;
    public String mVersion = "MyJVM version 0.0.1";
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
                cmd.versinFlag = true;
            }

            if (commandLine.hasOption("classpath")) {
                cmd.cpOperatin = commandLine.getOptionValue("classpath");
            }

            // 第一章代码没有实现
            if (commandLine.hasOption("Xjre")) {
                System.out.println("found -Xjre" + commandLine.getOptionValue("Xjre"));
                cmd.XjreOption = commandLine.getOptionValue("Xjre");
            }

            //判断参数长度
            //对剩余的参数 单独处理
            if (commandLine.getArgList().size() > 0) {
                // 第一个参数指定的是class
                cmd.clazz = commandLine.getArgs()[0];
                commandLine.getArgList().forEach(System.out::print);
                if (commandLine.getArgList().size() > 1) {
                    cmd.args = commandLine.getArgList().subList(1, commandLine.getArgList().size())
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
