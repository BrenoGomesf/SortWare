package main;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;
import dal.DataFiles;
import fabrica.FabricaSort;
import modelos.ISort;
import modelos.SearchAlgorithms;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public enum Sorts {
        BUBBLESORT, MERGESORT, INSERTIONSORT, QUICKSORT, All;
    }

    private static Scanner input = new Scanner(System.in);
    private static String dictionaryPath = "";

    public static void main(String[] args)  {
        System.out.println("SortWare - teste de algoritmos de ordenação\n");

        try {
            do {
                getIdioma();
                DataFiles dictionary = new DataFiles(dictionaryPath);
                String[] array = dictionary.lerAquivoDic();
                Sorts sort = getOpcaoMenuSort();
                AlgorithmsTest test;
                if (!sort.equals(Sorts.All)) {
                    test = new AlgorithmsTest(array,sort.toString());
                    test.testar();
                    System.out.println("\n" + test.getTime() + " ms.");
                } else {
                    for (Sorts aux : Sorts.values()) {
                        if (!aux.equals(Sorts.All)) {
                            array = dictionary.lerAquivoDic();
                            test = new AlgorithmsTest(array, aux.toString());
                            test.testar();
                            System.out.println("\n" + test.getTime() + " ms.");
                        }
                    }
                }

                DataFiles saida = new DataFiles("./src/main/resources/saida.txt");
                saida.salvarArquivo(array);

                ArrayList<String> arrayListSaida = saida.lerAquivo();
                String[] output = new String[arrayListSaida.size()];
                for (int i = 0; i < arrayListSaida.size(); i++) {
                    output[i] = arrayListSaida.get(i);
                }
                buscarNoVetor(output);
            } while (repetir());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }

    }

    public static boolean repetir() {
        char menu = ' ';
        do {
            showMessageDialog("Repetir o Testes: [s/n] ");
            menu = input.next().toLowerCase().charAt(0);
        } while (menu != 's' && menu != 'n');
        return menu == 's';
    }

    private static void getIdioma() {
        System.out.println("""
                Idiomas disponiveis:
                
                [1] - Portugues
                [2] - English
                [3] - Spanish
                """);
        int menu;
        do {
            showMessageDialog("Informe o idioma na qual deseja testar: ");
            menu = input.nextInt();
        } while (menu != 1 && menu != 2 && menu != 3);

        dictionaryPath = "./src/main/resources/";
        switch (menu) {
            case 1 -> dictionaryPath += "Portugues(pt_BR).txt";
            case 2 -> dictionaryPath += "English(American).txt";
            case 3 -> dictionaryPath += "Spanish.txt";
        }
    }

    private static void showMessageDialog(String text) {
        AnsiFormat blue = new AnsiFormat(Attribute.BLUE_TEXT());
        AnsiFormat bold = new AnsiFormat(Attribute.BOLD());
        System.out.print(Ansi.colorize(":: ", blue) + Ansi.colorize(text, bold));
    }

    private static Sorts getOpcaoMenuSort() {
        String op = """
                Algoritmos:
                
                [1] - MergeSort
                [2] - QuickSort
                [3] - InsertionSort
                [4] - BubbleSort
                [5] - Todos
                """;
        System.out.println(op);
        int menu;
        do {
            showMessageDialog("Informe o algoritmo na qual deseja testar: ");
            menu = input.nextInt();
        } while (menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5);

        return switch (menu) {
            case 1 -> Sorts.MERGESORT;
            case 2 -> Sorts.QUICKSORT;
            case 3 -> Sorts.INSERTIONSORT;
            case 4 -> Sorts.BUBBLESORT;
            case 5 -> Sorts.All;
            default -> throw new IllegalStateException("Unexpected value: " + menu);
        };

    }

    public static void buscarNoVetor(String[] array) throws Exception{
        showMessageDialog("Informe qual palavra deseja buscar: ");
        String word = input.next();
        String op = """
                Algoritmos:
                
                [1] - Busca Binaria
                [2] - Busca Sequencial
                """;
        System.out.println(op);
        int menu;
        do {
            showMessageDialog("Informe o algoritmo na qual deseja testar: ");
            menu = input.nextInt();
        } while (menu != 1 && menu != 2);

        SearchAlgorithms busca = new SearchAlgorithms();
        int index = 0;
        long time = 0;
        switch (menu) {
            case 1 -> {
                time = System.currentTimeMillis();
                index = busca.buscaBinaria(array, word);
                time = System.currentTimeMillis() - time;
            }
            case 2 -> {
                time = System.currentTimeMillis();
                index = busca.buscaSequencial(array, word);
                time = System.currentTimeMillis() - time;
            }
        }

        System.out.println("Tempo: " + time + " ms.\nIndex do Elemento: " + index);
        System.out.println("Elemento: " + array[index]);
    }

}
