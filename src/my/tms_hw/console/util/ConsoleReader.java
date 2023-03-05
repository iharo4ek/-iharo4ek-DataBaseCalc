package my.tms_hw.console.util;

import my.tms_hw.util.Reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private final Scanner scanner = new Scanner(System.in);


    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public double readDouble() {
        return scanner.nextDouble();
    }

    public String readLine() {
        return scanner.nextLine();
    }


}

