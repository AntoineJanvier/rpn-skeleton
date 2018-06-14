package seda;

import rpn.RpnCalculator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {

    private Orchestrator orchestrator;

    public CLI() {
        this.orchestrator = new Orchestrator();

        Operation operation = new Operation();
        Token token = new Token();
        ResultDisplayer resultDisplayer = new ResultDisplayer();

        orchestrator.addObserver(operation);
        orchestrator.addObserver(token);
        orchestrator.addObserver(resultDisplayer);
    }

    public static void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        double result = evaluate(expression);
        System.out.println("> " + result);
    }

    static double evaluate(String expression) {

        return RpnCalculator.evaluate(expression);
    }
}
