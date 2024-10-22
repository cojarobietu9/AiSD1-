package pl.edu.pw.ee.aisd2024zex1.sorters.countingsort;

import static java.util.Objects.isNull;

public class CountingSort {

    public void countingSort(int[] nums, int maxVal) {
        validateInput(nums, maxVal);

        int n = nums.length;
        int nOfBuckets = maxVal;

        int[] buckets = new int[nOfBuckets];

        for (int i = 0; i < n; i++) {
            buckets[nums[i]]++;
        }

        int j = 0;
        for (int i = 0; i < nOfBuckets; i++) {
            while (buckets[i] > 0) {
                nums[j++] = i;
                buckets[i]--;
            }
        }
    }

    private void validateInput(int[] nums, int maxVal) {
        if (isNull(nums)) {
            throw new IllegalArgumentException("Input nums cannot be null!");
        }

        int n = nums.length;

        if (maxVal >= n) {
            throw new IllegalArgumentException("MaxVal was expected to be much lower than size of nums!");
        }
    }
}
