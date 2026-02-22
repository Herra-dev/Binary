public class App
{
    public static void main(String[] args)
    {
        byte[] _bit1 = null;


        //_bit = mg.hr.Binary._toBinaryFloat(20.1, mg.hr.enumeration.FloatPrecision._SIMPLE_PRECISION);
        

        // try {
            _bit1 = mg.hr.Binary._toBinaryFloat(-1027.625, mg.hr.enumeration.FloatPrecision._HALF_PRECISION);
            // _bit1 = mg.hr.Binary._toBinaryUnsignedInteger(-1027.625, 8);
        // } catch (mg.hr.exception.NotAnIntegerException | mg.hr.exception.BinaryException | mg.hr.exception.NotAnUnsignedInteger e) {
        //     e.printStackTrace();
        // }

        mg.hr.Binary._displayBinaryNumber(_bit1);
    }
}