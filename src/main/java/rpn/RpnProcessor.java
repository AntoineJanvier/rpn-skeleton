package rpn;

import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.abs;
import static rpn.RpnVerificator.isOperator;

class RpnProcessor {
    static double processWithStack(String[] strings) {
        Stack<Double> stack = new Stack<>();
        //TODO : QUEU REPLACEMENT (need implmeent method)
        //Queue<Double> queue = new Queue<Double>();

        for (String s : strings) {
            if (!isOperator(s)) stack.push(Double.valueOf(s));
            else {
                char op = s.charAt(0);
                double a = stack.pop(), b = stack.pop();
                switch (op) {
                    case '+':
                        a = b + a;
                        break;
                    case '-':
                        a = b - a;
                        break;
                    case '*':
                        a = b * a;
                        break;
                    case '/':
                        a = b / a;
                        break;
                    default:
                        break;
                }
                stack.push(a);
            }
        }
        return stack.pop();
    }
}
