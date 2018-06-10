package rpn;

import java.util.ArrayList;
import java.util.List;

public class OperatorListener implements TokenListenner{

    private List<String> operator = new ArrayList<>();
    @Override
    public void addToken(double v) {

    }

    @Override
    public void addToken(String s) {
        operator.add(s);
    }

    public List<String> getOperator() {
        return operator;
    }

    public void setOperator(List<String> operator) {
        this.operator = operator;
    }

    public List<String> sendResult(){
        return  this.operator;
    }
}
