package ui;

import javax.swing.JFrame;

public class BinaryDecimalConverter extends JFrame {
    public BinaryDecimalConverter() {
        this.setBDCProperties();
    }

    public void setBDCProperties() {
        this.setTitle("Binary Decimal Converter");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}