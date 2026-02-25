public class App
{
    public static void main(String[] args)
    {
        byte[] _bit = {1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        mg.hr.Binary._displayBinaryNumber(_bit);
        System.out.println(mg.hr.decimal.Decimal._toDecimalFloat(_bit));
    }
}