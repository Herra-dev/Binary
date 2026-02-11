public class App
{
    public static void main(String[] args)
    {
        byte a[] = {1, 1, 1, 1};
        byte b[] = {0, 0, 1, 1};
        
        for(byte c: mg.hr.BinaryMath._addBinary(a, b, 3))
           System.out.print(c);
        System.out.println();
    }
}