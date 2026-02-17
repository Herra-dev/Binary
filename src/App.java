public class App
{
    public static void main(String[] args)
    {
        // try
        // {
            // byte[] _b = mg.hr.Binary._toBinaryFloat(0.5, mg.hr.enumeration.FloatPrecision._SIMPLE_PRECISION);
            // byte[] _b1 = mg.hr.Binary.toBinary(1000, 8);
            // for(byte b: _b)
            //     System.out.print(b);
            // System.out.println();
            // for(byte b: _b1)
            //     System.out.print(b);
            // System.out.println();

            // System.out.print("in binary: ");
            for(byte b: mg.hr.BinaryMath._addBinary(22.6665, 5, 8))
                System.out.print(b);
            System.out.println();

            for(byte b: mg.hr.BinaryMath._addBinary(22.6665, 5, 8))
                System.out.print(b);
            System.out.println();
            // System.out.print("in decimal: ");
            // for(byte b: mg.hr.BinaryMath._subtractBinary(200.566, 1000, 8))
            //     System.out.print(b);
            // System.out.println();
            
            // for(byte b : mg.hr.Binary.toBinary(-98, 8))
            //     System.out.print(b);

            // System.out.println();
        // } 
        // catch (mg.hr.exception.BinaryException e) 
        // {
        //     e.printStackTrace();
        // }
        
    }
}