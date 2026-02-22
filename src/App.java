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
        byte[] _bit = null;
        byte[] _bit1 = null;
        byte[] _bit2 = null;


        try{
            _bit = mg.hr.Binary.toBinary(20.1, -1);
        }catch(mg.hr.exception.BinaryException e){
            e.printStackTrace();
        }
        
        try {
            _bit1 = mg.hr.Binary.toBinary(20, -5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            _bit2 = mg.hr.Binary.toBinary(20, -5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("hello world");
    }
}