package main;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;
import dal.DataFiles;
import fabrica.FabricaSort;
import modelos.ISort;
import modelos.SearchAlgorithms;

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
            getIdioma();
            DataFiles dictionary = new DataFiles(dictionaryPath);
            String[] array = dictionary.lerAquivo();
            AlgorithmsTest test = new AlgorithmsTest(array, getOpcaoMenuSort().toString());

            test.testar();
            System.out.println("\n" + test.getTime() + " ms.");
            System.out.println("\n" + test.getTempoMin() + " minutos e " + test.getTempoSeg() + " segundos.");

            SearchAlgorithms busca = new SearchAlgorithms();

            DataFiles saida = new DataFiles("/home/hypper/Downloads/saida.txt");
            saida.salvarArquivo(array);


            for (String text : array) {
                System.out.println(text);
            }

            int index;

            long time = System.currentTimeMillis();
            index = busca.buscaBinaria(array, "juro");
            time = System.currentTimeMillis() - time;
            System.out.println(time + "ms. Elemento: " + index);
            System.out.println(array[index]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }

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



}
