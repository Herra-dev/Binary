/**
 * USED TO TRANSFORM NUMBER IN DECIMAL TO BINARY
 */

package mg.hr;

import mg.hr.exception.BinaryException;

public abstract class Binary
{

/**
 * returns array of byte with length defined by the param _bitNumber
 * if _bitNumber is equals to 0, return immediatly an array of byte with length 0.
 *    
 * @param _number
 * @param _bitNumber
 * @return byte[] 
 * @throws mg.hr.exception.BinaryException
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
 * Same as before but _bitNumber is automatically setted depending to _number
 * 
 * @param _number
 * @return byte[] 
 * @throws mg.hr.exception.BinaryException
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
 * @param _number
 * @return int 
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
 * method used:
 * exemple: 
 *      for 98 in decimal, 
 *      98, 64 < 98 < 128, so 98 contains 64 = pow(2, 6),                     [keep 6]
 *      98 - 64 = 34, 32 < 34 < 64,  ---> 32 = pow(2, 5),                     [keep 5]
 *      34 - 32 = 2, ---> 2 = pow(2, 1).                                      [keep 1]
 * 
 *      result: 01100010 = 98
 * 
 * @param _number
 * @param _bitNumber
 * @return byte[]
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
 * For floating number, number of bit is usually represented in:
 *      - half precision            = 16 bits
 *      - simple precision          = 32 bits
 *      - extended simple precision = 48 bits
 *      - dual precision            = 64 bits
 *      - extended dual precision   = 79 bits
 *      - quadruple precision       = 128 bits
 *      - octuple precision         = 256 bits
 * 
 * @param _number
 * @param _bitNumber
 * @return
 */
    private static byte[] _toBinaryFloat(double _number, mg.hr.enumeration.FloatPrecision _Precision)
    {
        byte tab[] = new byte[_Precision.getPrecision()];

        //============================================================================
        // SIGN
        //============================================================================
        byte _sign = (_number > 0) ? (byte)0 : (byte)1; // SIGN
        
        //============================================================================
        // FLOOR
        //============================================================================
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

        //============================================================================
        // DECIMAL
        //============================================================================
        double _decimalPart = java.lang.StrictMath.abs(_number - (int)_number);
        byte[] _decimalPartBinary = new byte[_Precision.getPrecision()];
        
        int i = 0;
        while(_decimalPart != 0 && i < 32)
        {
            _decimalPart *= 2;  
            System.out.println(_decimalPart);          
            _decimalPartBinary[i++] = (byte)_decimalPart;
            _decimalPart -= (int)_decimalPart;
        }

        int exp = 0;
        for(exp = 0; exp < _floorBinary.length; exp++)
        {
            if(_floorBinary[exp] == 1)
                break;
        }

        int expIndex = exp;
        exp = (_floorBinary.length - 1) - exp;
        
        byte E[]  = null;
        try
        {
            E = toBinary(exp + 127);

            for(byte b: E)
                System.out.print(b);
            System.out.println();
            System.out.println(exp);
        }
        catch(BinaryException e)
        {
            e.printStackTrace();
        }
        
        int j = 0;
        tab[j] = _sign; // ========================== SIGN =============

        for(int k = 0; k < E.length; k++)
            tab[++j] = E[k]; // ===================== EXPONENT =========

        for(int k = expIndex + 1; k < _floorBinary.length; k++)
            tab[++j] = _floorBinary[k]; // ========== MANTISSA =========
        int k = 0;
        while (++j < 32)
        {
            tab[j] = _decimalPartBinary[k++]; // ==== MANTISSA =========
        }

        return tab;
    }

//============================================================================

/**
 * 
 * 
 * @param _number
 * @param _bitNumber
 * @return byte[]
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