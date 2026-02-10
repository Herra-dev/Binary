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
        int j;
        int up = (_firstBinaryNumber.length < _secondBinaryNumber.length) ? _secondBinaryNumber.length : _firstBinaryNumber.length;
        _bitNumber = (_bitNumber > up) ? _bitNumber : up;
        byte result[] = new byte[_bitNumber];
        _firstBinaryNumber = _completeBinaryNumber(_firstBinaryNumber, _bitNumber);
        _secondBinaryNumber = _completeBinaryNumber(_secondBinaryNumber, _bitNumber);

        for(int i = _bitNumber - 1; i >= 0; i--)
        {
            a = _firstBinaryNumber[i];
            b = _secondBinaryNumber[i];

            //
            //all cases: |-- a == b: 
            //           |       |----- a == 0
            //           |       |----- a == 1
            //           |-- a != b
            //
            if((a == b)) 
            {
                if(a == 0) 
                    result[i] = 0;
                else if(a == 1)
                {
                    j = i;
                    result[i] = 0;
                    while(j > 0)
                    {
                        if(_firstBinaryNumber[--j] == 1)
                            _firstBinaryNumber[j] = 0;
                        else break;
                    }
                    if(j >= 0) _firstBinaryNumber[j] = 1;
                }
            }
            else result[i] = 1;
        }

        return result;
    }

//============================================================================
 
    private static byte[] _completeBinaryNumber(byte[] _number, int length)
    {
        byte tab[] = new byte[length];
        byte tab1[] = new byte[length];

        //
        //  for 8 bits number: 1101 -> 00001101
        //                       11 -> 00000011

        int j = 0, k = 0;
        for(int i = _number.length -1; i >= 0; i--) tab[j++] = _number[i];
        for(int i = _number.length; i < length; i++) tab[i] = 0;
        for(int i = tab.length - 1; i >= 0; i--) tab1[k++] = tab[i];

        return tab1;
    } 
}