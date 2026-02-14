//signed or unsigned

package mg.hr.enumeration;

public enum NumberSign
{
    _SIGNED(0),
    _UNSIGNED(1);

    protected int _nbr;

    NumberSign(int nbr)
    {
        this._nbr = nbr;
    }

    public int getNumberSign()
    {
        return this._nbr;
    }
}