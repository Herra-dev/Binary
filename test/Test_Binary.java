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

    
}