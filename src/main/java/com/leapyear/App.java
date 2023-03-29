package com.leapyear;

/**
 * Hello world!
 */
public final class App {
    private Logging logger;
    public App(Logging logger) {
        this.logger = logger;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public boolean isLeapYear(int year) {
        logger.log(year + "");;
        if (year % 4 != 0)
            return false;
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return true;

    }
}
