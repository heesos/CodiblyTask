import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import task.one.BubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleSortTest {

    static BubbleSort bubbleSort = null;

    @BeforeAll
    public static void init() {
        bubbleSort = new BubbleSort();
    }

    @Test
    void integer_input_gives_correct_output() {
        List<Integer> input = new ArrayList<>(List.of(1,4,5,6,8,3,8));
        List<Integer> expectedOutput = new ArrayList<>(List.of(1,3,4,5,6,8,8));

        Assertions.assertEquals(expectedOutput, bubbleSort.sort(input));
    }

    @Test
    void float_point_input_gives_correct_output() {
        List<Comparable> input = new ArrayList(Arrays.asList(-9.3,0.2,4.0,0.1,5.0,9.0));
        List<Comparable> expectedOutput = new ArrayList<>(List.of(-9.3,0.1,0.2,4.0,5.0,9.0));

        Assertions.assertEquals(expectedOutput, bubbleSort.sort(input));
    }

    @Test
    void empty_list_as_input_returns_empty_list() {
        Assertions.assertEquals(Collections.EMPTY_LIST, bubbleSort.sort(Collections.EMPTY_LIST));
    }

    @Test
    void null_input_throws_exception() {
        Assertions.assertThrows(RuntimeException.class, () -> bubbleSort.sort(null));
    }

    @Test
    void list_with_one_null_value() {
        List<Comparable> input = new ArrayList(Arrays.asList(null, -5.0001));
        List<Comparable> expectedOutput = new ArrayList<>(List.of(-5.0001));

        Assertions.assertEquals(expectedOutput, bubbleSort.sort(input));
    }
}
