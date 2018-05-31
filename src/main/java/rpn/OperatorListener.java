package rpn;

import java.util.List;

public class OperatorListener implements TokenListenner{

    private List<String> operator;
    @Override
    public void addToken(double v) {

    }

    @Override
    public void addToken(String s) {
        operator.add(s);
    }

    public List<String> sendResult(){
        return  this.operator;
    }
}
