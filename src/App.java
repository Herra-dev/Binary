// import ui.BinaryDecimalConverter;

import java.math.BigDecimal;

import mg.hr.Binary;
import mg.hr.enumeration.FloatPrecision;

// import java.math.BigDecimal;
// import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
        // BinaryDecimalConverter bdc = new BinaryDecimalConverter();
        // bdc.setVisible(true);

        byte[] array = Binary._toBinaryFloat(new BigDecimal("-0.3"), FloatPrecision._SIMPLE_PRECISION);
        Binary._displayBinaryNumber(array);

        // System.out.println(java.lang.Byte.MIN_VALUE + " - " + java.lang.Byte.MAX_VALUE);
        // System.out.println(java.lang.Integer.MIN_VALUE + " - " + java.lang.Integer.MAX_VALUE);
        // System.out.println(java.lang.Float.MIN_VALUE + " - " + java.lang.Float.MAX_VALUE);
        // System.out.println(java.lang.Double.MIN_VALUE + " - " + java.lang.Double.MAX_VALUE);

        // BigInteger bd = new BigInteger("3000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        // System.out.println(bd);
    }   
}