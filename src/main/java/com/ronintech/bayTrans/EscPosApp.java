package com.ronintech.bayTrans;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscPosApp {

    public static void main(String[] args) {
        try {
            FileWriter file = new FileWriter("/dev/usb/lp1");
            BufferedWriter buffer = new BufferedWriter(file);
            PrintWriter ps = new PrintWriter(buffer);
            ps.write("Hello World");
            ps.write("0x0A");
            ps.write("1Bx69");
            ps.close();
            buffer.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
