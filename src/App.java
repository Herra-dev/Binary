public class App
{
    public static void main(String[] args)
    {
        byte[] _bit1 = null;

        try {
        //     // _bit1 = mg.hr.Binary._toBinaryFloat(-1027.625, mg.hr.enumeration.FloatPrecision._HALF_PRECISION);
        //     _bit1 = mg.hr.Binary._toBinarySignedInteger(-1, 5);
        byte[] _bit = mg.hr.Binary._toBinaryUnsignedInteger(15, 4);
        byte[] _bit2 = mg.hr.Binary._toBinaryUnsignedInteger(3, 1);
        byte[] _bit3 = mg.hr.BinaryMath._addBinary(_bit, _bit2);
        mg.hr.Binary._displayBinaryNumber(_bit3);
        } catch (mg.hr.exception.NotAnIntegerException | mg.hr.exception.BinaryException  | mg.hr.exception.NotAnUnsignedInteger e) {
            e.printStackTrace();
        }

        //mg.hr.Binary._displayBinaryNumber(_bit1);
    }
}