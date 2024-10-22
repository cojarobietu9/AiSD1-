package pl.edu.pw.ee.aisd2024zex1.sorters.performance.charts;

import pl.edu.pw.ee.aisd2024zex1.sorters.qsort.iterative.QuickSortIterativeLomuto;
import static pl.edu.pw.ee.aisd2024zex1.sorters.performance.charts.utils.DataArrangeType.ASC;

public class QuickSortPerformanceChartsAscDataTest<T extends Comparable<T>> extends PerformanceChartsTest<T> {

    public QuickSortPerformanceChartsAscDataTest() {
        super(new QuickSortIterativeLomuto<>(), ASC);
    }

}
