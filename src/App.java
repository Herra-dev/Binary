import mg.hr.Binary;
import mg.hr.exception.BinaryException;

public class App {
    public static void main(String[] args) {
            byte[] binaryNumber;
            try {
                binaryNumber = Binary.toBinary(15);
                Binary._displayBinaryNumber(binaryNumber);
            } catch (BinaryException e) {
                e.printStackTrace();
            }
    }   
}