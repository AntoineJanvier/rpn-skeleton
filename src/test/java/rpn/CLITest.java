package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.CLI.evaluate;

public class CLITest {

    // Begin tests
    @Test
    public void should_evaluate_single_digit_constant() {
        assertThat(evaluate("5")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        assertThat(evaluate("17")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_addition() {
        assertThat(evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        assertThat(evaluate("2 3 5 + +")).isEqualTo(10);
    }

    // More tests
    @Test
    public void should_evaluate_simple_substraction() {
        assertThat(evaluate("2 5 -")).isEqualTo(-3);
    }

    @Test
    public void should_evaluate_bigger_substraction() {
        assertThat(evaluate("2 5 7 - -")).isEqualTo(-10);
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        assertThat(evaluate("2 -5 *")).isEqualTo(-10);
    }

    @Test
    public void should_evaluate_bigger_multiplication() {
        assertThat(evaluate("2 5 7 * *")).isEqualTo(70);
    }

    @Test
    public void should_evaluate_simple_division() {
        assertThat(evaluate("5 -2 /")).isEqualTo(-2.5);
    }

    @Test
    public void should_evaluate_bigger_division() {
        assertThat(evaluate("5 2 10 / /")).isEqualTo(0.25);
    }

    @Test
    public void should_evaluate_complex_expression() {
        assertThat(evaluate("5 2 10 2 2.5 -1 + * / - *")).isEqualTo(-32.5);
    }
}