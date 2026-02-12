public class App
{
    public static void main(String[] args)
    {
        for(byte b : mg.hr.Binary.toBinary(-255, 8))
            System.out.print(b);

        System.out.println();
    }
}