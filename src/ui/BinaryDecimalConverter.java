package ui;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.SpinnerNumberModel;

import ui.enumeration.BinaryMod;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class BinaryDecimalConverter extends JFrame implements ActionListener{
    protected JPanel _mainPanel = new JPanel(new GridLayout(5, 2));
    protected BinaryMod[] _availableMod = {BinaryMod.Binary_Decimal_Convertor, BinaryMod.Binary_Calculator};
    protected JComboBox<BinaryMod> _modChoice = new JComboBox<BinaryMod>(_availableMod);

//======================================================================================

    public BinaryDecimalConverter() {
        this.setBDCProperties();
        _modChoice.setSize(new Dimension(this.getWidth(), 500));
        this._mainPanel.add(_modChoice);
        if(this._modChoice.getSelectedItem().equals(BinaryMod.Binary_Decimal_Convertor)) this.loadBDC();
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
        JPanel _displayerPanel = new JPanel(new GridLayout(2, 2));
        JFormattedTextField _inputDisplayer = new JFormattedTextField(NumberFormat.getNumberInstance());
        JLabel _outputDisplayer = new JLabel();
        JSpinner _bitNumber = new JSpinner(new SpinnerNumberModel(4, 1, 256, 1));
        String[] _precision = {"16", "32", "64", "79", "128", "256"};
        JComboBox<String> _decimalPrecision = new JComboBox<String>(_precision);

        _inputDisplayer.addActionListener(this);
        
        _displayerPanel.add(_inputDisplayer);
        _displayerPanel.add(_bitNumber);
        _displayerPanel.add(_outputDisplayer);
        _displayerPanel.add(_decimalPrecision);
        this._mainPanel.add(_displayerPanel);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("text");
    }
}