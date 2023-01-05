package task.one;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class responsible for performing bubble sorting.
 * @author Miłosz
 */
public class BubbleSort {

    public BubbleSort() {
    }

    /**
     * Method providing sorting.
     * @param input unsorted list containing objects extending Comparable
     * @return      sorted list
     */
    public List<? extends Comparable> sort(List<? extends Comparable> input) {

        if (input == null) {
            throw new RuntimeException("Given input is null");
        }

        input = input.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        int size = input.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (input.get(j) == null) {
                    continue;
                }
                if (input.get(j).compareTo(input.get(j + 1)) > 0) {
                    Collections.swap(input, j, j+1);
                }
            }
        }

        return input;
    }
}
