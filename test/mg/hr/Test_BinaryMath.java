package test.mg.hr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_BinaryMath
{
    @Test
    public void _test_addBinary()
    {
        int length = 8;
        byte _tab[] = mg.hr.Binary.toBinary(5, length);
        byte _tab1[] = mg.hr.Binary.toBinary(10, length);

        byte _excepted[] = {0, 0, 0, 0, 1, 1, 1, 1};
        
        for(int i = 0; i < 8; i++)
        {
            assertEquals(_excepted[i], mg.hr.BinaryMath._addBinary(_tab, _tab1, length)[i]);
        }
    }
}