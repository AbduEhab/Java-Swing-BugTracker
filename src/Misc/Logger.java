package Misc;

public class Logger {

    private static String logString = "";
    public static boolean show = true;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void Warn(String Message) {
        if(show)
            System.out.println(ANSI_YELLOW + "[Warning]: " + Message + "." + ANSI_WHITE);
        logString += ANSI_YELLOW + "[Warning]: " + Message + "." + ANSI_WHITE + "\n";
    }

    public static void Error(String Message) {
        if (show)
            System.out.println(ANSI_RED + "[Error]: " + Message + "." + ANSI_WHITE);
        logString += ANSI_RED + "[Error]: " + Message + "." + ANSI_WHITE + "\n";
    }

    public static void Log(String Message) {
        if(show)
            System.out.println("[Log]: " + Message + ".");
        logString += "[Log]: " + Message + ".\n";
    }

    public static void Declare(String Message) {
        System.out.println(ANSI_PURPLE + "[Declaration]: " + Message + "." + ANSI_WHITE);
        logString += ANSI_PURPLE + "[Declaration]: " + Message + "." + ANSI_WHITE + "\n";
    }

    public String getLogString() {
        return logString;
    }
}