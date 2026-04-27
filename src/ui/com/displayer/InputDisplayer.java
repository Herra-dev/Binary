package ui.com.displayer;

import javax.swing.JTextField;

import interfaces.Observable;
import interfaces.Observer;

public class InputDisplayer extends JTextField implements Observable{
    public boolean _addObserver(Observer _observer) {
        return true;
    }

    public boolean _updateObserver(Object _obj) {
        return true;
    }
}