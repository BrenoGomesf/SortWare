package models;

public class MergeSort extends Sort {

    public MergeSort(String[] array) {
        super(array);
    }

    @Override
    public void sort() {
        mergeSort(array);
    }

    private void mergeSort(String[] array) {
        int arraySize = array.length;
        if (0 < (arraySize - 1)) {
            int metade = arraySize / 2;
            String[] left = new String[metade];
            String[] right = new String[arraySize - metade];
            System.arraycopy(array, 0, left, 0, metade);
            System.arraycopy(array, metade, right, 0, array.length - metade);
            mergeSort(left);
            mergeSort(right);
            merge(array,left,right);
        }
    }

    private void merge(String[] array, String[] left, String[] right) {
        int i = 0, j = 0;
        for (int k = 0; k < array.length; k++) {
            if (i < left.length && j < right.length) {
                if (left[i].length() <= right[j].length()) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
            } else {
                if (i < left.length) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
            }
        }
    }
}
