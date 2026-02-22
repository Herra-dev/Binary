package mg.hr.exception;

public class NotAnUnsignedInteger extends java.lang.Exception {
    public NotAnUnsignedInteger(double _nbr) {
        System.out.println(_nbr + " is not an unsigned integer");
    }    
}