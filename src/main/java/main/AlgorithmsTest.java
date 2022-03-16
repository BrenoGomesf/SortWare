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

    public void testar() throws Exception {
        Spinner spinner = new Spinner();
        try {
            ISort aux = FabricaSort.getSort(algoritmo, array);
            System.out.println("Testando o " + algoritmo);
            spinner.start();
            time = System.currentTimeMillis();
            aux.sort();
            time = System.currentTimeMillis() - time;
            spinner.setShowProgress(false);
        } finally {
            spinner.setShowProgress(false);
        }
    }

    public Long getTime() {
        return time;
    }
}
