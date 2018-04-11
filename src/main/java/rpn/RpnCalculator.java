package rpn;

import static rpn.RpnProcessor.processRPN;

public class RpnCalculator {
    public static double evaluate(String exp) {
        String [] parts = exp.split("\\s+");
        return processRPN(parts);
    }
}
