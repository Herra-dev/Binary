package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import ui.enumeration.BinaryMod;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

    protected JTextField _secInput = new JTextField();
    protected String[] _availableSign = {"+", "-", "*", "/"};
    protected JComboBox<String> _sign = new JComboBox<String>(_availableSign);
    protected JLabel _errorLabel = new JLabel("Error");
    protected SpinnerNumberModel _bitNumber = new SpinnerNumberModel(1, 1, 256, 1);
    protected Integer[] _availablePrecision = {16, 32, 48, 64, 79, 128, 256};
    protected JComboBox<Integer> _floatPrecision = new JComboBox<Integer>(_availablePrecision);

//======================================================================================

    public BinaryDecimalConverter() {
        this.setBDCProperties();
        this.loadIODisplayer();
        this.setIODisplayerProperties();      
        this._mainPanel.add(this.IODisplayerPanel);

        this._input.setFocusable(true);
        this._secInput.setFocusable(true);


        if(this._modChoice.getSelectedItem().equals(BinaryMod.Binary_Decimal_Convertor)) this.loadBDC();
    }

//======================================================================================

    public void setBDCProperties() {
        this.setTitle("Decimal Binary Converter");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new DimensionUIResource(500, 500));
        this.setContentPane(this._mainPanel);
        
    }

//======================================================================================

    public void loadIODisplayer() {
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
        _userInputPanel.add(_input); // A JTextField to get user input

        JPanel InputPanel = new JPanel(new GridLayout(3, 1));
        JPanel NumberPanel = new JPanel(new GridLayout(4, 3));
        JPanel controlNumberPanel = new JPanel(new GridLayout(2, 4));
        JPanel testerPanel = new JPanel(new GridLayout(2, 2));

        for(int i = 9; i >= 0; i--) {
            JButton button = new JButton(""+i);
            button.addActionListener(this);
            NumberPanel.add(button);
        }
        JButton commaButton = new JButton(".");
        commaButton.addActionListener(this);
        NumberPanel.add(commaButton);

        String controlArray[] = {"Test input", "Delete", "Backspace", "Clear"};

        for(int i = 0; i < controlArray.length; i++) {
            JButton convertButton = new JButton(controlArray[i]);
            convertButton.addActionListener(this);
            controlNumberPanel.add(convertButton);
        }

        testerPanel.add(_errorLabel);
        // testerPanel.add(_bitNumber);

        InputPanel.add(NumberPanel);
        InputPanel.add(controlNumberPanel);
        InputPanel.add(testerPanel);

        _mainPanel.add(InputPanel);
    }

//======================================================================================

    public void loadBCalculator() {
        _userInputPanel.add(_input, BorderLayout.NORTH);
        _userInputPanel.add(_sign, BorderLayout.WEST);
        _userInputPanel.add(_secInput, BorderLayout.SOUTH);

        JPanel container = new JPanel(new GridLayout(2, 3));
        String[] str = {"0", "1", "=", "Backspace", "Delete", "Clear"};
        for(int i = 0; i < str.length; i++) {
            JButton button = new JButton(str[i]);
            button.addActionListener(this);
            button.setFont(new Font("Z003", 1, 30));
            container.add(button);
        }
        _mainPanel.add(container);
    }

//======================================================================================

    @Override public void actionPerformed(ActionEvent event) {

        if(this._input.isFocusOwner()) System.out.println("Focus owner is     :  _input");
        if(this._secInput.isFocusOwner()) System.out.println("Focus owner is  :  _secInput");


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

        if(event.getActionCommand().matches("Delete")) {
            if(caretPosition >= currentInput.length()) return;
            firstString = currentInput.substring(0, caretPosition);
            lastString = currentInput.substring(caretPosition+1, currentInput.length());
            _output = firstString + lastString;
            this._input.setText(_output);

            try {
                this._input.moveCaretPosition(caretPosition); // Do not move caret position
            }catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        
        if(event.getActionCommand().matches("Backspace")) {
            if(caretPosition <= 0) return;
            firstString = currentInput.substring(0, caretPosition-1);
            lastString = currentInput.substring(caretPosition, currentInput.length());
            _output = firstString + lastString;
            this._input.setText(_output);

            try {
                this._input.moveCaretPosition(caretPosition-1); // Move caret position to its current position - 1
            }catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        if(event.getActionCommand().matches("Test input")) {
            JPanel controllerPanel = new JPanel(new GridLayout(3, 1));
        if(currentInput.matches("[0-9]++|[.]{1}")) {
                _errorLabel.setText("Invalid input");
                _errorLabel.setForeground(Color.RED);
                controllerPanel.add(_errorLabel);
                System.out.println("in not error");
            } else {
                _errorLabel.setText("Invalid input");
                _errorLabel.setForeground(Color.RED);
                controllerPanel.add(_errorLabel);
                System.out.println("in error");
            }

            _mainPanel.add(controllerPanel);
        }

    }

//======================================================================================



}