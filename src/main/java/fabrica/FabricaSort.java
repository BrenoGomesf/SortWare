package fabrica;

import modelos.*;

public class FabricaSort {
    private enum Sorts {
        BUBBLESORT, MERGESORT, INSERTIONSORT, QUICKSORT
    }

    public static ISort getSort(String sort, String[] array) {
        Sorts name = Sorts.valueOf(sort.toUpperCase());
        return switch (name) {
            case BUBBLESORT -> new BubbleSort(array);
            case MERGESORT -> new MergeSort(array);
            case INSERTIONSORT -> new InsertionSort(array);
            case QUICKSORT -> new QuickSort(array);
        };
    }
}
