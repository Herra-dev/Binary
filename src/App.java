import mg.hr.Binary;
import mg.hr.BinaryMath;
import mg.hr.exception.BinaryException;
import mg.hr.exception.NotABinaryNumberException;

public class App {
    public static void main(String[] args) {
            byte[] binaryNumber;
            byte[] binaryNumber1;
            byte[] result;
            try {
                binaryNumber = Binary.toBinary(1);
                binaryNumber1 = Binary.toBinary(14);
                Binary._displayBinaryNumber(binaryNumber);
                Binary._displayBinaryNumber(binaryNumber1);
                result = BinaryMath._addBinary(binaryNumber, binaryNumber1, 2);

                Binary._displayBinaryNumber(result);

            } catch (BinaryException | NotABinaryNumberException e) {
                e.printStackTrace();
            }
    }   
}