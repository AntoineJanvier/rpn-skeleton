package rpn;

import java.util.*;
import java.util.stream.Collectors;

class RpnProcessor {

    static double processRPN(String[] strings) {

        List<Double> num = Arrays.stream(strings).filter(s -> !isOperator(s)).map(Double::valueOf).collect(Collectors.toList());
        List<String> op = Arrays.stream(strings).filter(s -> isOperator(s)).collect(Collectors.toList());

        for(int i=num.size()-1, j=0; i >= 0; i--, j++){
            if(i == 0){
                return num.get(i);
            }else{
                num.set(i-1, calc(op.get(j), num.get(i-1), num.get(i)));
            }
        }
       return -1;
    }

    private static Double calc(String op, Double numberOne, Double numberTwo){
        switch (op.charAt(0)) {
            case '+':
                return numberOne + numberTwo;
            case '-':
                return numberOne - numberTwo;
            case '*':
                return numberOne * numberTwo;
            case '/':
                if(numberOne == 0.0 || numberTwo == 0.0 ){
                    throw new ArithmeticException("Denomitateur == 0!");
                }
                return numberOne / numberTwo;
            default:
                throw new IllegalArgumentException("op : " + op + " is not implemented");
        }
    }

    private static boolean isOperator(String s) {
        return s.length() == 1 && ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }

}
