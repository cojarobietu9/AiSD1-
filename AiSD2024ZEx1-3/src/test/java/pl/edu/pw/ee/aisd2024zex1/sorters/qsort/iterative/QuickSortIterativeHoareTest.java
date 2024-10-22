package pl.edu.pw.ee.aisd2024zex1.sorters.qsort.iterative;

import pl.edu.pw.ee.aisd2024zex1.sorters.utils.GeneralSortTest;

public class QuickSortIterativeHoareTest<T extends Comparable<T>> extends GeneralSortTest<T> {

    public QuickSortIterativeHoareTest() {
        super(new QuickSortIterativeHoare<>());
    }

}
