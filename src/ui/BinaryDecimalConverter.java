package ui;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import ui.enumeration.BinaryMod;

public class BinaryDecimalConverter extends JFrame {
    protected BinaryMod _mod = BinaryMod._BDConv;

    public BinaryDecimalConverter() {
        this.setBDCProperties();
    }

//======================================================================================

    public void setBDCProperties() {
        this.setTitle("Binary Decimal Converter");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new DimensionUIResource(500, 500));
    }

//======================================================================================

    public void loadBDC() {
        if(!(this._mod.getModNumber() == 0)) return; // if this._mod is different to 0, quit function (Note: mod == 0 -> Binary Decimal Converter
                                                                                                    //     : mod == 1 -> Binary Calculator)

        
    }
}