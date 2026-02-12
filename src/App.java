public class App
{
    public static void main(String[] args)
    {
        byte tab[] = {0, 0, 0, 0, 1, 1, 1, 0};
         byte tab1[] = {0, 0, 0, 0, 0, 1, 1, 1};
        for(byte b : mg.hr.BinaryMath._addBinary(tab, tab1, 2))
            System.out.print(b);

        System.out.println();

        for(byte b : mg.hr.BinaryMath._addBinary(15, 7, 2))
            System.out.print(b);

        System.out.println();

        // for(byte b : mg.hr.Binary._reverseBinary(tab))
        //     System.out.print(b);

        // System.out.println();
    }
}