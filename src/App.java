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

        // byte[] _bit = mg.hr.Binary._toBinaryFloat(0.3, mg.hr.enumeration.FloatPrecision._HALF_PRECISION);
        // mg.hr.Binary._displayBinaryNumber(_bit);


        // java.lang.Double d = 0.3;
        // System.out.println(d.intValue());

        java.lang.Float d = 1.93f - 1.0f;
        java.lang.Double f = 1.0d;

        System.out.println(d); //why tf this returns 0.20000005
    }
}