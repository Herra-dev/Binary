package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test_Binary
{
    @BeforeAll
    public static void setUpBeforeClass() 
    {
        System.out.println("before all");
    }

    @Test
    public void _test_toBinary()
    {
        byte[] _excepted = {0, 0, 0, 0, 0, 0, 0, 0}; // 0000_0000 = 0
        for(int i = 0; i < _excepted.length; i++)
            assertEquals(_excepted[i], mg.hr.Binary.toBinary(0, 8)[i]);
        
        _excepted[7] = 1; // 0000_0001 = 1 
        for(int i = 0; i < _excepted.length; i++)
            assertEquals(_excepted[i], mg.hr.Binary.toBinary(1, 8)[i]);

        _excepted[6] = 1; 
        _excepted[7] = 0;// 0000_0010 = 2
        for(int i = 0; i < _excepted.length; i++)
            assertEquals(_excepted[i], mg.hr.Binary.toBinary(2, 8)[i]);

        _excepted[7] = 1; // 0000_0011 = 3
        for(int i = 0; i < _excepted.length; i++)
            assertEquals(_excepted[i], mg.hr.Binary.toBinary(3, 8)[i]);
    
        for(int i = 0; i < _excepted.length; i++)
            _excepted[i] = 1; // 1111_1111 = 255
        for(int i = 0; i < _excepted.length; i++)
            assertEquals(_excepted[i], mg.hr.Binary.toBinary(255, 8)[i]);
    
        for(int i = 0; i < _excepted.length - 4; i++)
            _excepted[i] = 0; // 0000_1111 = 15
        for(int i = 0; i < _excepted.length; i++)
            assertEquals(_excepted[i], mg.hr.Binary.toBinary(15, 8)[i]);
    }

    @Test
    public void _test__powerOfTwoClose()
    {
        assertEquals(0, mg.hr.Binary._powerOfTwoClose(1));
        assertEquals(1, mg.hr.Binary._powerOfTwoClose(3));
        assertEquals(8, mg.hr.Binary._powerOfTwoClose(256));
        assertEquals(9, mg.hr.Binary._powerOfTwoClose(1023));
        assertEquals(10, mg.hr.Binary._powerOfTwoClose(1024));
        assertEquals(11, mg.hr.Binary._powerOfTwoClose(2048));
        assertEquals(11, mg.hr.Binary._powerOfTwoClose(2049));
        assertEquals(11, mg.hr.Binary._powerOfTwoClose(4095));
        assertEquals(12, mg.hr.Binary._powerOfTwoClose(4096));
        assertEquals(12, mg.hr.Binary._powerOfTwoClose(4097));
    }

    
}