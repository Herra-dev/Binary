/**
 * USED TO TRANSFORM NUMBER IN DECIMAL TO BINARY
 */

package mg.hr;

import mg.hr.exception.BinaryException;

public abstract class Binary
{

/**
 * returns array of byte with length defined by the param _bitNumber<p>
 * if _bitNumber is equals to 0, return immediatly an array of byte with length 0.
 *    
 * @param _number {@code double}
 * @param _bitNumber {@code int}
 * @return {@code byte[] }
 * @throws mg.hr.exception.BinaryException if {@code _bitNumber} is a negative value
 * @see {@link mg.hr.Binary#toBinary(double)}
 */
    public static byte[] toBinary(double _number, int _bitNumber) throws mg.hr.exception.BinaryException
    {
        if(_bitNumber < 0) throw new mg.hr.exception.BinaryException();
        if(_bitNumber == 0) return new byte[0];

        byte tab[] = new byte[_bitNumber];
        
        //================
        // initialisation of the array to stock binary number with 0
        //================
        for(int i = 0; i < _bitNumber; i++)
            tab[i] = 0;
        
        if(_number == 0) return tab;    

        boolean _signed = (_number < 0) ? true : false; 
        double i = (_number - (int)_number); 

        // if i(result of the previous calcul) is between -1 and 1(both excluded) but not 0, _number is a floating number
        boolean _isFloat = (i > -1 && i < 1 && i != 0) ? true : false; 

        if(!_isFloat)
        {
            if(!_signed)
                return _toBinaryUnsignedInteger((long)_number, _bitNumber); // unsigned long
            else
                return _toBinarySignedInteger((long)_number, _bitNumber); // signed long
        }
        else
            return _toBinaryFloat(_number, mg.hr.enumeration.FloatPrecision._SIMPLE_PRECISION);

    }

//============================================================================

/**
 * Same as {@link #toBinary(double, int)} but the second parameter {@code _bitNumber} is automatically setted according to parameter {@code _number}'s value
 * 
 * @param _number {@code double}
 * @return an array - {@code byte[]} sequence of bit representing {@code _number} in binary 
 * @throws mg.hr.exception.BinaryException
 * @see mg.hr.Binary#toBinary(double, int)
 * @see mg.hr.Binary#_powerOfTwoCloseBottom(long)
 */
    public static byte[] toBinary(double _number) throws mg.hr.exception.BinaryException
    {
        return (_number > 0) 
            ? toBinary(_number, mg.hr.Binary._powerOfTwoCloseBottom((long)_number) + 1)
            : toBinary(_number, mg.hr.Binary._powerOfTwoCloseBottom((long)-(_number)) + 1);
    }

//============================================================================

    public static double toDecimal(byte[] _number,
        /*signed or unsigned number*/ mg.hr.enumeration.NumberSign sign,
        /*integer or floating number*/ mg.hr.enumeration.NumberType type)
    {
        /*
        * sign: _SIGNED   = 0
        *       _UNSIGNED = 1
        * type: _INTEGER  = 0
        *       _FLOAT    = 1
         */
        return (sign.getNumberSign() == 0) 
                ? ((type.getNumberType() == 0) ? _toDecimalSignedInteger() : _toDecimalSignedFloat())
                : ((type.getNumberType() == 0) ? _toDecimalUnsignedInteger() : _toDecimalUnsignedFloat());
    }

    private static double _toDecimalSignedInteger()
    {
        System.out.println("signed integer");
        return 5;
    }
    private static double _toDecimalSignedFloat()
    {
        System.out.println("signed float");
        return 5;
    }
    private static double _toDecimalUnsignedInteger()
    {
        System.out.println("unsigned integer");
        return 5;
    }
    private static double _toDecimalUnsignedFloat()
    {
        System.out.println("unsigned float");
        return 5;
    }

//============================================================================

/**
 * returns power of two close or equal to _number 
 * 
 * @param _number {@code long}
 * @return {@code int} 
 */
    public static int _powerOfTwoCloseBottom(long _number)
    {
        int i = 1;
        int pow = 0;

        while((i *= 2) <= _number) pow++;

        return pow;
    }

//============================================================================

