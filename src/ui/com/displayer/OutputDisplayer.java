package ui.com.displayer;

import javax.swing.JLabel;

import interfaces.Observer;

public class OutputDisplayer extends JLabel implements Observer{
    public boolean update(Object _obj) {
        return true;
    }
}