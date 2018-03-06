package rpn;

import static rpn.RpnProcessor.processOrdered;
import static rpn.RpnProcessor.processWithStack;
import static rpn.RpnVerificator.isOrdered;

public class RpnCalculator {
    public static double evaluate(String exp) {
        String [] parts = exp.split(" ");
        if (isOrdered(parts)) {
            while (parts.length > 1) parts = processOrdered(parts);
            return Double.valueOf(parts[0]);
        } else return processWithStack(parts);
    }
}
