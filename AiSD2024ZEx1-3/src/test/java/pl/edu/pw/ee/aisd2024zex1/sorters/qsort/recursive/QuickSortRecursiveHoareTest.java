package pl.edu.pw.ee.aisd2024zex1.sorters.qsort.recursive;

import pl.edu.pw.ee.aisd2024zex1.sorters.utils.GeneralSortTest;

public class QuickSortRecursiveHoareTest<T extends Comparable<T>> extends GeneralSortTest<T> {

    public QuickSortRecursiveHoareTest() {
        super(new QuickSortRecursiveHoare<>());
    }

}
