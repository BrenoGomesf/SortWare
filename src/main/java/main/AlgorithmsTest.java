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

    public void testar() {
        ISort aux = FabricaSort.getSort(algoritmo, array);
        Spinner spinner = new Spinner();
        spinner.start();

        time = System.currentTimeMillis();
        aux.sort();
        time = System.currentTimeMillis() - time;
        tempoMin = ((time/1000)/60);
        tempoSeg = (time / 1000 / 60) % 60;
        spinner.setShowProgress(false);
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
