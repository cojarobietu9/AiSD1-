package pl.edu.pw.ee.aisd2024zex1.sorters.refsort;

import java.util.Arrays;
import static java.util.Objects.isNull;
import pl.edu.pw.ee.aisd2024zex1.services.Sorting;

public class RefAlgSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] data) {
        validateInput(data);

        Arrays.sort(data);
    }

    private void validateInput(T[] data) {
        if (isNull(data)) {
            throw new RuntimeException("Input args (data) cannot be null!");
        }
    }
}
