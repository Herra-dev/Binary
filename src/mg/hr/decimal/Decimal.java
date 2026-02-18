package mg.hr.decimal;

public abstract class Decimal 
{
    public static double _toDecimal(byte[] _bit)
    {
        //unsigned integer:
        //if(_bit[0] == 0) Unsigned
        //else Signed

        double _UInteger = _toDecimalUnsignedInteger(_bit);
        double _SInteger = _toDecimalSignedInteger(_bit);
        
        System.out.println("UInteger = " + _UInteger);
        System.out.println("SInteger = " + _SInteger);

        return 0;
    }

    private static double _toDecimalUnsignedInteger(byte[] _bit)
    {
        byte[] _bitUnsignedInteger = mg.hr.Binary._reverseBinary(_bit);
        int _UInteger = 0;
        for(int i = 0; i < _bitUnsignedInteger.length; i++)
        {
            if(_bitUnsignedInteger[i] == 1)
                _UInteger += java.lang.StrictMath.pow(2, i);
        }

        return _UInteger;
    }

    private static double _toDecimalSignedInteger(byte[] _bit)
    {
        boolean positive = (_bit[0] == 0) ? true : false;
        if(positive) return _toDecimalUnsignedInteger(_bit);

        byte[] _bitOne = new byte[_bit.length];

        for(byte i = 0; i < _bitOne.length; i++)
            _bitOne[i] = 0;
        _bitOne[_bitOne.length - 1] = 1;

        _bit = mg.hr.Binary._complementBinary(_bit);
        _bit = mg.hr.BinaryMath._addBinary(_bit, _bitOne, _bit.length);

        double _SInteger = _toDecimalUnsignedInteger(_bit);
        
        return -_SInteger;
    }
}