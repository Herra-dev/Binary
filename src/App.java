public class App
{
    public static void main(String[] args)
    {
        byte[] _bit = mg.hr.Binary._toBinaryFloat(-1027.0000000625, mg.hr.enumeration.FloatPrecision._OCTUPLE_PRECISION);
        mg.hr.Binary._displayBinaryNumber(_bit);
        System.out.println(mg.hr.decimal.Decimal._toDecimalFloat(_bit));
    }
}