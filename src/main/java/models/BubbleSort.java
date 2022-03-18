package models;

public class BubbleSort extends Sort {

    public BubbleSort(String[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int i = (array.length - 1); i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (array[j - 1].length() > array[j].length()) {
                    swap(array, (j - 1), j);
                }
            }
        }
    }
}
