package pl.edu.pw.ee.aisd2024zex1.sorters.insort;

import static java.util.Objects.isNull;
import pl.edu.pw.ee.aisd2024zex1.services.Sorting;

public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] data) {
        validateParams(data);

        int n = data.length;
        T currentVal;
        int j;

        for (int i = 1; i < n; i++) {

            currentVal = data[i];

            for (j = i - 1; j >= 0 && data[j].compareTo(currentVal) > 0; j--) {
                data[j + 1] = data[j];
            }
            j++;

            data[j] = currentVal;
        }
    }

    private void validateParams(T[] nums) {
        if (isNull(nums)) {
            throw new RuntimeException("Input args (data) cannot be null!");
        }
    }

}
