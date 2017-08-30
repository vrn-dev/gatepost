package com.ronintech.bayTrans.escpos;

public class ESCUtils {

    private static String CS = ""; // CS == COMMAND_SET

    public String initPrinter() {
        final byte[] init = {27, 64};
        CS += new String(init);
        return new String(init);
    }

    public String newLine() {
        final byte[] LF = {10};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String lineFeed(byte lines) {
        final byte[] LF = {27, 100, lines};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String alignLeft() {
        final byte[] LF = {27, 97, 48};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String alignRight() {
        final byte[] LF = {27, 97, 50};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String alignCenter() {
        final byte[] LF = {27, 97, 49};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String underline(int options) {
        final byte[] UnderLine2Dot = {27, 45, 50};
        final byte[] UnderLine1Dot = {27, 45, 49};
        final byte[] NoUnderLine = {27, 45, 48};

        String cmd = "";
        switch (options) {
            case 0:
                cmd = new String(NoUnderLine);
                break;

            case 1:
                cmd = new String(UnderLine1Dot);
                break;

            default:
                cmd = new String(UnderLine2Dot);
        }

        CS += cmd;
        return cmd;
    }

    public String setCharDims(int size) {
        final byte[] x1 = {29, 33, 0, 0};
        final byte[] x2 = {29, 33, 1, 16};
        final byte[] x3 = {29, 33, 2, 32};

        String cmd = "";
        switch (size) {
            case 0:
                cmd = new String(x2);
                break;
            case 1:
                cmd = new String(x3);
                break;
            default:
                cmd = new String(x1);
        }

        CS += cmd;
        return cmd;
    }

    public String cut() {
        final byte[] cut = {27, 109};
        String cmd = new String(cut);
        CS += cmd;
        return cmd;
    }

    public String lineSeparator() {
        String lineSep = "----------------------------------------";
        CS += lineSep;
        return lineSep;
    }

    public void resetAll() {
        CS = "";
    }

    public void setText(String text) {
        CS += text;
    }

    public String finalCmd() {
        return CS + "\n\n";
    }


}
