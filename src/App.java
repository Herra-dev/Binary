// // import java.math.BigDecimal;

import java.math.BigDecimal;

import mg.hr.Binary;
// import mg.hr.exception.BinaryException;
// import mg.hr.exception.NotAnIntegerException;
// import mg.hr.exception.NotAnUnsignedIntegerException;
// import ui.BinaryDecimalConverter;


public class App {
    public static void main(String[] args) {
        // BinaryDecimalConverter bdc = new BinaryDecimalConverter();
        // bdc.setVisible(true);
        // byte[] array = null;
        // try {
        //     array = Binary._toBinaryUnsignedInteger(new BigDecimal("3000000000"), 15);
        // } catch (BinaryException | NotAnIntegerException | NotAnUnsignedIntegerException e) {
        //     e.printStackTrace();
        // }
        // System.out.println("----------------------------------");
        // Binary._displayBinaryNumber(array);
        
        System.out.println(Binary._powerOfTwoCloseBottom(new BigDecimal("39")));
        // Binary._displayBinaryNumber(Binary._floor(new BigDecimal(15.525)));


    }   
}