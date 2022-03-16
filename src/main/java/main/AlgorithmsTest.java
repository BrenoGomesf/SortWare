package main;

import fabrica.FabricaSort;
import modelos.ISort;

public class AlgorithmsTest {

    private final String algoritmo;
    private Long time;
    private float tempoMin;
    private float tempoSeg;
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
            tempoMin = ((time/1000)/60);
            tempoSeg = (time / 1000 / 60) % 60;
        } finally {
            spinner.setShowProgress(false);
        }
    }

    public Long getTime() {
        return time;
    }

    public float getTempoMin(){
        return tempoMin;
    }

    public float getTempoSeg(){
        return tempoSeg;
    }
}
