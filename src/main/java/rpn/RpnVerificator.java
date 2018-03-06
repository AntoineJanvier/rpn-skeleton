package rpn;

class RpnVerificator {
    static boolean isOperator(String s) {
        return s.length() == 1 && ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }
    static boolean isOrdered(String[] exp) {
        boolean operatorFound = false;
        for (String s : exp) {
            if (isOperator(s)) operatorFound = true;
            if (operatorFound && !isOperator(s)) return false;
        }
        return true;
    }
}
