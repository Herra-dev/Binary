package mg.hr.exception;

public class NotABinaryNumber extends java.lang.Exception {
    public NotABinaryNumber(int binaryNumber) {
        System.out.println("Impossible, " + binaryNumber + " is not a binary number!");
    }
}