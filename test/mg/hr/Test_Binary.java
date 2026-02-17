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

//========================================================================================

    public void test(double nbr, byte[] _bit_, int length)
    {
        try
        {
            for(short i = 0; i < length; i++)
                assertEquals(_bit_[i], mg.hr.Binary.toBinary(nbr)[i]);
        }
        catch(mg.hr.exception.BinaryException e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public void _test_toBinaryWithBitNumber() throws mg.hr.exception.BinaryException
    {
        byte[] _excepted = {0, 0, 0, 0, 0, 0, 0, 0}; // 0000_0000 = 0
        //-----------------------------------------------------------------------
        // case where the number in decimal is a non floating number and positive
        
        {
            test(0, _excepted);
        
            // 0000_0001 = 1 
            _excepted[7] = 1; 
            test(1, _excepted);

            // 0000_0010 = 2
            _excepted[6] = 1; _excepted[7] = 0;
            test(2, _excepted);

            // 0000_0011 = 3
            _excepted[7] = 1; 
            test(3, _excepted);
        
            // 1111_1111 = 255
            for(int i = 0; i < _excepted.length; i++)
                _excepted[i] = 1; 
            test(255, _excepted);
        
            // 0000_1111 = 15
            for(int i = 0; i < _excepted.length - 4; i++)
                _excepted[i] = 0; 
            test(15, _excepted);
        }
        
        //-----------------------------------------------------------------------
        // case where the number in decimal is a non floating number and negative
        {
            // 1111_1111 = -1
            for(int i = 0; i < _excepted.length; i++)
                _excepted[i] = 1; 
            test(-1, _excepted);
            
            // 1111_0001 = -15
            for(byte i = 0; i < 8; i++)
                _excepted[i] = 1;
            for(byte i = 4; i < 7; i++)
                _excepted[i] = 0;
            test(-15, _excepted);
            
            _excepted[0] = 1; _excepted[1] = 0; _excepted[2] = 0; _excepted[3] = 1;
            _excepted[4] = 1; _excepted[5] = 1; _excepted[6] = 1; _excepted[7] = 0;
            test(-98, _excepted);
        }
        
    }

//========================================================================================

    public void test(double nbr, byte[] _bit_)
    {
        try
        {
            for(short i = 0; i < _bit_.length; i++)
                assertEquals(_bit_[i], mg.hr.Binary.toBinary(nbr, _bit_.length)[i]);
        }
        catch(mg.hr.exception.BinaryException e)
        {
            e.printStackTrace();
        }
        
    }
    @Test
    public void _test_toBinaryNoBitNumber()
    {
        byte[] _bit_ = new byte[16]; // test for number with 16 bits max
        try
        {
            assertEquals(0, mg.hr.Binary.toBinary(0)[0]);
            assertEquals(1, mg.hr.Binary.toBinary(1)[0]);
        }
        catch(mg.hr.exception.BinaryException e)
        {
            e.printStackTrace();
        }
            // = 10 = 2
            _bit_[0] = 1; _bit_[1] = 0;
            test(2, _bit_, 2);

            // = 1110 = 14
            _bit_[1] = 1; _bit_[2] = 1; _bit_[3] = 0;
            test(14, _bit_, 4);

            // = 0010 = -14
            _bit_[0] = 0; _bit_[1] = 0; _bit_[2] = 1;
            test(-14, _bit_, 4);

            // = 1111111 = 127
            for(byte i = 0; i < 7; i++) _bit_[i] = 1;
            test(127, _bit_, 7);

             // = 0000001 = -127
            for(byte i = 0; i < 6; i++) _bit_[i] = 0;
            test(-127, _bit_, 7);

            // = 100010101110 = 2222
            _bit_[0] = 1; _bit_[4] = 1; _bit_[7] = 0; _bit_[8] = 1; _bit_[9] = 1; _bit_[10] = 1;
            _bit_[11] = 0;
            test(2222, _bit_, 12);

            // = 011101010100 = -2220
            _bit_[0] = 0; _bit_[1] = 1; _bit_[2] = 1; _bit_[3] = 1; _bit_[4] = 0; _bit_[5] = 1;
            _bit_[6] = 0; _bit_[7] = 1; _bit_[8] = 0; _bit_[9] = 1; _bit_[10] = 0; _bit_[11] = 0;
            test(-2220, _bit_, 12);

            // = 1111110000001000 = 64520
            for(byte i = 0; i < 6; i++)
                _bit_[i] = 1;
            for(byte i = 6; i < 16; i++)
                _bit_[i] = 0;
            _bit_[12] = 1;
            test(64520, _bit_, 16);

            // = 0000001111111000 = -64520
            for(byte i = 0; i < 16; i++)
                _bit_[i] = 0;
            for(byte i = 6; i < 13; i++)
                _bit_[i] = 1;
            test(-64520, _bit_, 16);
        
    }

//========================================================================================

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

//========================================================================================

    public void test(byte[] _excepted, byte[] _result)
    {
        for(byte i = 0; i < _excepted.length; i++)
            assertEquals(_excepted[i], _result[i]);
    }
    @Test
    public void _test_complementBinary()
    {
        int _length = 8;
        byte[] _excepted = new byte[_length];
        byte[] _bit_ = new byte[_length];
        for(byte i = 0; i < _length; i++)
            _excepted[i] = 1;
        for(byte i = 0; i < _length; i++)
            _bit_[i] = 0;
        
        test(_excepted, mg.hr.Binary._complementBinary(_bit_));

        _excepted[0] = 0; _bit_[0] = 1;
        test(_excepted, mg.hr.Binary._complementBinary(_bit_));

        _excepted[5] = 0; _bit_[5] = 1;
        _excepted[7] = 0; _bit_[7] = 1;
        test(_excepted, mg.hr.Binary._complementBinary(_bit_));

        for(byte i = 0; i < _length; i++)
        {
            if(i < 5)
            {
                _excepted[i] = 1;
                _bit_[i] = 0;
                continue;
            }
            _excepted[i] = 0;
            _bit_[i] = 1;
        }
        test(_excepted, mg.hr.Binary._complementBinary(_bit_));
    }

//========================================================================================

    @Test
    public void _test_reverseBinary()
    {
        byte[] _excepted = new byte[8];
        for(byte i = 0; i < _excepted.length; i++)
        {
            if(i < 5){ _excepted[i] = 1;    continue;}
            _excepted[i] = 0;
        }
        byte[] _bit = {0, 0, 0, 1, 1, 1, 1, 1};
        _bit = mg.hr.Binary._reverseBinary(_bit);

        for(byte i = 0; i < 8; i++)
            assertEquals(_excepted[i], _bit[i]);
    }

}