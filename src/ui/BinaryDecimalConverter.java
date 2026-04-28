package ui;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import ui.enumeration.BinaryMod;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class BinaryDecimalConverter extends JFrame implements ActionListener {
    protected JPanel _mainPanel = new JPanel(new BorderLayout());
    protected BinaryMod[] _availableMod = {BinaryMod.Binary_Decimal_Convertor, BinaryMod.Binary_Calculator};
    protected JComboBox<BinaryMod> _modChoice = new JComboBox<BinaryMod>(_availableMod);
    protected JPanel IODisplayerPanel = new JPanel(new GridLayout(2, 2));
    protected JLabel inputLabel = new JLabel("Input");
    protected JLabel outputLabel = new JLabel("Output");
    protected JLabel output = new JLabel();
    protected JFormattedTextField input = new JFormattedTextField(NumberFormat.getCompactNumberInstance());

//======================================================================================

    public BinaryDecimalConverter() {
        this.setBDCProperties();
        this.loadIODisplayer();

        this._mainPanel.add(_modChoice, BorderLayout.NORTH);
        this._mainPanel.add(IODisplayerPanel, BorderLayout.CENTER);


        // if(this._modChoice.getSelectedItem().equals(BinaryMod.Binary_Decimal_Convertor)) this.loadBDC();
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

    public void loadIODisplayer() {
        IODisplayerPanel.add(inputLabel);
        IODisplayerPanel.add(input);
        IODisplayerPanel.add(outputLabel);
        IODisplayerPanel.add(output);
    }

    public void loadBDC() {
        
    }

//======================================================================================

    public void actionPerformed(ActionEvent e) {
        System.out.println("text");
    }
}