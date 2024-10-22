package pl.edu.pw.ee.aisd2024zex1.sorters.refsort;

import pl.edu.pw.ee.aisd2024zex1.sorters.utils.GeneralSortTest;

public class RefAlgSortTest<T extends Comparable<T>> extends GeneralSortTest<T> {

    public RefAlgSortTest() {
        super(new RefAlgSort<>());
    }

}
