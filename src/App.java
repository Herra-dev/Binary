public class App
{
    public static void main(String[] args)
    {
        byte tab[] = {0, 0, 0, 0, 1, 1, 1, 1};
        byte tab1[] = {0, 0, 0, 0, 0, 1, 1, 1};
        for(byte b : mg.hr.BinaryMath._addBinary(tab, tab1, 8))
            System.out.print(b);

        System.out.println();

        for(byte b : mg.hr.BinaryMath._addBinary(15, 7, 8))
            System.out.print(b);

        System.out.println();
    }
}