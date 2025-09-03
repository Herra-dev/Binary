import mg.hr.Binary;
import mg.hr.exception.BinaryException;

public class App {
    public static void main(String[] args) {
            byte[] binaryNumber;
            try {
                binaryNumber = Binary.toBinary(0.000199999001);
                Binary._displayBinaryNumber(binaryNumber);
            } catch (BinaryException e) {
                e.printStackTrace();
            }
    }   
}