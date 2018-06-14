package seda;

public class Token implements Observer {

    public Token() { }

    @Override
    public void onUpdate(Observable observable) {
        if( observable instanceof Orchestrator ) {

            Orchestrator orchestrator = (Orchestrator) observable;
            EventType event = orchestrator.getEvent();

            if(event instanceof TokenEvent) {

                Double value = (Double) event.getValue();

                if( value != null ) {

                    orchestrator.appendStack(value);
                }
            }
        }
    }

}
