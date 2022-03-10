package fabrica;


import modelos.BubbleSort;
import modelos.InsertionSort;
import modelos.ISort;
import modelos.MergeSort;

public class FabricaSort {

    private enum Sorts {
        BUBBLESORT, MERGESORT, INSERTIONSORT;
    }

    public static ISort getSort(String sort, String[] array) {
        Sorts name = Sorts.valueOf(sort.toUpperCase());
        return switch (name) {
            case BUBBLESORT -> new BubbleSort(array);
            case MERGESORT -> new MergeSort(array);
            case INSERTIONSORT -> new InsertionSort(array);
        };
    }
}
