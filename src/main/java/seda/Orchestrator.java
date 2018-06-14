package seda;

import java.util.ArrayList;
import java.util.Stack;

public class Orchestrator implements Observable {
    private ArrayList<Observer> observers;
    private EventType event;

    private Stack<Double> stack;
    private Double result;


    public Orchestrator() {

        this.observers = new ArrayList<>();
        this.stack = new Stack<>();
        this.result = 0d;
    }

    @Override
    public void addObserver( Observer observer ) {

        this.observers.add(observer);
    }

    @Override
    public void removeObserver( Observer observer ) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for( Observer observer : this.observers ) {
            observer.onUpdate(this);
        }
    }

    public void setEvent( EventType event ) {
        this.event = event;
        notifyObserver();
    }

    public EventType getEvent() {
        return event;
    }

    public void appendStack( Double value ) {
        stack.push(value);
    }

    public Stack<Double> getStack() {
        return stack;
    }

    public void setStack( Stack<Double> stack ) {
        this.stack = stack;
    }

    public Double getResult() {
        return result;
    }

    public void setResult( Double result ) {
        this.result = result;
    }
}
