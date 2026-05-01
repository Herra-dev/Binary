// // import java.math.BigDecimal;


// import mg.hr.Binary;
// import mg.hr.exception.BinaryException;
// import mg.hr.exception.NotAnIntegerException;
// import mg.hr.exception.NotAnUnsignedIntegerException;
// import ui.BinaryDecimalConverter;

import java.math.BigDecimal;

import mg.hr.Binary;
import mg.hr.enumeration.FloatPrecision;

public class App {
    public static void main(String[] args) {
        // BinaryDecimalConverter bdc = new BinaryDecimalConverter();
        // bdc.setVisible(true);
        // byte[] array = null;
        // try {
        //     array = Binary._toBinaryUnsignedInteger(new BigDecimal("1073741824"), 15);
        // } catch (BinaryException | NotAnIntegerException | NotAnUnsignedIntegerException e) {
        //     e.printStackTrace();
        // }
        // System.out.println("----------------------------------");
        // Binary._displayBinaryNumber(array);
        
        // System.out.println(Binary._powerOfTwoCloseBottom(new BigDecimal("2147483648")));
        // System.out.println("107374182");
        // System.out.println(java.lang.Double.MAX_VALUE);
        // Binary._displayBinaryNumber(Binary._floor(new BigDecimal(15.525)));


        // BigDecimal bd = new BigDecimal("1000000000.0");
        // System.out.println(bd);

        Binary._decimal(new BigDecimal(0.3), FloatPrecision._DUAL_PRECISION);

        // BigDecimal bd0 = new BigDecimal("3.3");
        // BigDecimal bd1 = bd0.subtract(new BigDecimal(bd0.toBigInteger()));
        // System.out.println(bd1);
    }   
}