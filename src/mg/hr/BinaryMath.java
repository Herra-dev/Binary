package mg.hr;

public abstract class BinaryMath
{
    /**
     * if _bitNumber is inferior of _firstBinaryNumber.length or _secondBinaryNumber.length,
     * it will be set to the superior between _firstBinaryNumber.length and _secondBinaryNumber.length
     * 
     * @param _firstBinaryNumber
     * @param _secondBinaryNumber
     * @param _bitNumber
     * 
     * @return array of byte with length defined by the param _bitNumber
     */
    public static byte[] _addBinary(byte[] _firstBinaryNumber, byte[] _secondBinaryNumber, int _bitNumber)
    {
        byte a, b;
        int j, up = (_firstBinaryNumber.length < _secondBinaryNumber.length) ? _secondBinaryNumber.length : _firstBinaryNumber.length;
        _bitNumber = (_bitNumber > up) ? _bitNumber : up;
        byte result[] = new byte[_bitNumber];
        _firstBinaryNumber = _completeBinaryNumber(_firstBinaryNumber, _bitNumber);
        _secondBinaryNumber = _completeBinaryNumber(_secondBinaryNumber, _bitNumber);

        for(int i = _bitNumber - 1; i >= 0; i--)
        {
            a = _firstBinaryNumber[i];
            b = _secondBinaryNumber[i];

            if((a == b)) //---------------------------------// case where a == b 
            {
                if(a == 0) 
                    result[i] = 0;
                else if(a == 1)
                {
                    j = i;
                    result[i] = 0;
                    while(--j >= 0)
                    {
                        if(_firstBinaryNumber[j] == 1)
                            _firstBinaryNumber[j] = 0;
                        else
                        {
                            _firstBinaryNumber[j] = 1;
                            break;
                        }
                    }
                }
            }
            else result[i] = 1;
        }

        return result;
    }

//============================================================================

/**
 * used to complete a binary number with 0 in the left, example:
 * for a number in 8 bits(length) : 1011 become 00001011, 1 become 00000001
 * 
 * @param _number
 * @param length
 * @return array of byte with length defined by param length
 */
    private static byte[] _completeBinaryNumber(byte[] _number, int length)
    {
        byte tab[] = new byte[length]; // array to stock the reverse of the binary number to complete
        byte tab1[] = new byte[length]; // array to stock the binary number completed

        int j = 0, k = 0;
        for(int i = _number.length -1; i >= 0; i--) tab[j++] = _number[i]; // reversing the binary number and stock it into tab
        for(int i = _number.length; i < length; i++) tab[i] = 0; // adding 0 in tab starting from last bit reversed index until length - 1 
        for(int i = tab.length - 1; i >= 0; i--) tab1[k++] = tab[i]; // reversing tab and stock it to tab1

        return tab1;
    } 
}