package ui.com.displayer;

import java.util.LinkedList;

import javax.swing.JFormattedTextField;

import interfaces.Observable;
import interfaces.Observer;

public class InputDisplayer extends JFormattedTextField implements Observable{

    LinkedList<Observer> _listObserver = new LinkedList<Observer>();

    public boolean _addObserver(Observer _observer) {
        this._listObserver.add(_observer);

        return true;
    }
    public boolean _updateObserver(Object _obj) {
        Integer i = 0;
        Double j = 0.0;
        if(this.getValue().getClass().equals(i.getClass())) { for(Observer obs: _listObserver) obs.update("INTEGER"); return true; }
        else if(this.getValue().getClass().equals(j.getClass())) { for(Observer obs: _listObserver) obs.update("DOUBLE"); return true; }

        return true;
    }
}