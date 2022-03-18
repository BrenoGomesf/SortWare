package models;

public abstract class Sort {
    protected final String[] array;

    public Sort(String[] array) {
        this.array = array;
    }

    public abstract void sort();

    protected void swap(String[] array, int a, int b) {
        String aux = array[a];
        array[a] = array[b];
        array[b] = aux;
    }
}
