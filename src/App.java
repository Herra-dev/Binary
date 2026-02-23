public class App
{
    public static void main(String[] args)
    {
        // try {
        // byte[] _bit = mg.hr.Binary._toBinaryUnsignedInteger(15, 4);
        // // byte[] _bit2 = mg.hr.Binary._toBinaryUnsignedInteger(3, 1);
        // // byte[] _bit3 = mg.hr.BinaryMath._addBinary(_bit, _bit2);
        // mg.hr.Binary._displayBinaryNumber(_bit);
        // } catch (mg.hr.exception.NotAnIntegerException | mg.hr.exception.BinaryException  | mg.hr.exception.NotAnUnsignedInteger e) {
        //     e.printStackTrace();
        // }

        // byte[] _bit = mg.hr.Binary._toBinaryFloat(0.3, mg.hr.enumeration.FloatPrecision._EXTENDED_DUAL_PRECISION);
        // mg.hr.Binary._displayBinaryNumber(_bit);

        // System.out.println("0.6 * 2 = " + 0.6*2);
        double d = 5.09999982222222d;
        Float f = Float.parseFloat("0.9999999999999");
        System.out.println(java.lang.Math.nextUp(d));
    }
}