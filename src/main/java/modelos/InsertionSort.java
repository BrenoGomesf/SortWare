package modelos;

public class InsertionSort implements ISort {

    private final String[] array;

    public InsertionSort(String[] array) {
        this.array = array;
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