    public static byte[] _complementBinary(byte[] _binary)
    {
        for(int i = 0; i < _binary.length; i++)
        {
            if(_binary[i] == 0) _binary[i] = 1;
            else _binary[i] = 0;
        }
        return _binary;
    }

//============================================================================

/**
 * returns {@code _number} in reverse.
 * <p>eg:
 * <p> - {@code 10111} becomes {@code 11101}
 * <p> - {@code 10001111} becomes {@code 11110001}
 * 
 * @param _number {@code byte[]}
 * @return byte[]
 */
    public static byte[] _reverseBinary(byte[] _number)
    {
        byte[] reversedBinary = new byte[_number.length];

        int j = _number.length;
        for(int i = 0; i < _number.length; i++)
        {
            reversedBinary[--j] = _number[i];
        }

        return reversedBinary;
    }

//============================================================================

/**
 * returns array of byte with length defined by the param _bitNumber
 * 
 * method used:<p>
 * exemple: 
 *      <p>for 98 in decimal, 
 *      <p>98, 64 < 98 < 128, so 98 contains {@code 64} = pow(2, 6),    {@code [keep 6]}
 *      <p>98 - 64 = 34, 32 < 34 < 64,  ---> {@code 32} = pow(2, 5),    {@code [keep 5]}
 *      <p>34 - 32 = 2, ---> {@code 2} = pow(2, 1).                     {@code [keep 1]}
 * <p><p>
 *      <p>{@code result: 01100010 = 98}
 * 
 * @param _number {@code long}
 * @param _bitNumber {@code int}
 * @return byte[]
 * @see mg.hr.Binary#_powerOfTwoCloseBottom(long)
 * @see mg.hr.Binary#_reverseBinary(byte[])
 */
    private static byte[] _toBinaryUnsignedInteger(long _number, int _bitNumber)
    {
        long _numberCopy = _number;
        int i = 0;
        byte binaryReversed[] = new byte[_bitNumber];

        while(_numberCopy > 0)
        {
            i = _powerOfTwoCloseBottom(_numberCopy);
            if(i < binaryReversed.length)
                binaryReversed[i] = 1;
            
            _numberCopy -= java.lang.StrictMath.pow(2, i);
        }

        return _reverseBinary(binaryReversed);
    }

//============================================================================

/**
 * returns {@code 0} if {@code _number} is positive, returns {@code -1} otherwise
 * 
 * @param _number {@code double}
 * @return {@code byte}
 */
    private static byte _binarySign(double _number)
    {
        return ((int)_number >= 0) ? (byte)0 : (byte)1;
    }

/**
 * returns an array of byte representing the {@code floor} of a real number
 * 
 * @param _number {@code double}
 * @return byte[]
 */
    private static byte[] _floor(double _number)
    {
        byte _floorBinary[] = null;
        try
        {
            int _numberAbsValue = (int)java.lang.StrictMath.abs(_number);
            _floorBinary = mg.hr.Binary.toBinary(_numberAbsValue); // _floorBinary of _number in binary mode
        } 
        catch (mg.hr.exception.BinaryException e)
        {
            e.printStackTrace();
        }

        return _floorBinary;
    }

/**
 * returns an array of byte representing the decimal part of a real number
 * 
 * @param _decimalPart {@code double}
 * @param _precision {@link mg.hr.enumeration.FloatPrecision}
 * @return byte[]
 */
    private static byte[] _decimal(double _decimalPart, mg.hr.enumeration.FloatPrecision _precision)
    {
        byte[] _decimalPartBinary = new byte[_precision.getPrecision()];
        int i = 0;
        while(_decimalPart != 0 && i < _decimalPartBinary.length)
        {
            _decimalPart *= 2;         
            _decimalPartBinary[i++] = (byte)_decimalPart;
            _decimalPart -= (int)_decimalPart;
        }

        return _decimalPartBinary;
    }

/**
 * returns an array of short exponent information is stored
 * 
 * @param _number {@code double}
 * @param _floorBinary {@code byte[]}
 * @param _decimalPartBinary {@code byte[]}
 * @return short[]
 */
    private static short[] _exp(double _number, byte[] _floorBinary, byte[] _decimalPartBinary)
    {
        short exp[] = new short[2];

        int exp_d = 0;
        int expIndex = 0;
        _number = java.lang.StrictMath.abs(_number);
        if((int)_number > 0)
        {
            for(exp_d = 0; exp_d < _floorBinary.length; exp_d++)
            {
                if(_floorBinary[exp_d] == 1) // search first bit 1
                {
                    ++exp_d; // if 1 was found in index 0 for example, the comma place is in the next index
                    break;
                }
            }
            expIndex = exp_d;
            exp_d = _floorBinary.length - exp_d; // distance between _floorBinary and exp_d
        }
        else if((int)_number == 0)
        {
            for(exp_d = 0; exp_d < _decimalPartBinary.length; exp_d++)
            {
                if(_decimalPartBinary[exp_d] == 1)
                    break;
            }
            expIndex = exp_d;
            exp_d = -(exp_d + 1);
        }

        exp[0] = (short)exp_d;
        exp[1] = (short)expIndex;

        return exp;
    }

/**
 * returns an array of byte representing {@code _number} in {@code binary}
 * <p><p>
 * For floating number, number of bit is usually represented in:
 *      <p>- half precision            = {@code 16 bits}
 *      <p>- simple precision          = {@code 32 bits}
 *      <p>- extended simple precision = {@code 48 bits}
 *      <p>- dual precision            = {@code 64 bits}
 *      <p>- extended dual precision   = {@code 79 bits}
 *      <p>- quadruple precision       = {@code 128 bits}
 *      <p>- octuple precision         = {@code 256 bits}
 * 
 * 
 * @param _number {@code double}
 * @param _precision {@code mg.hr.enumeration.FloatPrecision}
 * @return
 * @see mg.hr.enumeration.FloatPrecision
 */
    private static byte[] _toBinaryFloat(double _number, mg.hr.enumeration.FloatPrecision _Precision)
    {
        byte tab[] = new byte[_Precision.getPrecision()];

        byte _sign = _binarySign(_number); // SIGN
        byte _floorBinary[] = _floor(_number); // FLOOR
        byte[] _decimalPartBinary = _decimal(java.lang.StrictMath.abs(_number - (int)_number), _Precision); //DECIMAL PART

        //============================================================================
        
        short[] __ = _exp(_number, _floorBinary, _decimalPartBinary);
        short exp = __[0];
        short expIndex = __[1];

        byte E[]  = null;
        try
        {
            int l = exp + _Precision.getBiais();
            E = toBinary(l, _Precision.getExpNumber());
            System.out.println("exposant = " + l);
        }
        catch(BinaryException e)
        {
            e.printStackTrace();
        }
        //=========================================================================

        int j = 0;
        tab[j] = _sign; // ========================== SIGN =============

        for(int k = 0; k < E.length; k++)
            tab[++j] = E[k]; // ===================== EXPONENT =========

        if((int)_number != 0)
        {
            for(int k = expIndex; k < _floorBinary.length; k++)
            tab[++j] = _floorBinary[k]; // ========== MANTISSA =========
            int k = 0;
            while (++j < tab.length)
            {
                tab[j] = _decimalPartBinary[k++]; // ==== MANTISSA =========
            }
        }
        else
        {
            int k = expIndex;
            while (++j < tab.length) 
            {
                tab[j] = _decimalPartBinary[++k];
            }
        }
        
        return tab;
    }

//============================================================================

/**
 * return an array of byte representing {@code _number} who is: 
 * <p> - {@code signed}
 * <p> - {@code not a floating number}
 * in binary
 * 
 * @param _number {@code long}
 * @param _bitNumber {@code int}
 * @return byte[]
 * @see mg.hr.Binary#_toBinaryUnsignedInteger(long, int)
 */
    private static byte[] _toBinarySignedInteger(long _number, int _bitNumber)
    {
        byte tab[] = new byte[_bitNumber];
        byte tab1[] = new byte[_bitNumber];

        tab = _toBinaryUnsignedInteger(-(_number), _bitNumber);
        tab  = mg.hr.Binary._complementBinary(tab);

        tab1[_bitNumber-1] = 1;
        tab = mg.hr.BinaryMath._addBinary(tab, tab1, _bitNumber);
        return tab;
    }

//============================================================================

}