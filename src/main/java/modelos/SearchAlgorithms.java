package modelos;

public class SearchAlgorithms {

    public int buscaSequencial(String[] vetor, String x) throws Exception {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equalsIgnoreCase(x))
                return i;
        }
        throw new Exception("Elemento não encontrado!");
    }

    public int buscaBinaria(String[] array, String word) throws Exception {
        return buscaBinaria(array, word, 0, (array.length - 1));
    }

    private int buscaBinaria(String[] array, String word, int inicio, int fim) throws  Exception {
        if (inicio > fim) throw new Exception("Elemento não encontrado!");

        int meio = (fim + inicio) / 2;

        if (word.equals(array[meio]))
            return meio;
        else if (word.length() < array[meio].length())
            return buscaBinaria(array, word, inicio, (meio - 1));
        else
            return buscaBinaria(array,word, meio + 1, fim);
    }
}
