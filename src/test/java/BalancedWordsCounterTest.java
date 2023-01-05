import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import task.one.BubbleSort;
import task.two.BalancedWordsCounter;

public class BalancedWordsCounterTest {

    static BalancedWordsCounter balancedWordsCounter = null;

    @BeforeAll
    public static void init() {
        balancedWordsCounter = new BalancedWordsCounter();
    }

    @Test
    void given_input_with_correct_output() {
        int expected = 28;
        Assertions.assertEquals(expected, balancedWordsCounter.count("aabbabcccba"));
    }

    @Test
    void given_input_contains_digit_throws_exception() {
        Assertions.assertThrows(RuntimeException.class, () -> balancedWordsCounter.count("abababa1"));
    }

    @Test
    void null_input_throws_exception() {
        Assertions.assertThrows(RuntimeException.class, () -> balancedWordsCounter.count(null));
    }

    @Test
    void empty_input_correct_output() {
        int expected = 0;
        Assertions.assertEquals(expected, balancedWordsCounter.count(""));

    }
}
