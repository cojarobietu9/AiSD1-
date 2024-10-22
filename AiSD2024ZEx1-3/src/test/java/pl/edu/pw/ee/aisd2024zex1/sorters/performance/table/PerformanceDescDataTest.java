package pl.edu.pw.ee.aisd2024zex1.sorters.performance.table;

import static pl.edu.pw.ee.aisd2024zex1.sorters.utils.Generators.createDescendingData;

public class PerformanceDescDataTest<T extends Comparable<T>> extends PerformanceTest<T> {

    @Override
    protected T[] generateData(int size) {
        return (T[])createDescendingData(size);
    }

}
