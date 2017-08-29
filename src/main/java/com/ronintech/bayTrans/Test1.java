package com.ronintech.bayTrans;

import javax.print.PrintServiceLookup;

public class Test1 {

    public static void main(String[] args) {
        String defaultPrinter =
                PrintServiceLookup.lookupDefaultPrintService().getName();
        System.out.println("Default printer: " + defaultPrinter);
    }
}
