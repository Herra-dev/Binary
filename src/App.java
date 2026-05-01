import java.math.BigDecimal;

import mg.hr.Binary;
import mg.hr.exception.BinaryException;


public class App {
    public static void main(String[] args) {
        byte[] array = null;
        try {
            array = Binary.toBinary(new BigDecimal(2), 2);
        } catch (BinaryException e) {
            e.printStackTrace();
        }
        Binary._displayBinaryNumber(array);
        
    }   
}