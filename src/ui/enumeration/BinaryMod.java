package ui.enumeration;

public enum BinaryMod {
    _BDConv("Binary Decimal Convertor", 0),
    _BCalculator("Binary Calculator", 1);

    protected String _modName;
    protected int _modNumber;

    BinaryMod(String name, int number) {
        this._modName = name;
        this._modNumber = number;
    }

    public String getModName() { return this._modName; }
    public int getModNumber() { return this._modNumber; }
}