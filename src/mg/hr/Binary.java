/**
 * USED TO TRANSFORM NUMBER IN DECIMAL TO BINARY
 */

package mg.hr;

public abstract class Binary
{

/**
 * returns array of byte with length defined by the param _bitNumber
 * if _bitNumber is equals to 0, return immediatly an array of byte with length 0.
 *    
 * @param _number
 * @param _bitNumber
 * @return byte[] 
 */
    public static byte[] toBinary(double _number, int _bitNumber)
    {
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

        if(!_signed)
        {
            if(!_isFloat) return _toBinaryUnsignedInteger((long)_number, _bitNumber); // unsigned long
            else return _toBinaryUnsignedFloat(_number, _bitNumber); // unsigned float
        }
        else
        {
            if(!_isFloat) return _toBinarySignedInteger((long)_number, _bitNumber); // signed long
            else return _toBinarySignedFloat(_number, _bitNumber); // signed float
        }
    }

//============================================================================

/**
 * returns power of two close or equal to _number 
 * 
 * @param _number
 * @return int 
 */
    public static int _powerOfTwoClose(long _number)
    {
        int i = 1;
        int pow = 0;

        while((i *= 2) <= _number) pow++;

        return pow;
    }

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
        
        byte binaryReversed[] = new byte[_bitNumber];

        while(_numberCopy > 0)
        {
            int i = _powerOfTwoClose(_numberCopy);
            if(i < binaryReversed.length)
                binaryReversed[i] = 1;
            _numberCopy -= java.lang.StrictMath.pow(2, i);
        }

        byte binary[] = new byte[_bitNumber];
        int j = 0;
        for(int i = binaryReversed.length - 1; i >= 0; i--)
        {
            binary[j++] += binaryReversed[i];
        }

        return binary;
    }

//============================================================================

    private static byte[] _toBinaryUnsignedFloat(double _number, int _bitNumber)
    {
        byte tab[] = {5};
        System.out.println("positif - float");
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

    private static byte[] _toBinarySignedFloat(double _number, int _bitNumber)
    {
        byte tab[] = {5};
        System.out.println("negatif - float");
        return tab;
    }

//============================================================================

}