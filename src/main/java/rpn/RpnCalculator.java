package rpn;

public class RpnCalculator {
    public static double evaluate(String exp) {
        String[] parts =  exp.split("\\s+");

        return new RpnProcessor().processRPN(getToken(parts));

    }

    public static Token[] getToken(String[] array){
        Token[] tokens = new Token[array.length];
        int i;
        for(i=0; i <array.length ;i++  ){
            tokens[i]=new Token(array[i]);
        }
        return tokens;
    }
}
