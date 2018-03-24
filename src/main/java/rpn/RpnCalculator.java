package rpn;

import static rpn.RpnProcessor.processWithStack;

public class RpnCalculator {
    public static double evaluate(String exp) {
        String [] parts = exp.split("\\s+");
        return processWithStack(parts);
    }
}
