public class App
{
    public static void main(String[] args)
    {
        byte tab[] = {0, 0, 0, 0, 1, 0, 0, 0};
        // byte tab1[] = {0, 0, 0, 0, 0, 0, 1, 1};
        // for(byte b : mg.hr.BinaryMath._addBinary(31, 0, 8))
        //     System.out.print(b);

        // System.out.println();

        mg.hr.Binary.toDecimal(tab, mg.hr.enumeration.NumberSign._SIGNED, mg.hr.enumeration.NumberType._FLOAT);

        // for(byte b : mg.hr.BinaryMath._addBinary(11, 15, 8))
        //     System.out.print(b);

        // System.out.println();
    }
}