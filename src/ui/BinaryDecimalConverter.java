package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.plaf.DimensionUIResource;

import ui.enumeration.BinaryMod;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class BinaryDecimalConverter extends JFrame implements ActionListener, CaretListener {
    protected JPanel _mainPanel = new JPanel(new GridLayout(2, 1));
    protected JPanel IODisplayerPanel = new JPanel(new GridLayout(3, 2));

    protected JLabel _modChoiceLabel = new JLabel("make your choice");
    protected BinaryMod[] _availableMod = {BinaryMod.Binary_Decimal_Convertor, BinaryMod.Binary_Calculator};
    protected JComboBox<BinaryMod> _modChoice = new JComboBox<BinaryMod>(_availableMod);
    protected JLabel inputLabel = new JLabel("Input");
    protected JLabel outputLabel = new JLabel("Output");
    protected JLabel output = new JLabel("OUTPUT");
    protected JFormattedTextField input = new JFormattedTextField(NumberFormat.getNumberInstance());
    protected int inputCaretPosition = 0;

//======================================================================================

    public BinaryDecimalConverter() {
        this.setBDCProperties();
        this.loadIODisplayer();
        this.setIODisplayerProperties();      
        this._mainPanel.add(this.IODisplayerPanel);

        if(this._modChoice.getSelectedItem().equals(BinaryMod.Binary_Decimal_Convertor)) this.loadBDC();
    }

//======================================================================================

    public void setBDCProperties() {
        this.setTitle("Binary Decimal Converter");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new DimensionUIResource(500, 500));
        this.setContentPane(this._mainPanel);
        this.input.addCaretListener(this);
    }

//======================================================================================

    public void loadIODisplayer() {
        IODisplayerPanel.add(this._modChoiceLabel);
        IODisplayerPanel.add(this._modChoice);
        IODisplayerPanel.add(this.inputLabel);
        IODisplayerPanel.add(this.input);
        IODisplayerPanel.add(this.outputLabel);
        IODisplayerPanel.add(this.output);
    }

//======================================================================================

    public void setIODisplayerProperties() {
        this.input.setHorizontalAlignment(JTextField.RIGHT);
        this.output.setHorizontalAlignment(JTextField.RIGHT);
    }

//======================================================================================

    public void loadBDC() {
        JPanel InputPanel = new JPanel(new GridLayout(2, 1));
        JPanel NumberPanel = new JPanel(new GridLayout(4, 3));
        JPanel nullNumberPanel = new JPanel(new GridLayout(1, 1));

        for(int i = 9; i >= 0; i--) {
            JButton button = new JButton(""+i);
            button.addActionListener(this);
            NumberPanel.add(button);
        }
        JButton commaButton = new JButton(".");
        commaButton.addActionListener(this);
        NumberPanel.add(commaButton);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        nullNumberPanel.add(convertButton);

        InputPanel.add(NumberPanel);
        InputPanel.add(nullNumberPanel);

        _mainPanel.add(InputPanel);
    }

//======================================================================================

    @Override public void actionPerformed(ActionEvent event) {
        if((this.input.getText().contains(".")) && (event.getActionCommand().matches("[.]{1}"))) return;

        int caretPosition = this.inputCaretPosition;
        String currentInput = this.input.getText();
        String output = new String();
        String firstString = new String();
        String lastString = new String();

        for(int i = 0; i < caretPosition; i++) firstString += currentInput.charAt(i);
        for(int i = caretPosition; i < currentInput.length(); i++) lastString += currentInput.charAt(i);

        output += firstString;
        output += event.getActionCommand();
        output += lastString;

        System.out.println("first : " + firstString);
        System.out.println("last : " + lastString);

        if(!(event.getActionCommand().matches("Convert"))) this.input.setText(output);
        
        System.out.println("text : " + event.getActionCommand());
    }

//======================================================================================

    public void caretUpdate(CaretEvent event) {
        this.inputCaretPosition = event.getDot();
        System.out.println("caret position changed = " + event.getMark());
    }

//======================================================================================



}