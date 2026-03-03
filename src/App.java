import mg.hr.exception.BinaryException;
import mg.hr.exception.NotAnIntegerException;
import mg.hr.exception.NotAnUnsignedIntegerException;

public class App {
    public static void main(String[] args) {
        
        // try {
        //     byte[] _bit = mg.hr.Binary._toBinaryUnsignedInteger(7, 3);
        //     //_bit[0] = 5;
        //     byte[] _bit1 = mg.hr.Binary._toBinaryUnsignedInteger(5, 3);
        //     byte[] _bit2 = mg.hr.BinaryMath._multiplyBinary(_bit, _bit1, 3);
            
        // } catch (BinaryException | NotAnIntegerException  | NotAnUnsignedIntegerException | NotABinaryNumberException e) {
        //     e.printStackTrace();
        // }

        // int i = 0;
        // while(i < 10) {
        //     for(int j = 0; j < 5; j++) {
        //         System.out.println("i = " + i);
        //         System.out.println("j = " + j);
        //         System.out.println("----------------------------");
        //         if(j == 2) break;
        //     }
        //     i++;
        // }
            
        try {
            mg.hr.Binary._displayBinaryNumber(mg.hr.Binary._toBinaryUnsignedInteger(17, 2));
        } catch (NotAnIntegerException | NotAnUnsignedIntegerException | BinaryException e) {
            e.printStackTrace();
        }


    }
}