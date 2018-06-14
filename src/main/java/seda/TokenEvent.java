package seda;

public class TokenEvent implements EventType {
    public Double value;

    public TokenEvent( String value ) {

        try {
            this.value = Double.parseDouble( value );
        }
        catch (Exception exception){
            this.value = null;
        }
    }

    @Override
    public void setValue( String value ) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public Double getValue() {
        return this.value;
    }
}
