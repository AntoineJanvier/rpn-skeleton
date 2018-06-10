package rpn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RpnListenner {
    private HashMap<String, Double> result = new HashMap<String, Double>();

    public void getResponse(OperatorListener operatorListener, NumberListenner numberListenner) {
        List<String> op = operatorListener.getOperator();
        List<Double> num = numberListenner.getNumber();

        for(int i=0; i < num.size(); i++){
            if(i == num.size()-1){
                 result.put("OK", num.get(i));
                 return;
            }else{
                num.set(i+1, calc(op.get(i), num.get(i), num.get(i+1)));
            }

            result.put("NOK",0.0);
        }

    }

    public Double getFinalResult()  {
        if(result.get("OK") != null){
            return result.get("OK");
        }
        else{
            return -1.0;
        }
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
}
