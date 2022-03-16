package modelos;

public class QuickSort implements ISort {

    private final String[] array;

    public QuickSort(String[] array) {
        this.array = array;
    }

    @Override
    public void sort() {
        quickSort(this.array, 0, (array.length - 1));
    }

    private void quickSort(String[] array, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = partitionLomuto(array, inicio, fim);
            quickSort(array,inicio, (pivo - 1));
            quickSort(array, (pivo + 1), fim);
        }
    }

    // Paricionamento de Lomuto
    private int partitionLomuto(String[] array, int inicio, int fim) {
        String pivo = array[inicio];
        int i = inicio;

        for (int j = inicio + 1; j <= fim; j++) {
            if (array[j].length() <= pivo.length()) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, inicio, i);
        return i;
    }

    // Particiona de Hoare !!! NÃO TESTADO !!!
    private int partitionHoare(String[] array, int inicio, int fim) {
        String pivo = array[inicio];
        int esquerda = inicio + 1, direita = fim;
        while (esquerda < direita) {
            while (esquerda <= direita && array[esquerda].length() <= pivo.length()) {
                esquerda++;
            }
            while (direita > esquerda && array[direita].length() >= pivo.length()) {
                direita--;
            }
            if (esquerda < direita) {
                swap(array, esquerda, direita);
                direita--;
                esquerda++;
            }
        }
        array[inicio] = array[direita];
        array[direita] = pivo;
        return direita;
    }

    private void swap(String[] array, int a, int b) {
        String aux = array[a];
        array[a] = array[b];
        array[b] = aux;
    }
}
