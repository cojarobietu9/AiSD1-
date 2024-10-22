package pl.edu.pw.ee.aisd2024zex1.sorters.qsort.iterative.improvements;

import java.util.ArrayList;
import java.util.List;
import pl.edu.pw.ee.aisd2024zex1.services.Sorting;

public class QuickSortIterativeMedian3<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Input args (data) cannot be null!");
        }

        quicksort(data);
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
                pivot = partition(data, left, right);

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

    private int partition(T[] data, int start, int end) {
        int inBetween = (start + end) / 2;
        int mediana = med3(data, start, end, inBetween);
        swap(data, mediana, end);
        T pivot = data[end];

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

    private int med3(T[] data, int r, int m, int l){
        if (data[r].compareTo(data[m]) >= 0){
            if(data[m].compareTo(data[l]) <= 0){
                return l;
            }
            else{
                return m;

            }
        }
        else{
            if(data[r].compareTo(data[l]) <= 0){
                return l;
            }
            else{
                return r;

            }

        }
    }
}

