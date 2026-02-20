public class App
{
    public static void main(String[] args)
    {
        try
        {
            byte[] _bit = mg.hr.Binary.toBinary(3.057718276977539);
            double  nbr = mg.hr.decimal.Decimal._toDecimalFloat(_bit);

            System.out.println("nbr = " + nbr);
        }
        catch(mg.hr.exception.BinaryException e)
        {
            e.printStackTrace();
        }
    }
}