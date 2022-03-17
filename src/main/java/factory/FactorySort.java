package factory;

import models.*;

public class FactorySort {
    private enum Sorts {
        BUBBLE, MERGE, INSERTION, QUICK;
    }

    public static Sort getSort(String sort, String[] array) {
        Sorts name = Sorts.valueOf(sort.toUpperCase());
        return switch (name) {
            case BUBBLE -> new BubbleSort(array);
            case MERGE -> new MergeSort(array);
            case INSERTION -> new InsertionSort(array);
            case QUICK -> new QuickSort(array);
        };
    }
}
