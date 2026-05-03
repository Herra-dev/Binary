package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import mg.hr.Binary;
import mg.hr.enumeration.FloatPrecision;
import mg.hr.exception.BinaryException;
import ui.enumeration.BinaryMod;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class BinaryDecimalConverter extends JFrame implements ActionListener {
    protected JPanel _mainPanel = new JPanel(new GridLayout(2, 1)); // The main container of the window
    protected JPanel IODisplayerPanel = new JPanel(new GridLayout(3, 2));

    protected JLabel _modChoiceLabel = new JLabel("make your choice");
    protected BinaryMod[] _availableMod = {BinaryMod.Binary_Decimal_Convertor, BinaryMod.Binary_Calculator};
    protected JComboBox<BinaryMod> _modChoice = new JComboBox<BinaryMod>(_availableMod);
    protected JPanel _userInputPanel = new JPanel(new BorderLayout());
    protected JLabel _inputLabel = new JLabel("Input");
    protected JLabel _outputLabel = new JLabel("Output");
    protected JTextArea _output = new JTextArea();
    protected JTextField _input = new JTextField();

    protected JTextField _secInput = new JTextField();
    protected String[] _availableSign = {"+", "-", "*", "/"};
    protected JComboBox<String> _sign = new JComboBox<String>(_availableSign);
    protected JLabel _errorLabel = new JLabel("Error");
    protected JSpinner _bitNumber = new JSpinner(new SpinnerNumberModel(4, 1, 256, 1));
    protected FloatPrecision[] _availablePrecision = {FloatPrecision._HALF_PRECISION, FloatPrecision._SIMPLE_PRECISION, FloatPrecision._EXTENDED_SIMPLE_PRECISION,
                                                         FloatPrecision._DUAL_PRECISION, FloatPrecision._EXTENDED_DUAL_PRECISION, FloatPrecision._QUADRUPLE_PRECISION,
                                                            FloatPrecision._OCTUPLE_PRECISION,};
    
    protected JComboBox<FloatPrecision> _floatPrecision = new JComboBox<FloatPrecision>(_availablePrecision);
    protected JButton _convert = new JButton("Convert");
    protected BigDecimal number = BigDecimal.ZERO;
    protected String result = new String();

//======================================================================================

    public BinaryDecimalConverter() {
        this.setBDCProperties();            // Setting the main app properties
        this.loadIODisplayer();             // Load Input and Output displayer
        this.setIODisplayerProperties();

        this.addToMainPanel();
        this.addListener();

        this._input.setFocusable(true);
        this._secInput.setFocusable(true);


        // if(this._modChoice.getSelectedItem().equals(BinaryMod.Binary_Decimal_Convertor)) this.loadBDC();
        this.loadBCalculator();
    }

//======================================================================================

    public void addListener() {
        this._convert.addActionListener(new buttonConvertListener());
    }

//======================================================================================

    public void addToMainPanel() {
        this._mainPanel.add(this.IODisplayerPanel);
    }

//======================================================================================

    public void setBDCProperties() {
        this.setTitle("Decimal Binary Converter");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new DimensionUIResource(500, 500));
        this.setContentPane(this._mainPanel);
        this.setMinimumSize(new Dimension(500, 700));
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
        this._modChoiceLabel.setFont(new Font("Times New Romance", 2, 25));

        this._inputLabel.setFont(new Font("Times New Romance", 2, 25));
        this._input.setHorizontalAlignment(JTextField.RIGHT);

        this._outputLabel.setFont(new Font("Times New Romance", 2, 25));
        this._output.setEditable(false);
        this._output.setLineWrap(true);
        this._output.setAutoscrolls(true);
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
            button.setFont(new Font("Times New Romance", 1, 25));
            NumberPanel.add(button);
        }
        JButton commaButton = new JButton(".");
        commaButton.addActionListener(this);
        commaButton.setFont(new Font("Times New Roman", 1, 20));
        commaButton.setToolTipText("Comma");
        NumberPanel.add(commaButton);

        JButton minusSignButton = new JButton("-");
        minusSignButton.addActionListener(this);
        minusSignButton.setFont(new Font("Times New Roman", 1, 20));
        minusSignButton.setToolTipText("Minus sign");
        NumberPanel.add(minusSignButton);

        JButton buttonTest = new JButton("Test input");
        buttonTest.addActionListener(new buttonInputTesterListener());
        buttonTest.setFont(new Font("Times New Roman", 1, 25));
        controlNumberPanel.add(buttonTest);

        JButton buttonBackspace = new JButton("Backspace");
        buttonBackspace.addActionListener(new buttonBackspaceListener());
        buttonBackspace.setToolTipText("Delete before caret");
        buttonBackspace.setForeground(Color.ORANGE);
        buttonBackspace.setFont(new Font("Times New Roman", 1, 20));
        controlNumberPanel.add(buttonBackspace);

        JButton buttonDelete = new JButton("Delete");
        buttonDelete.addActionListener(new buttonDeleteListener());
        buttonDelete.setToolTipText("Delete after caret");
        buttonDelete.setForeground(Color.ORANGE);
        buttonDelete.setFont(new Font("Times New Roman", 1, 20));
        controlNumberPanel.add(buttonDelete);

        JButton buttonClear = new JButton("Clear");
        buttonClear.addActionListener(new buttonClearListener());
        buttonClear.setToolTipText("Clear the actual input");
        buttonClear.setForeground(Color.RED);
        buttonClear.setFont(new Font("Times New Roman", 1, 25));
        controlNumberPanel.add(buttonClear);


        testerPanel.add(_errorLabel);
        testerPanel.add(_bitNumber); _bitNumber.setEnabled(false);
        testerPanel.add(_floatPrecision); _floatPrecision.setEnabled(false);
        testerPanel.add(_convert); _convert.setEnabled(false);

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
        if((this._input.getText().contains(".")) && (event.getActionCommand().matches("[.]{1}"))) return; // if input contains already a comma (".") and user enter comma, quit function
        if((this._input.getText().contains("-")) && (event.getActionCommand().matches("[-]{1}"))) return; // if input contains already a minus sign ("-") and user enter comma, quit function
        
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

        if((event.getActionCommand().matches("[0-9]++|[.]{1}|[-]{1}"))) {
            this._input.setText(_output);

            try {
                this._input.moveCaretPosition(caretPosition+1); // Move caret position to its current position + 1
            }catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

// CLASS =============================================

    class buttonConvertListener implements ActionListener {
        @Override public void actionPerformed(ActionEvent event) {
            byte[] arrayResult;
            try {
                if(_input.getText().contains(".")) {
                    System.out.println("Number = " + number);
                    arrayResult = Binary._toBinaryFloat(number, (FloatPrecision)_floatPrecision.getSelectedItem());
                } else {
                    System.out.println("Number = " + number);
                    arrayResult = Binary.toBinary(number, (int)_bitNumber.getValue());
                }
                result = Binary.byteArrayToString(arrayResult);
            } catch (BinaryException e) {
                e.printStackTrace();
            }

            _output.setFont(new Font("Arial", 1, 20));
            _output.setText(result);
            _convert.setEnabled(false);
            _bitNumber.setEnabled(false);
            _floatPrecision.setEnabled(false);
        }
    }

//======================================================================================

    class buttonInputTesterListener implements ActionListener {
        @Override public void actionPerformed(ActionEvent event) {
            if(_input.getText().isEmpty()) return;

            if(_input.getText().matches("[-]*+[0-9]*+[.]*+[0-9]*+") && 
                    !(_input.getText().matches("[-]{1}")) && 
                        (herra.string.HString.occ(_input.getText(), '-') <= 1) && 
                            (herra.string.HString.occ(_input.getText(), '.') <= 1)) {
                _errorLabel.setText("Valid input");
                _errorLabel.setForeground(Color.GREEN);
                _errorLabel.setFont(new Font("MathJax", 1, 20));

                if(_input.getText().contains(".")) { // if input contains a comma '.', it is a floating point number
                    _bitNumber.setEnabled(false);
                    _floatPrecision.setEnabled(true);
                    _convert.setEnabled(true);

                    try {
                        number = new BigDecimal(_input.getText());
                    }catch(NullPointerException | NumberFormatException e) {
                        e.printStackTrace();
                    }

                }
                else {                    
                    _bitNumber.setEnabled(true);
                    _floatPrecision.setEnabled(false);
                    _convert.setEnabled(true);

                    try {
                        number = new BigDecimal(_input.getText());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                
            } else {
                _errorLabel.setText("Invalid input");
                _errorLabel.setForeground(Color.RED);
                _errorLabel.setFont(new Font("MathJax", 1, 20));

                _bitNumber.setEnabled(false);
                _floatPrecision.setEnabled(false);
                _convert.setEnabled(false);
            }
        }
    }

//======================================================================================

    class buttonBackspaceListener implements ActionListener {
        @Override public void actionPerformed(ActionEvent event) {
            int caretPosition = _input.getCaretPosition();
            String currentInput = _input.getText();

            if(caretPosition <= 0) return; 
            String firstString = currentInput.substring(0, caretPosition-1);
            String lastString = currentInput.substring(caretPosition, currentInput.length());
            String output = firstString + lastString;
            _input.setText(output);

            try {
                _input.moveCaretPosition(caretPosition-1); // Move caret position to its current position - 1
            }catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

//======================================================================================

    class buttonDeleteListener implements ActionListener {
        @Override public void actionPerformed(ActionEvent event) {
            int caretPosition = _input.getCaretPosition();
            String currentInput = _input.getText();

            if(caretPosition >= currentInput.length()) return; // if caret is placed in the end of the text field, quit function
            String firstString = currentInput.substring(0, caretPosition);
            String lastString = currentInput.substring(caretPosition+1, currentInput.length());
            String output = firstString + lastString;
            _input.setText(output);

            try {
                _input.moveCaretPosition(caretPosition); // Do not move caret position
            }catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

//======================================================================================

    class buttonClearListener implements ActionListener {
        @Override public void actionPerformed(ActionEvent event) {
            _input.setText(new String());
        }
    }

//======================================================================================

}