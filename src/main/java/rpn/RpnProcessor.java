package rpn;

import java.util.Stack;

import static rpn.RpnVerificator.isOperator;

class RpnProcessor {
    static double processWithStack(String[] strings) {
        Stack<Double> stack = new Stack<>();
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

    static String [] processOrdered(String[] strings) {
        double first = Double.valueOf(strings[0]);
        double second = Double.valueOf(strings[1]);
        char op = '0';
        for (String string : strings) if (isOperator(string)) { op = string.charAt(0);break; }
        String [] ret = new String[strings.length - 2];
        switch (op) {
            case '+':
                ret[0] = String.valueOf(first + second);
                break;
            case '-':
                ret[0] = String.valueOf(first - second);
                break;
            case '*':
                ret[0] = String.valueOf(first * second);
                break;
            case '/':
                ret[0] = String.valueOf(first / second);
                break;
            default:
                break;
        }
        boolean skipped = false;
        for (int i = 1; i < ret.length; i++) {
            if (strings[i + 1].equals(String.valueOf(op)) && !skipped) skipped = true;
            ret[i] = skipped ? strings[i + 2] : strings[i + 1];
        }
        return ret;
    }
}
