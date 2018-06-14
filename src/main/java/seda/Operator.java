package seda;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
    PLUS("+") {
        @Override
        public double operate(double left, double right){
            return left + right;
        }
    },
    MINUS("-") {
        @Override
        public double operate(double left, double right){
            return left - right;
        }
    },
    MULTIPLY("*") {
        @Override
        public double operate(double left, double right){
            return left * right;
        }
    },
    DIVIDE("/") {
        @Override
        public double operate(double left, double right){
            if(right != 0) return left / right;
            else throw new ArithmeticException("Can't divide by zero");
        }
    };
    final String symbol;
    static final Map symbolsMap = new HashMap();

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract double operate( double right, double left );

    private String getSymbol(){
        return this.symbol;
    }

    static {
        for (Operator operator : values()) {
            symbolsMap.put(operator.getSymbol(), operator);
        }
    }

    public static Operator fromSymbol(String symbol) {
        return (Operator) symbolsMap.get( symbol);
    }
}
