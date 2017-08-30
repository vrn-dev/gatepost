package com.ronintech.bayTrans.printest001;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ReceiptPrint implements Printable {

    SimpleDateFormat df = new SimpleDateFormat();
    String receiptDetailLine;
    public static final String pspace = "               ";//15-spaces

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
            throws PrinterException {

        df.applyPattern("dd/MM/yyyy HH:mm:ss");
        String strText = null;
        final String LF = "\n";// text string to output
        int lineStart;           // start index of line in textarea
        int lineEnd;             // end index of line in textarea
        int lineNumber;
        int lineCount;
        final String SPACE = "          ";//10 spaces
        final String SPACES = "         ";//9
        final String uline = "________________________________________";
        final String dline = "----------------------------------------";
        String greetings = "THANKS FOR YOUR VISIT";
        receiptDetailLine = "asdasdasda";

        Graphics2D g2d = (Graphics2D) graphics;
        Font font = new Font("MONOSPACED", Font.BOLD, 9);

        if (pageIndex < 0 || pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        JTextArea textarea = new JTextArea(10, 40);

        //testing
        textarea.append(SPACES + "sadasdsad" + "\n");

        textarea.append(" " + SPACES + "sadasdsad" + "\n");

        textarea.append(SPACES + "sadasdsad" + "\n");

        textarea.append("" + SPACES + "sadasdsad" + "\n");

        textarea.append(SPACES + "sadasdsad" + "\n");

        textarea.append(uline + "\n");
        textarea.append("Order Ref:" + "   " + receiptDetailLine + "\n");
        textarea.append(dline + "\n");
        textarea.append(" Qty     Description" + SPACES + "  Price" + LF);
        textarea.append(dline + "\n");

        System.out.println(2);

        String printedLine = "       Service Charge Complimentary";
        textarea.append(printedLine + LF);

        textarea.append(LF + SPACES + "   Your Reciept\n" + SPACE + greetings + LF);
        textarea.append(df.format(new Date()) + LF);
        textarea.setEditable(false);

        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        g2d.setFont(font);
        lineNumber = 0;
        lineCount = textarea.getLineCount();
        strText = textarea.getText();
        /*MediaTracker mt = new MediaTracker(textarea);
         URL imageURL = null;
         try {

         imageURL = new URL(mainDirectory+"quindell.png");
         } catch (MalformedURLException me) {
         me.printStackTrace();
         }

         //--- Load the image and wait for it to load
         Image image = Toolkit.getDefaultToolkit().getImage(imageURL);
         mt.addImage(image, 0);
         */

        while (lineCount != 0) {
            try {

                lineStart = textarea.getLineStartOffset(lineNumber);
                lineEnd = textarea.getLineEndOffset(lineNumber);
                strText = textarea.getText(lineStart, lineEnd - lineStart);
            } catch (Exception exception) {
                System.out.println("Printing error:" + exception);                  // have to catch BadLocationException
            }

            g2d.drawString(strText, 1, (lineNumber + 1) * 18);
            //spacing    between lines
            lineNumber = lineNumber + 1;
            lineCount--;
        }
        return Printable.PAGE_EXISTS;
    }
}
