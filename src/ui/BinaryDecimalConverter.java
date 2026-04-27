package ui;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.SpinnerNumberModel;

import ui.com.displayer.InputDisplayer;
import ui.com.displayer.OutputDisplayer;
import ui.enumeration.BinaryMod;

import java.awt.GridLayout;

public class BinaryDecimalConverter extends JFrame {
    protected BinaryMod _mod = BinaryMod._BDConv;
    protected JPanel _mainPanel = new JPanel(new GridLayout(5, 2));

//======================================================================================

    public BinaryDecimalConverter() {
        this.setBDCProperties();
        this.loadBDC();
    }

//======================================================================================

    public void setBDCProperties() {
        this.setTitle("Binary Decimal Converter");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new DimensionUIResource(500, 500));
        this.setContentPane(_mainPanel);
    }

//======================================================================================

    public void loadBDC() {
        if(!(this._mod.getModNumber() == 0)) return; // if this._mod is different to 0, quit function (Note: mod == 0 -> Binary Decimal Converter
                                                                                                    //     : mod == 1 -> Binary Calculator)

        
        JPanel _displayerPanel = new JPanel(new GridLayout(2, 2));
        InputDisplayer _inputDisplayer = new InputDisplayer();
        OutputDisplayer _outputDisplayer = new OutputDisplayer();
        JSpinner _bitNumber = new JSpinner(new SpinnerNumberModel(4, 1, 200, 1));
        String[] _precision = {"16", "32", "64", "79", "128", "256"};
        JComboBox<String> _decimalPrecision = new JComboBox<String>(_precision);

        _displayerPanel.add(_inputDisplayer);
        _displayerPanel.add(_bitNumber);
        _displayerPanel.add(_outputDisplayer);
        _displayerPanel.add(_decimalPrecision);
        this._mainPanel.add(_displayerPanel);
    }
}