package com.ronintech.bayTrans;

import jpos.JposException;
import jpos.POSPrinter;
import jpos.POSPrinterConst;
import jpos.util.JposPropertiesConst;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.setProperty(JposPropertiesConst.JPOS_POPULATOR_FILE_PROP_NAME, "jpos.xml");
        //System.setProperty("java.library.path", "/usr/lib/jvm/jdk1.8.0_144/lib/libjposprintercomm64.so");
        POSPrinter printer = new POSPrinter();

        System.out.println("Initializing");

        try {
            System.out.println("opening printer");
            printer.open("CUSTOM_Engineering_TG2480-H");
            System.out.println("claiming printer");
            printer.claim(1);
            printer.setDeviceEnabled(true);

            System.out.println("Printing Ticket");
            printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, "Print Test");

            printer.setDeviceEnabled(false);
            System.out.println("releasing");
            printer.release();
            System.out.println("closing");
            printer.close();


        } catch (JposException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("Finally close");
                printer.close();
            } catch (JposException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
