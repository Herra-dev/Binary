package mg.hr.enumeration;

public enum FloatPrecision
{
    _HALF_PRECISION(16),
    _SIMPLE_PRECISION(32),
    _EXTENDED_SIMPLE_PRECISION(43),
    _DUAL_PRECISION(64),
    _EXTENDED_DUAL_PRECISION(79),
    _QUADRUPLE_PRECISION(128),
    _OCTUPLE_PRECISION(256);

    protected int _precision;

    FloatPrecision(int precision)
    {
        this._precision = precision;
    }

    public int getPrecision()
    {
        return this._precision;
    }
}