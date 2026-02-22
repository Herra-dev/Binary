public class App
{
    public static void main(String[] args)
    {
        // java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
        // int a, b;
        // System.out.print("enter one number : ");
        // a = sc.nextInt();
        // System.out.print("enter another number : ");
        // b = sc.nextInt();
        // System.out.println(a + " and " + b);



        try
        {
            byte[] _bit = mg.hr.Binary.toBinary(20.1);
            byte[] _bit1 = mg.hr.Binary.toBinary(20);
            byte[] _bit2 = mg.hr.Binary.toBinary(20.1);
        //     byte[] _bit2 = mg.hr.BinaryMath._addBinary(_bit, _bit1, 2);

        //     double nbr = mg.hr.decimal.Decimal._toDecimalUnsignedInteger(mg.hr.BinaryMath._addBinary(20,20));
        //     double nbr1 = mg.hr.decimal.Decimal._toDecimalUnsignedInteger(_bit2);



        //     System.out.println("_bit2.length = " + _bit2.length);
        //     System.out.println("nbr = " + nbr);
        //     System.out.println("nbr1 = " + nbr1);
        }
        catch(mg.hr.exception.BinaryException e)
        {
            e.printStackTrace();
        }
    }
}