public class App
{
    public static void main(String[] args)
    {
        try {
        byte[] _bit = mg.hr.Binary._toBinaryUnsignedInteger(15, 4);
        // byte[] _bit2 = mg.hr.Binary._toBinaryUnsignedInteger(3, 1);
        // byte[] _bit3 = mg.hr.BinaryMath._addBinary(_bit, _bit2);
        mg.hr.Binary._displayBinaryNumber(_bit);
        } catch (mg.hr.exception.NotAnIntegerException | mg.hr.exception.BinaryException  | mg.hr.exception.NotAnUnsignedInteger e) {
            e.printStackTrace();
        }

        byte[] _bit = mg.hr.Binary._toBinaryFloat(15.3, mg.hr.enumeration.FloatPrecision._EXTENDED_DUAL_PRECISION);
        mg.hr.Binary._displayBinaryNumber(_bit);
    }
}