package ch04.utils;

public class Log {
    static char[] arrays = {'|', '/', '-', '\\'};

    public static void main(String[] args) {
        log("starting jvm");
    }

    public static void log(String s) {
        log(s, 00, true);
    }

    public static void log(String s, boolean show) {
        log(s, 00, show);
    }

    public static void log(String s, int times, boolean show) {
        if (!show) {
            return;
        }

        for (int i = 0; i < times * 4; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("\r%s", arrays[i % 4] + s);
        }
        System.out.printf("\r%s\n", s);
    }

    public static void simpleLog(String s) {
        System.out.println(s);
    }

    public static void simpleLog(String s, boolean show) {
        if (show) {
            System.out.println(s);
        }
    }
}
