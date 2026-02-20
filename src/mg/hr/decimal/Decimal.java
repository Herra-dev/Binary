package mg.hr.decimal;

public abstract class Decimal 
{
//========================================================================================

    public static double _toDecimalUnsignedInteger(byte[] _bit)
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

//========================================================================================

    public static double _toDecimalSignedInteger(byte[] _bit)
    {

        byte[] _bitOne = new byte[_bit.length];

        for(byte i = 0; i < _bitOne.length; i++)
            _bitOne[i] = 0;
        _bitOne[_bitOne.length - 1] = 1;

        _bit = mg.hr.Binary._complementBinary(_bit);
        _bit = mg.hr.BinaryMath._addBinary(_bit, _bitOne, _bit.length);

        double _SInteger = _toDecimalUnsignedInteger(_bit);
        System.out.println("here");
        
        return -_SInteger;
    }

//========================================================================================

    public static double _toDecimalFloat(byte[] _bit)
    {
        boolean positive = (_bit[0] == 0) ? true : false; // SIGN
        double floor = _getFloorNumber(_bit);
        double decimalPart = _getDecimalPart(_bit);
        //============================================

        return (positive) ? (floor+decimalPart) : -(floor+decimalPart);
    }

//========================================================================================

    private static mg.hr.enumeration.FloatPrecision _getBinaryNumberPrecision(byte[] _bit)
    {
        short _bitNumber = (short)_bit.length;
        System.out.println("bit number = " + _bitNumber);
        mg.hr.enumeration.FloatPrecision _nbrPrecision = mg.hr.enumeration.FloatPrecision._HALF_PRECISION;
        switch (_bitNumber) {
            case 16:  _nbrPrecision = mg.hr.enumeration.FloatPrecision._HALF_PRECISION;              break;
            case 32:  _nbrPrecision = mg.hr.enumeration.FloatPrecision._SIMPLE_PRECISION;            break;
            case 48:  _nbrPrecision = mg.hr.enumeration.FloatPrecision._EXTENDED_SIMPLE_PRECISION;   break;
            case 64:  _nbrPrecision = mg.hr.enumeration.FloatPrecision._DUAL_PRECISION;              break;
            case 79:  _nbrPrecision = mg.hr.enumeration.FloatPrecision._EXTENDED_DUAL_PRECISION;     break;
            case 128: _nbrPrecision = mg.hr.enumeration.FloatPrecision._QUADRUPLE_PRECISION;         break;
            case 256: _nbrPrecision = mg.hr.enumeration.FloatPrecision._OCTUPLE_PRECISION;           break;
            default: break;
        }

        return _nbrPrecision;
    }

//========================================================================================

    private static double _getBinaryNumberExponent(byte[] _bit)
    {
        mg.hr.enumeration.FloatPrecision _nbrPrecision = _getBinaryNumberPrecision(_bit);
        byte[] _exponent = new byte[_nbrPrecision.getExpNumber()];
        for(int i = 0; i < _exponent.length; i++)
            _exponent[i] = _bit[i+1];
        
        return _toDecimalUnsignedInteger(_exponent);
    }

//========================================================================================

    private static double _getFloorNumber(byte[] _bit)
    {
        mg.hr.enumeration.FloatPrecision _precision = _getBinaryNumberPrecision(_bit);
        double _exponent = mg.hr.decimal.Decimal._getBinaryNumberExponent(_bit);
        boolean _expPositive = (_exponent >= _precision.getBiais()) ? true : false;
        _exponent -= _precision.getBiais();
        _exponent = (_expPositive) ? java.lang.StrictMath.abs(_exponent) : -(java.lang.StrictMath.abs(_exponent));

        if(!_expPositive) return 0;

        byte[] _floor = new byte[(int)_exponent+1];
        _floor[0] = 1;
        int start = _precision.getExpNumber() + 1;
        for(int i = 0; i < _exponent; i++)
            _floor[i + 1] = _bit[start++];

        return _toDecimalUnsignedInteger(_floor);
    }

//========================================================================================

    private static double _getDecimalPart(byte[] _bit)
    {
        mg.hr.enumeration.FloatPrecision _precision = _getBinaryNumberPrecision(_bit);
        double _exponent = _getBinaryNumberExponent(_bit);
        _exponent -= _precision.getBiais();
        byte _decimalPart[] = null;

        if(_exponent >= 0) // floor number, not null
        {
            short start = (short)(1 + _precision.getExpNumber() + _exponent);
            short _decimalPartBitNumber = 0;
            for(int i = start; i < _bit.length; i++) _decimalPartBitNumber++;
            _decimalPart = new byte[_decimalPartBitNumber];

            for(short i = 0; i < _decimalPart.length; i++)
                _decimalPart[i] = _bit[start++];

            double nbr = 0;
            for(short j = 0; j < _decimalPart.length; j++)
            {
                if(_decimalPart[j] == 1)
                    nbr += java.lang.StrictMath.pow(2, -(j+1));
            }

            return nbr;
            
        }
        else // floor number, null
        {
            short start = (short)(1 + _precision.getExpNumber() + _exponent);
            short _decimalPartBitNumber = 0;
            for(int i = start; i < _bit.length; i++) _decimalPartBitNumber++;
            _decimalPart = new byte[_decimalPartBitNumber];

            _exponent = java.lang.StrictMath.abs(_exponent);
            for(short i = 0; i < _exponent - 1; i++)
            {
                _decimalPart[i] = 0;
            }
            _decimalPart[(short)_exponent -1] = 1;

            short st = (short)((_precision.getExpNumber()));
            for(short i = (short)_exponent; i < _decimalPart.length; i++)
            {
                if(st++ > _bit.length)  break;
                _decimalPart[i] = _bit[st];
            }

            double nbr = 0;
            for(short j = 0; j < _decimalPart.length; j++)
            {
                if(_decimalPart[j] == 1)
                    nbr += java.lang.StrictMath.pow(2, -(j+1));
            }

            return nbr;
        }
    }
}