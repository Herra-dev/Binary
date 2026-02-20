public class App
{
    public static void main(String[] args)
    {
        try
        {
            byte[] _bit = mg.hr.Binary.toBinary(-14);
            for(byte b: _bit)
                System.out.print(b);
            System.out.println();
            double  nbr = mg.hr.decimal.Decimal._toDecimalSignedInteger(_bit);

            System.out.println("nbr = " + nbr);

            // byte[] _b = mg.hr.Binary.toBinary(14099999996d);
            // System.out.println(mg.hr.decimal.Decimal._toDecimalFloat(_b));

            // for(byte b: _b)
            //     System.out.print(b);
            // System.out.println();
        }
        catch(mg.hr.exception.BinaryException e)
        {
            e.printStackTrace();
        }
        
    }
}