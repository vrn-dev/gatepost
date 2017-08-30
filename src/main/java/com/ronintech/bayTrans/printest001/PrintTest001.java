package com.ronintech.bayTrans.printest001;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;

public class PrintTest001 {
    public static void main (String[] args) {
        PageFormat format = new PageFormat();
        Paper paper = new Paper();

        double paperWidth = 3;//3.25
        double paperHeight = 3.69;//11.69
        double leftMargin = 0.12;
        double rightMargin = 0.10;
        double topMargin = 0;
        double bottomMargin = 0.01;

//        paper.setSize(paperWidth * 50, paperHeight * 50);
//        paper.setImageableArea(leftMargin * 50, topMargin * 50,
//                (paperWidth - leftMargin - rightMargin) * 50,
//                (paperHeight - topMargin - bottomMargin) * 50);

        paper.setSize(212.46, 326);
        paper.setImageableArea(5, 5, 207.46, 321);

        format.setPaper(paper);

        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(OrientationRequested.PORTRAIT);
//testing

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        Printable printable = new ReceiptPrint();

        format = printerJob.validatePage(format);
//        boolean don = printerJob.printDialog(aset);
//        printerJob.pr
        printerJob.setPrintable(printable, format);
        try {
            printerJob.print(aset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
