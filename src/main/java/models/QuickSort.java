package models;

public class QuickSort extends Sort {

    public QuickSort(String[] array) {
        super(array);
    }

    @Override
    public void sort() {
        quickSort(this.array, 0, (array.length - 1));
    }

    private int partition(String[] array, int low, int high) {
        String pivot = array[low];
        int i = low - 1, j = high + 1;

        while (true) {
            do {
                i++;
            } while (array[i].length() < pivot.length());

            do {
                j--;
            } while (array[j].length() > pivot.length());

            if (i >= j) return j;
            swap(array, i, j);
        }
    }

    private void quickSort(String[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot);
            quickSort(array, (pivot + 1), high);
        }
    }
}
