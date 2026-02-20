package test.mg.hr.decimal;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class Test_Decimal {

    protected static byte[] _bit = null;

    @BeforeEach
    public void _beforeEach()
    {
        _bit = new byte[256];
    }

    @AfterEach
    public void _afterEach()
    {
        _bit = null;
    }

    @Test
    public void test_toDecimalUnsignedInteger()
    {
        try {
            _bit = mg.hr.Binary.toBinary(1);
            assertEquals(1, (int)mg.hr.decimal.Decimal._toDecimalUnsignedInteger(_bit));

            _bit = mg.hr.Binary.toBinary(255);
            assertEquals(255, (int)mg.hr.decimal.Decimal._toDecimalUnsignedInteger(_bit));

            _bit = mg.hr.Binary.toBinary(5855);
            assertEquals(5855, (int)mg.hr.decimal.Decimal._toDecimalUnsignedInteger(_bit));

            _bit = mg.hr.Binary.toBinary(5855);
            assertEquals(5855, (int)mg.hr.decimal.Decimal._toDecimalUnsignedInteger(_bit));

            _bit = mg.hr.Binary.toBinary(486254588);
            assertEquals(486254588, (int)mg.hr.decimal.Decimal._toDecimalUnsignedInteger(_bit));

            _bit = mg.hr.Binary.toBinary(99999999);
            assertEquals(99999999, (int)mg.hr.decimal.Decimal._toDecimalUnsignedInteger(_bit));
        }
        catch(mg.hr.exception.BinaryException e) {
            e.printStackTrace();
        } 
    }
    
    @Test
    public void test_toDecimalSignedInteger()
    {
        try {
            _bit = mg.hr.Binary.toBinary(-1);
            assertEquals(-1, (int)mg.hr.decimal.Decimal._toDecimalSignedInteger(_bit));

            _bit = mg.hr.Binary.toBinary(-255);
            assertEquals(-255, (int)mg.hr.decimal.Decimal._toDecimalSignedInteger(_bit));

            _bit = mg.hr.Binary.toBinary(-5855);
            assertEquals(-5855, (int)mg.hr.decimal.Decimal._toDecimalSignedInteger(_bit));

            _bit = mg.hr.Binary.toBinary(-5855);
            assertEquals(-5855, (int)mg.hr.decimal.Decimal._toDecimalSignedInteger(_bit));

            _bit = mg.hr.Binary.toBinary(-486254588);
            assertEquals(-486254588, (int)mg.hr.decimal.Decimal._toDecimalSignedInteger(_bit));

            java.lang.Double d = -99999999d;
            _bit = mg.hr.Binary.toBinary(d);
            assertEquals(d, (java.lang.Double)mg.hr.decimal.Decimal._toDecimalSignedInteger(_bit));
        }
        catch(mg.hr.exception.BinaryException e) {
            e.printStackTrace();
        } 
    }
}