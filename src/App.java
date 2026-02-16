public class App
{
    public static void main(String[] args)
    {
        try
        {
            for(byte b : mg.hr.Binary.toBinary(0.3))
                System.out.print(b);

            System.out.println();
        } 
        catch (mg.hr.exception.BinaryException e) 
        {
            e.printStackTrace();
        }
        
    }
}