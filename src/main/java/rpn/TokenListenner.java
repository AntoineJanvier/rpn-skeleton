package rpn;

import java.util.ArrayList;
import java.util.List;

interface TokenListenner {

    List<TokenListenner> listListernner = new ArrayList<>();

    void addToken(double v);

    void addToken(String s);

    List sendResult();
}
