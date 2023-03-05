package my.tms_hw.console.util;

import my.tms_hw.util.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }



    @Override
    public void write(String message) {
        System.out.print(message);
    }
}
