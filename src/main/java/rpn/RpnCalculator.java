package rpn;

public class RpnCalculator {
    public static double evaluate(String exp) {
        String [] parts = exp.split("\\s+");
        return new RpnProcessor().processRPN(parts);
    }
}
