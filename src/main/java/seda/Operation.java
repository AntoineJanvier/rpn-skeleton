package seda;

import java.util.Stack;

public class Operation implements Observer {

    private Stack<Double> stack;
    private Operator operator;

    @Override
    public void onUpdate(Observable observable) {

    }
    private void operate() {

        if( this.stack.size() > 1 ) {

            double right = stack.peek();
            stack.pop();

            double left = stack.peek();
            stack.pop();

            double step = operator.operate(left, right);

            stack.push(step);

        }
    }

}
