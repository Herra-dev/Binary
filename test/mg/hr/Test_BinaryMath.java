package test.mg.hr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mg.hr.exception.NotABinaryNumber;

public class Test_BinaryMath
{
    @Test
    public void _test_addBinary()
    {
        int length = 8;
        byte _tab[] = null;
        byte _tab1[] = null;

        try 
        {
            _tab = mg.hr.Binary.toBinary(5, length);
            _tab1 = mg.hr.Binary.toBinary(10, length);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        byte _excepted[] = {0, 0, 0, 0, 1, 1, 1, 1};
        
        for(int i = 0; i < 8; i++)
        {
            try {
                assertEquals(_excepted[i], mg.hr.BinaryMath._addBinary(_tab, _tab1, length)[i]);
            } catch (NotABinaryNumber e) {
                e.printStackTrace();
            }
        }
    }
}