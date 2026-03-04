package test.mg.hr;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Test_Binary
{

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
        
        assertArrayEquals(_excepted, mg.hr.Binary._complementBinary(_bit_));

        _excepted[0] = 0; _bit_[0] = 1;
        assertArrayEquals(_excepted, mg.hr.Binary._complementBinary(_bit_));

        _excepted[5] = 0; _bit_[5] = 1;
        _excepted[7] = 0; _bit_[7] = 1;
        assertArrayEquals(_excepted, mg.hr.Binary._complementBinary(_bit_));

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
        assertArrayEquals(_excepted, mg.hr.Binary._complementBinary(_bit_));
    }

//========================================================================================

    @Test
    public void _test_reverseBinary()
    {
        byte[] _excepted = new byte[8];
        for(byte i = 0; i < _excepted.length; i++)
        {
            if(i < 5){ _excepted[i] = 1;    continue; }
            _excepted[i] = 0;
        }
        byte[] _bit = {0, 0, 0, 1, 1, 1, 1, 1};
        _bit = mg.hr.Binary._reverseBinary(_bit);

        for(byte i = 0; i < 8; i++)
            assertEquals(_excepted[i], _bit[i]);
    }

//========================================================================================

    @Test
    public void _test_toBinaryFloat()
    {
        byte[] _bit = {1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(_bit, mg.hr.Binary._toBinaryFloat(-1027.625, mg.hr.enumeration.FloatPrecision._SIMPLE_PRECISION));

        _bit[0] = 0;
        assertArrayEquals(_bit, mg.hr.Binary._toBinaryFloat(1027.625, mg.hr.enumeration.FloatPrecision._SIMPLE_PRECISION));
        _bit = null;
    
        byte[] _bit1 = {0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1};
        assertArrayEquals(_bit1, mg.hr.Binary._toBinaryFloat(0.3, mg.hr.enumeration.FloatPrecision._SIMPLE_PRECISION));
    
        _bit1[0] = 1;
        assertArrayEquals(_bit1, mg.hr.Binary._toBinaryFloat(-0.3, mg.hr.enumeration.FloatPrecision._SIMPLE_PRECISION));
        _bit1 = null;
    }

//========================================================================================

    @Test
    public void _test_toBinarySignedInteger()
    {
        byte[] _bit = {0, 0, 0, 0, 0, 0, 0};
        try {
            assertArrayEquals(_bit, mg.hr.Binary._toBinarySignedInteger(0, 7));
            
            _bit[6] = 1;
            assertArrayEquals(_bit, mg.hr.Binary._toBinarySignedInteger(1, 7));
            
            for(byte b = 0; b < _bit.length; b++)
                _bit[b] = 1;
            assertArrayEquals(_bit, mg.hr.Binary._toBinarySignedInteger(-1, 7));

            _bit[_bit.length-1] = 0;
            assertArrayEquals(_bit, mg.hr.Binary._toBinarySignedInteger(-2, 7));
            _bit = null;

            byte[] _bit0 = {1, 1, 1, 0, 0, 0, 1};
            assertArrayEquals(_bit0, mg.hr.Binary._toBinarySignedInteger(-15, 7));
            _bit0 = null;

            byte[] _bit1 = {0, 0, 0, 1};
            assertArrayEquals(_bit1, mg.hr.Binary._toBinarySignedInteger(-15, 4));
            _bit1 = null;

            byte[] _bit2 = {1, 1, 1, 0, 0, 0, 0, 1};
            assertArrayEquals(_bit2, mg.hr.Binary._toBinarySignedInteger(-31, 8));
            _bit2 = null;

            byte[] _bit3 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            assertArrayEquals(_bit3, mg.hr.Binary._toBinarySignedInteger(1024, 11));
            assertArrayEquals(_bit3, mg.hr.Binary._toBinarySignedInteger(-1024, 11));
            _bit3 = null;

            byte[] _bit4 = {0, 1, 1, 1, 1, 1, 1, 1, 1};
            assertArrayEquals(_bit4, mg.hr.Binary._toBinarySignedInteger(-257, 9));
            _bit4 = null;

            byte[] _bit5 = {0, 0, 0, 1, 0};
            assertArrayEquals(_bit5, mg.hr.Binary._toBinarySignedInteger(-30, 5));
        } catch (mg.hr.exception.BinaryException |
                    mg.hr.exception.NotAnIntegerException e) {
            e.printStackTrace();
        }
    }

}