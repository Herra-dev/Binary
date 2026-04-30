import mg.hr.Binary;
import ui.BinaryDecimalConverter;

public class App {
    public static void main(String[] args) {
        // BinaryDecimalConverter bdc = new BinaryDecimalConverter();
        // bdc.setVisible(true);

        byte[] array = {1, 2, 3, 4};
        Binary.byteArrayToString(array);
    }   
}