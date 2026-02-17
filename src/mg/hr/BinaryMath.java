package mg.hr;

public abstract class BinaryMath
{

/**
 * add _firstNumber to _secondNumber and returns result in binary.
 *  
 * @param _firstNumber {@code double}
 * @param _secondNumber {@code double}
 * @param _bitNumber {@code int}
 * 
 * @return byte[]
 * @see mg.hr.BinaryMath#_subtractBinary(byte[], byte[], int)
 * @see mg.hr.BinaryMath#_subtractBinary(double, double, int)
 * @see mg.hr.BinaryMath#_addBinary(byte[], byte[], int)
 */
    public static byte[] _addBinary(double _firstNumber, double _secondNumber, int _bitNumber)
    {
        byte _binary[] = null;
        try 
        {
            _binary = mg.hr.Binary.toBinary((_firstNumber + _secondNumber), _bitNumber);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return _binary;
    }

//============================================================================

/**
 * substract _firstNumber to _secondNumber and returns result in binary.
 *  
 * @param _firstNumber {@code double}
 * @param _secondNumber {@code double}
 * @param _bitNumber {@code int}
 * 
 * @return byte[]
 * @see mg.hr.BinaryMath#_subtractBinary(byte[], byte[], int)
 * @see mg.hr.BinaryMath#_addBinary(byte[], byte[], int)
 * @see mg.hr.BinaryMath#_addBinary(double, double, int)
 */
    public static byte[] _subtractBinary(double _firstNumber, double _secondNumber, int _bitNumber)
    {
        byte _binary[] = null;
        try 
        {
            _binary = mg.hr.Binary.toBinary((_firstNumber - _secondNumber), _bitNumber);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return _binary;
    }
    
//============================================================================
    
/**
 * returns an array of byte with length defined in the param {@code _bitNumber}
 * 
 * if {@code _bitNumber} is inferior of {@code _firstBinaryNumber.length} or {@code _secondBinaryNumber.length},
 * <p>it will be set to the superior between _firstBinaryNumber.length and _secondBinaryNumber.length
 * 
 * @param _firstBinaryNumber {@code byte[]}
 * @param _secondBinaryNumber {@code byte[]}
 * @param _bitNumber {@code int}
 * 
 * @return byte[]
 */
    public static byte[] _addBinary(byte[] _firstBinaryNumber, byte[] _secondBinaryNumber, int _bitNumber)
    {
        byte a, b;
        int j, _originalBitNumber = _bitNumber;
        int up = (_firstBinaryNumber.length < _secondBinaryNumber.length) ? _secondBinaryNumber.length : _firstBinaryNumber.length;
        _bitNumber = (_bitNumber > up) ? _bitNumber : up;
        byte result[] = new byte[_bitNumber];
        _firstBinaryNumber = _completeBinaryNumber(_firstBinaryNumber, _bitNumber);
        _secondBinaryNumber = _completeBinaryNumber(_secondBinaryNumber, _bitNumber);

        for(int i = _bitNumber - 1; i >= 0; i--)
        {
            a = _firstBinaryNumber[i];
            b = _secondBinaryNumber[i];

            if((a == b)) 
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

        if(_bitNumber == _originalBitNumber) return result;
        else
        {
            result = mg.hr.Binary._reverseBinary(result);
            byte result1[] = new byte[_originalBitNumber];
            for(int i = 0; i < _originalBitNumber; i++)
                result1[i] = result[i];
            return result1;
        }
    }

//============================================================================

    public static byte[] _subtractBinary(byte[] _firstBinaryNumber, byte[] _secondBinaryNumber, int _bitNumber)
    {
        byte a, b;
        byte result[] = new byte[_bitNumber];
        int _originalBitNumber = _bitNumber;
        int up = (_firstBinaryNumber.length < _secondBinaryNumber.length) ? _secondBinaryNumber.length : _firstBinaryNumber.length;
        _bitNumber = (_bitNumber > up) ? _bitNumber : up;
        _firstBinaryNumber = _completeBinaryNumber(_firstBinaryNumber, _bitNumber);
        _secondBinaryNumber = _completeBinaryNumber(_secondBinaryNumber, _bitNumber);

        for(int i = _bitNumber - 1; i >= 0; i--)
        {
            a = _firstBinaryNumber[i];
            b = _secondBinaryNumber[i];

            if(a == b)
            {
                result[i] = 0;
            }
            else if(a == 1 && b == 0)
            {
                result[i] = 1;
            }
            else if(a != b)
            {
                if(b == 1)
                {
                    result[i] = 1;
                    int j = i;
                    if(--j >= 0 && _secondBinaryNumber[j] == 0)
                        _secondBinaryNumber[j] = 1;
                }   
            }
        }
        
        if(_bitNumber == _originalBitNumber) return result;
        else
        {
            result = mg.hr.Binary._reverseBinary(result);
            byte result1[] = new byte[_originalBitNumber];
            for(int i = 0; i < _originalBitNumber; i++)
                result1[i] = result[i];
            return result1;
        }
    }

//============================================================================

/**
 * used to complete a binary number with 0 in the left, example:<p>
 * for a number in {@code 8} bits:
 * <p> - {@code 1011} becomes {@code 00001011}, 
 * <p> - {@code 1} becomes {@code 00000001}
 * 
 * @param _number {@code byte}
 * @param length {@code int} number of bit
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

//============================================================================

}