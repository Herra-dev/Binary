import mg.hr.exception.BinaryException;
import mg.hr.exception.NotABinaryNumber;
import mg.hr.exception.NotAnIntegerException;
import mg.hr.exception.NotAnUnsignedIntegerException;

public class App {
    public static void main(String[] args) {
        
        try {
            byte[] _bit = mg.hr.Binary._toBinaryUnsignedInteger(7, 3);
            //_bit[0] = 5;
            byte[] _bit1 = mg.hr.Binary._toBinaryUnsignedInteger(5, 3);
            byte[] _bit2 = mg.hr.BinaryMath._multiplyBinary(_bit, _bit1, 3);
            
        } catch (BinaryException | NotAnIntegerException  | NotAnUnsignedIntegerException | NotABinaryNumber e) {
            e.printStackTrace();
        }
    }
}