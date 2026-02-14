//floating or integer

package mg.hr.enumeration;

public enum NumberType
{
    _INTEGER(0),
    _FLOAT(1);

    protected int _nbr;

    NumberType(int nbr)
    {
        this._nbr = nbr;
    }

    public int getNumberType()
    {
        return this._nbr;
    }
}