package interfaces;

public interface Observable {
    public boolean _addObserver(Observer _observer);
    public boolean _updateObserver(Object _obj);
}