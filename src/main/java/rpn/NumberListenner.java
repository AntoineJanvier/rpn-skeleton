package rpn;

import java.util.List;

public class NumberListenner implements TokenListenner {

    private List<Double> number;

    @Override
    public void addToken(double v) {
        number.add(v);
    }

    @Override
    public void addToken(String s) {
        //
    }

    public List<Double> sendResult(){
        return this.number;
    }
}
