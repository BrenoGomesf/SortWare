package main;

import dal.DataFiles;
import fabrica.FabricaSort;
import modelos.ISort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            DataFiles dictionary = new DataFiles("./src/main/resources/Portugues(pt_BR).txt");
            String[] array = dictionary.lerAquivo();
            ISort sortMethod = FabricaSort.getSort(getOpcaoMenuSort(), array);

            long tempo = System.currentTimeMillis();
            printProgressBar();
            sortMethod.sort();
            System.out.println("Tempo: " + (System.currentTimeMillis() - tempo) + " ms.");


            DataFiles saida = new DataFiles("/home/hypper/Downloads/saida.txt");
            saida.salvarArquivo(array);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    private static String getOpcaoMenuSort() {
        Scanner input = new Scanner(System.in);

        System.out.println("Algoritmos:");
        String op = "[1] - MergeSort\n"
                + "[2] - QuickSort\n"
                + "[3] - InsertionSort\n"
                + "[4] - BubbleSort\n"
                + "[5] - Todos\n";
        System.out.println(op);
        System.out.print("Informe o algoritmo na qual deseja testar:");
        int menu = input.nextInt();
        input.close();

        switch (menu) {
            case 1 -> {
                return "mergesort";
            }
            case 2 -> {
                return "quicksort";
            }
            case 3 -> {
                return "insertionsort";
            }
            case 4 -> {
                return "bubblesort";
            }
            default -> {
                return null;
            }
        }

    }

    private static void printProgressBar() {
        while (true) {
            System.out.print("|");
            System.out.print("/");
            System.out.print("\\");
        }
    }
}
