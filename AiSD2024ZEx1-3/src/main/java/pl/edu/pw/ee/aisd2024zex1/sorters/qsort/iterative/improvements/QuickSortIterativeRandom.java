package pl.edu.pw.ee.aisd2024zex1.sorters.qsort.iterative.improvements;

import pl.edu.pw.ee.aisd2024zex1.services.Sorting;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class QuickSortIterativeRandom<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }

        quicksort(nums);
    }

    private void quicksort(T[] data) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        Integer left = 0;
        Integer right = data.length - 1;

        starts.add(left);
        ends.add(right);

        int n = 1;
        int pivot;

        if (left < right) {

            while (n > 0) {
                n--;
                left = starts.remove(n);
                right = ends.remove(n);
                pivot = splitData(data, left, right);

                if (pivot - 1 > left) {
                    starts.add(left);
                    ends.add(pivot - 1);
                    n++;
                }

                if (pivot + 1 < right) {
                    starts.add(pivot + 1);
                    ends.add(right);
                    n++;
                }
            }
        }
    }

    private int splitData(T[] data, int start, int end) {
        Random rand = new Random();

        int randID = rand.nextInt(end)+start;
        T pivot = data[randID];
        swap(data, randID, end);

        int i = start - 1;
        int j = start;

        while (j < end) {
            if (data[j].compareTo(pivot) <= 0) {
                i++;
                swap(data, i, j);
            }

            j++;
        }

        int pivotId = ++i;
        swap(data, pivotId, end);

        return pivotId;
    }

    private void swap(T[] data, int firstId, int secondId) {
        if (firstId != secondId) {
            T firstValue = data[firstId];
            data[firstId] = data[secondId];
            data[secondId] = firstValue;
        }
    }
}
