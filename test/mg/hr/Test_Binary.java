package test.mg.hr;

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
        //-----------------------------------------------------------------------
        // case where the number in decimal is a non floating number and positive
        
        try 
        {
            {
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
            
            //-----------------------------------------------------------------------
            // case where the number in decimal is a non floating number and negative
            {
                for(int i = 0; i < _excepted.length; i++)
                    _excepted[i] = 1; // 1111_1111 = -1
                for(int i = 0; i < _excepted.length; i++)
                    assertEquals(_excepted[i], mg.hr.Binary.toBinary(-1, 8)[i]);
                
                _excepted[4] = 0;
                _excepted[5] = 0;
                _excepted[6] = 0;
                for(int i = 0; i < _excepted.length; i++)
                    assertEquals(_excepted[i], mg.hr.Binary.toBinary(-15, 8)[i]);
                
                _excepted[0] = 1;
                _excepted[1] = 0;
                _excepted[2] = 0;
                _excepted[3] = 1;
                _excepted[4] = 1;
                _excepted[5] = 1;
                _excepted[6] = 1;
                _excepted[7] = 0;
                for(int i = 0; i < _excepted.length; i++)
                    assertEquals(_excepted[i], mg.hr.Binary.toBinary(-98, 8)[i]);
            }
        } 
        catch (mg.hr.exception.BinaryException e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void _test_powerOfTwoCloseBottom()
    {
        assertEquals(0, mg.hr.Binary._powerOfTwoCloseBottom(1));
        assertEquals(1, mg.hr.Binary._powerOfTwoCloseBottom(3));
        assertEquals(8, mg.hr.Binary._powerOfTwoCloseBottom(256));
        assertEquals(9, mg.hr.Binary._powerOfTwoCloseBottom(1023));
        assertEquals(10, mg.hr.Binary._powerOfTwoCloseBottom(1024));
        assertEquals(11, mg.hr.Binary._powerOfTwoCloseBottom(2048));
        assertEquals(11, mg.hr.Binary._powerOfTwoCloseBottom(2049));
        assertEquals(11, mg.hr.Binary._powerOfTwoCloseBottom(4095));
        assertEquals(12, mg.hr.Binary._powerOfTwoCloseBottom(4096));
        assertEquals(12, mg.hr.Binary._powerOfTwoCloseBottom(4097));
    }

    
}