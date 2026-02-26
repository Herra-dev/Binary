import mg.hr.exception.BinaryException;

public class App {
    public static void main(String[] args) {
        
        try {
            byte[] _bit = mg.hr.BinaryMath._addBinary(mg.hr.Binary.toBinary(20), mg.hr.Binary.toBinary(20));
            mg.hr.Binary._displayBinaryNumber(_bit);
        } catch (BinaryException e) {
            e.printStackTrace();
        }
    }
}