package rpn;

public class Token {
    private String value;

    public Token(String s){
        this.value = s;
    }

    @Override
    public String toString() {
        return value;
    }
}
