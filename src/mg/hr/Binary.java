/**
 * USED TO TRANSFORM NUMBER IN DECIMAL TO BINARY
 */

package mg.hr;

public abstract class Binary
{

/**
 * if _bitNumber is equals to 0, return immediatly an array of byte with length 0.
 * 
 * method used:
 *      exemple: for 98 in decimal,  64 < 98 < 128, so 98 contains 64 = pow(2, 6),
 *      
 * 
 * @param _number
 * @param _bitNumber
 * @return array of byte with length defined by the param _bitNumber
 */
    public static byte[] toBinary(double _number, int _bitNumber)
    {
        if(_bitNumber == 0) return new byte[0];

        byte tab[] = new byte[_bitNumber];
        
        //================
        // initialisation of the array to stock binary number
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
            if(!_isFloat) return _toBinaryUnsignedInteger((int)_number, _bitNumber); // unsigned integer
            else return _toBinaryUnsignedFloat(_number, _bitNumber); // unsigned float
        }
        else
        {
            if(!_isFloat) return _toBinarySignedInteger(_number, _bitNumber); // signed integer
            else return _toBinarySignedFloat(_number, _bitNumber); // signed float
        }
    }

//============================================================================

    public static int _powerOfTwoClose(int _number)
    {
        int i = 1;
        int pow = 0;

        while((i *= 2) <= _number) pow++;

        return pow;
    }

//============================================================================

    private static byte[] _toBinaryUnsignedInteger(int _number, int _bitNumber)
    {
        int _numberCopy = _number;
        
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

    private static byte[] _toBinarySignedInteger(double _number, int _bitNumber)
    {
        byte tab[] = {5};
        System.out.println("negatif - integer");
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