package pl.edu.pw.ee.aisd2024zex1.services;

public interface Sorting<T extends Comparable<T>> {

    void sort(T[] nums);
}
