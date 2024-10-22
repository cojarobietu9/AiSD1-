package pl.edu.pw.ee.aisd2024zex1.sorters.insort;

import pl.edu.pw.ee.aisd2024zex1.sorters.utils.GeneralSortTest;

public class InsertionSortTest<T extends Comparable<T>> extends GeneralSortTest<T> {

    public InsertionSortTest() {
        super(new InsertionSort<>());
    }

}
