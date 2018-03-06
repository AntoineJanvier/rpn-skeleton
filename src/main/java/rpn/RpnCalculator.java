package rpn;

import java.util.Stack;

public class RpnCalculator {
    public static double evaluate(String exp) {
        String [] parts = exp.split(" ");
        if (isOrdered(parts)) {
            int nbOperations = getNumberOfOperations(parts);
            for (int i = 0; i < nbOperations; i++) parts = process(parts);
            return Double.valueOf(parts[0]);
        } else return processWithStack(parts);
    }

    private static int getNumberOfOperations(String[] parts) {
        int nb = 0;
        for (String part : parts)
            if (isOperator(part)) nb++;
        return nb;
    }

    private static double processWithStack(String [] strings) {
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

    private static String [] process(String [] strings) {
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

    private static boolean isOperator(String s) {
        return s.length() == 1 && ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }
    private static boolean isOrdered(String [] exp) {
        boolean operatorFound = false;
        for (String s : exp) {
            if (isOperator(s)) operatorFound = true;
            if (operatorFound && !isOperator(s)) return false;
        }
        return true;
    }
}
