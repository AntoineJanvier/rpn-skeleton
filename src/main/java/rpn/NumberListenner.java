package rpn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberListenner implements TokenListenner {

    public List<Double> getNumber() {
        Collections.reverse(number);
        return number;
    }

    public void setNumber(List<Double> number) {
        this.number = number;
    }

    private List<Double> number = new ArrayList<>();

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
