package modelos;

public class BuscaSequencial {

    public static int buscaSequencial(String[] vetor, String x) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equalsIgnoreCase(x))
                return i;
        }
        return -1;
    }

    //public static int buscaBinaria(String[] array, String word, int incio, int fim) {
    //    int meio;
    //    if (incio > fim) {
    //
    //    }
    //}
}
