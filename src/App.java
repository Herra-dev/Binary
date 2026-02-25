import java.math.BigDecimal;

public class App
{
    public static void main(String[] args)
    {
        // try {
        // byte[] _bit = mg.hr.Binary._toBinaryUnsignedInteger(15, 4);
        // // byte[] _bit2 = mg.hr.Binary._toBinaryUnsignedInteger(3, 1);
        // // byte[] _bit3 = mg.hr.BinaryMath._addBinary(_bit, _bit2);
        // mg.hr.Binary._displayBinaryNumber(_bit);
        // } catch (mg.hr.exception.NotAnIntegerException | mg.hr.exception.BinaryException  | mg.hr.exception.NotAnUnsignedIntegerException e) {
        //     e.printStackTrace();
        // }

        byte[] _bit = mg.hr.Binary._toBinaryFloat(0.3, mg.hr.enumeration.FloatPrecision._DUAL_PRECISION);
        // mg.hr.Binary._displayBinaryNumber(_bit);


        // java.lang.Double d = 0.3;
        // System.out.println(d.intValue());

        // int a = 5;
        // java.math.BigDecimal bd = new java.math.BigDecimal("5.2");
        // String s = "string" + 1;

        // System.out.println(s);
    }
}