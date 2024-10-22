package pl.edu.pw.ee.aisd2024zex1.sorters.heapsort;

import static java.util.Objects.isNull;
import pl.edu.pw.ee.aisd2024zex1.services.Sorting;

public class HeapSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] data) {
        validateParams(data);

        buildHeap(data);

        int n = data.length;

        for (int i = n - 1; i > 0; i--) {
            swap(data, 0, i);
            heapify(data, 0, i);
        }
    }

    private void validateParams(T[] nums) {
        if (isNull(nums)) {
            throw new RuntimeException("Input args (data) cannot be null!");
        }
    }

    private void buildHeap(T[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }
    }

    private void heapify(T[] nums, int parentId, int maxId) {
        int leftChildId = 2 * parentId + 1;
        int rightChildId = 2 * parentId + 2;
        int largestValId = parentId;

        if (leftChildId < maxId && nums[leftChildId].compareTo(nums[largestValId]) > 0) {
            largestValId = leftChildId;
        }

        if (rightChildId < maxId && nums[rightChildId].compareTo(nums[largestValId]) > 0) {
            largestValId = rightChildId;
        }

        if (largestValId != parentId) {
            swap(nums, parentId, largestValId);
            heapify(nums, largestValId, maxId);
        }
    }

    private void swap(T[] nums, int firstId, int secondId) {
        if (firstId != secondId) {

            T firstVal = nums[firstId];
            nums[firstId] = nums[secondId];
            nums[secondId] = firstVal;
        }
    }
}
