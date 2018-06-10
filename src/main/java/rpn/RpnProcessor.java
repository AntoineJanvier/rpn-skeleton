package rpn;

import java.util.*;
import java.util.stream.Collectors;

class RpnProcessor {
    private  List<TokenListenner> tokenListenners = new ArrayList<TokenListenner>();
    private NumberListenner numberListenner = new NumberListenner();
    private OperatorListener operatorListener = new OperatorListener();

    private RpnListenner rpnListener = new RpnListenner();

    double processRPN(String[] strings)  {
        //On ajoute les listenners
        tokenListenners.add(operatorListener);
        tokenListenners.add(numberListenner);

        for(String token : strings){
           notify(token);
        }
        notify("EOF");
        return rpnListener.getFinalResult();


    }

    //On ajoute les token au bons listenner
    private void notify(String s){
        if(s.equals("EOF")){
            rpnListener.getResponse(operatorListener, numberListenner);
            return;
        }
        if(isOperator(s)){
            operatorListener.addToken(s);//Listenner par operateur ?
        }else{
            numberListenner.addToken(Double.valueOf(s));
        }
    }

    private List<?> getResponse(TokenListenner tokenListenner){
        return tokenListenner.sendResult();
    }



    private static boolean isOperator(String s) {
        return s.length() == 1 && ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }

}
