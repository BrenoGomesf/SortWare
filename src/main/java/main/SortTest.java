package main;

import factory.FactorySort;
import models.Sort;

public class SortTest {

    private final String algorithms;
    private Long time;
    private final String[] array;

    public SortTest(String[] array, String algorithm) {
        this.algorithms = algorithm;
        this.array = array;
    }

    public void test() throws Exception {
        Spinner spinner = new Spinner();
        try {
            Sort aux = FactorySort.getSort(algorithms, array);
            System.out.println("Testing " + algorithms.toLowerCase());
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
