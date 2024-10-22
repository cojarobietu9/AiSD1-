package pl.edu.pw.ee.aisd2024zex1.sorters.performance.table;

import static java.lang.String.format;
import java.util.Arrays;
import java.util.logging.Logger;

import pl.edu.pw.ee.aisd2024zex1.services.Sorting;

public class TimeMeasureTask<T extends Comparable<T>> implements Runnable {

    private static final Logger LOG = Logger.getLogger(TimeMeasureTask.class.getName());

    private final Sorting<T> sorter;

    private final T[] orgDataToSort;

    private long averageTime;

    public TimeMeasureTask(Sorting<T> sorter, T[] dataToSort) {
        this.sorter = sorter;
        this.orgDataToSort = dataToSort;

        this.averageTime = -1;
    }

    public long getAverageTime() {
        return averageTime;
    }

    @Override
    public void run() {
        try {
            averageTime = measureAvgTimeOfSorting();
        } catch (Exception e) {
            String message = format("Error during TimeMeasureTask.run() [message: %s].", e.toString());
            LOG.severe(message);
        }
    }

    private long measureAvgTimeOfSorting() {
        long[] timeResults = measureTimeInLoop();

        long avgTime = countAvgWithoutTenOutliers(timeResults);

        return avgTime;
    }

    private long[] measureTimeInLoop() {
        int nOfRepeat = 100;
        long[] timeResults = new long[nOfRepeat];

        int n = orgDataToSort.length;
        T[] dataToSort = (T[]) new Comparable[n];

        long currentResult;

        for (int i = 0; i < nOfRepeat; i++) {
            System.arraycopy(orgDataToSort, 0, dataToSort, 0, n);

            currentResult = measureTimeOfSingleSorting(sorter, dataToSort);
            timeResults[i] = currentResult;
        }

        return timeResults;
    }

    private long measureTimeOfSingleSorting(Sorting<T> sorter, T[] dataToSort) {
        long start = System.nanoTime();

        sorter.sort(dataToSort);

        long result = System.nanoTime() - start;

        return result;
    }

    private long countAvgWithoutTenOutliers(long[] timeResults) {
        Arrays.sort(timeResults);

        int nOfOutliers = 10;

        int nOfResults = timeResults.length;
        int start = nOfOutliers;
        int end = nOfResults - nOfOutliers;

        int n = nOfResults - 2 * nOfOutliers;

        assert start < end;

        long avgResult = 0;

        for (int i = start; i < end; i++) {
            avgResult += timeResults[i];
        }

        avgResult /= n;

        return avgResult;
    }

}
