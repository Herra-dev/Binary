public class App
{
    public static void main(String[] args)
    {
        try
        {
            byte[] _bit = mg.hr.Binary.toBinary(20);
            byte[] _bit1 = mg.hr.Binary.toBinary(20);
            byte[] _bit2 = mg.hr.BinaryMath._addBinary(_bit, _bit1);

            double nbr = mg.hr.decimal.Decimal._toDecimalUnsignedInteger(mg.hr.BinaryMath._addBinary(20,20));
            double nbr1 = mg.hr.decimal.Decimal._toDecimalUnsignedInteger(_bit2);

            System.out.print("_bit2 = ");
            for(byte b: _bit2)
                System.out.print(b);
            System.out.println();


            System.out.println("_bit.length = " + _bit.length);
            System.out.println("nbr = " + nbr);
            System.out.println("nbr1 = " + nbr1);
        }
        catch(mg.hr.exception.BinaryException e)
        {
            e.printStackTrace();
        }
    }
}