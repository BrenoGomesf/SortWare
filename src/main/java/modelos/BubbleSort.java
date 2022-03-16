package modelos;

public class BubbleSort implements ISort {

    private final String[] vetor;

    public BubbleSort(String[] vetor) {
        this.vetor = vetor;
    }

    @Override
    public void sort() {
        for (int i = (vetor.length - 1); i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (vetor[j - 1].length() > vetor[j].length()) {
                    swap(vetor, (j - 1), j);
                }
            }
        }
    }

    private void swap(String[] array, int a, int b) {
        String aux = array[a];
        array[a] = array[b];
        array[b] = aux;
    }
}
