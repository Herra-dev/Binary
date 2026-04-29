package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import ui.enumeration.BinaryMod;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryDecimalConverter extends JFrame implements ActionListener {
    protected JPanel _mainPanel = new JPanel(new GridLayout(2, 1));
    protected JPanel IODisplayerPanel = new JPanel(new GridLayout(3, 2));

    protected JLabel _modChoiceLabel = new JLabel("make your choice");
    protected BinaryMod[] _availableMod = {BinaryMod.Binary_Decimal_Convertor, BinaryMod.Binary_Calculator};
    protected JComboBox<BinaryMod> _modChoice = new JComboBox<BinaryMod>(_availableMod);
    protected JPanel _userInputPanel = new JPanel(new BorderLayout());
    protected JLabel _inputLabel = new JLabel("Input");
    protected JLabel _outputLabel = new JLabel("_output");
    protected JLabel _output = new JLabel("_output");
    protected JTextField _input = new JTextField();

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
        
    }

//======================================================================================

    public void loadIODisplayer() {
        _userInputPanel.add(_input);

        IODisplayerPanel.add(this._modChoiceLabel);
        IODisplayerPanel.add(this._modChoice);
        IODisplayerPanel.add(this._inputLabel);
        IODisplayerPanel.add(this._userInputPanel);
        IODisplayerPanel.add(this._outputLabel);
        IODisplayerPanel.add(this._output);
    }

//======================================================================================

    public void setIODisplayerProperties() {
        this._input.setHorizontalAlignment(JTextField.RIGHT);
        this._output.setHorizontalAlignment(JTextField.RIGHT);
    }

//======================================================================================

    public void loadBDC() {
        JPanel InputPanel = new JPanel(new GridLayout(2, 1));
        JPanel NumberPanel = new JPanel(new GridLayout(4, 3));
        JPanel controlNumberPanel = new JPanel(new GridLayout(1, 4));

        for(int i = 9; i >= 0; i--) {
            JButton button = new JButton(""+i);
            button.addActionListener(this);
            NumberPanel.add(button);
        }
        JButton commaButton = new JButton(".");
        commaButton.addActionListener(this);
        NumberPanel.add(commaButton);

        String controlArray[] = {"test Input", "Supp -->", "<-- supp", "Clear"};

        for(int i = 0; i < controlArray.length; i++) {
            JButton convertButton = new JButton(controlArray[i]);
            convertButton.addActionListener(this);
            controlNumberPanel.add(convertButton);
        }

        InputPanel.add(NumberPanel);
        InputPanel.add(controlNumberPanel);

        _mainPanel.add(InputPanel);
    }

//======================================================================================

    @Override public void actionPerformed(ActionEvent event) {
        if((this._input.getText().contains(".")) && (event.getActionCommand().matches("[.]{1}"))) return; // if input contains already a comma (".") and user enter comma, quit function
        if(event.getActionCommand().matches("Clear")) { this._input.setText(new String()); return; } // Clear input and quit function

        int caretPosition = this._input.getCaretPosition();
        String currentInput = this._input.getText();
        String _output = new String();
        String firstString = new String();
        String lastString = new String();

        firstString = currentInput.substring(0, caretPosition);
        lastString = currentInput.substring(caretPosition, currentInput.length());

        _output += firstString;
        _output += event.getActionCommand();
        _output += lastString;

        if((event.getActionCommand().matches("[0-9]++|[.]{1}"))) {
            this._input.setText(_output);

            try {
                this._input.moveCaretPosition(caretPosition+1); // Move caret position to its current position + 1
            }catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        
        
    }

//======================================================================================



}