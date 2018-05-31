package rpn;

import java.util.*;
import java.util.stream.Collectors;

class RpnProcessor {
    private  List<TokenListenner> tokenListenners = new ArrayList<TokenListenner>();
    private NumberListenner numberListenner = new NumberListenner();
    private OperatorListener operatorListener = new OperatorListener();
    private RpnListenner rpnListener = new RpnListenner();

    double processRPN(String[] strings) {
        tokenListenners.add(operatorListener);
        tokenListenners.add(numberListenner);
        for(String token : strings){
           notify(token);
        }

        RpnListenner.getResponse(operatorListener), getResponse(numberListenner))
       return -1;
    }


    private void notify(String s){

        if(isOperator(s)){
            for (TokenListenner listenner : tokenListenners){
                listenner.addToken(s);
            }
        }else{
            for (TokenListenner listenner : tokenListenners){
                listenner.addToken(Double.parseDouble(s));
            }
        }



    }

    private List<?> getResponse(TokenListenner tokenListenner){
        return tokenListenner.sendResult();
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


    /////


    ////
}
