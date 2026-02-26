/**
 * What will be the output of this code
 *      A = 1
 *      B = 1.0
 *      C = 0.9
 *      D = other
 */

public class App {
    public static void main(String[] args) {
        
        double d = 0.1;
        
        while(d != 1.0) d += 0.1;
        
        System.out.println(d);
    }
}