package mg.hr.enumeration;

public enum FloatPrecision
{
    _HALF_PRECISION(16, 5),
    _SIMPLE_PRECISION(32, 8),
    _EXTENDED_SIMPLE_PRECISION(43, 11),
    _DUAL_PRECISION(64, 11),
    _EXTENDED_DUAL_PRECISION(79, 15),
    _QUADRUPLE_PRECISION(128, 15),
    _OCTUPLE_PRECISION(256, 19);

    protected int _precision;
    protected int _expNumber;
    protected int _biais;

    FloatPrecision(int precision, int expNumber)
    {
        this._precision = precision;
        this._expNumber = expNumber;
        this._biais = (int)(java.lang.StrictMath.pow(2, this._expNumber - 1) - 1);
    }

    public int getPrecision()
    {
        return this._precision;
    }

    public int getExpNumber()
    {
        return this._expNumber;
    }

    public int getBiais()
    {
        return this._biais;
    }
}