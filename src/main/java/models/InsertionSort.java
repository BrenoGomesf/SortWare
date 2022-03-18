package models;

public class InsertionSort extends Sort {

    public InsertionSort(String[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int i = 0; i < array.length; i++) {
            String aux = array[i];
            int j = i;
            while (j > 0 && array[j - 1].length() > aux.length()) {
                array[j] = array[j - 1];
                j -= 1;
            }
            array[j] = aux;
        }
    }
}
