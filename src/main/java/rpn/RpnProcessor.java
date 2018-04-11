package rpn;

import java.util.*;
import java.util.stream.Collectors;
import static rpn.RpnVerificator.isOperator;

class RpnProcessor {

    private Queue<String> queue = new LinkedList<String>();


    static double processWithStack(String[] strings) {

        List<Double> num = Arrays.stream(strings).filter(s -> !isOperator(s)).map(Double::valueOf).collect(Collectors.toList());
        List<String> op = Arrays.stream(strings).filter(s -> isOperator(s)).collect(Collectors.toList());
        List<Double> numRevere = num.subList(0, num.size());
        Collections.reverse(numRevere);


        for(int i=0; i < num.size(); i++){
            if(i == numRevere.size()-1){
                return numRevere.get(i);
            }else{
                numRevere.set(i+1, calc(op.get(i),numRevere.get(i), numRevere.get(i+1)));
            }
        }
        return 0.0;
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
                    new ArithmeticException("Denomitateur == 0!");
                }
                return numberOne / numberTwo;
            default:
                new IllegalArgumentException("op : " + op + " is not implemented");
        }

        return 0.0;
    }


}
