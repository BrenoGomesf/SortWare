package main;

import fabrica.FabricaSort;
import modelos.ISort;

public class AlgorithmsTest {

    private final String algoritmo;
    private Long time;
    private final String[] array;

    public AlgorithmsTest(String[] array, String algoritmo) {
        this.algoritmo = algoritmo;
        this.array = array;
    }

    public void testar() {
        ISort aux = FabricaSort.getSort(algoritmo, array);
        Spinner spinner = new Spinner();
        spinner.start();
        time = System.currentTimeMillis();
        aux.sort();
        time = System.currentTimeMillis() - time;
        spinner.setShowProgress(false);
    }

    public Long getTime() {
        return time;
    }
}
