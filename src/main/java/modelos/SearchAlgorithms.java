package modelos;

public class SearchAlgorithms {

    public int buscaSequencial(String[] vetor, String word) throws Exception {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equalsIgnoreCase(word))
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

        if (word.length() == array[meio].length())
            for (int i = inicio; i <= fim; i++) {
                if (array[i].equalsIgnoreCase(word))
                    return i;
            }
        else if (word.length() < array[meio].length())
            return buscaBinaria(array, word, inicio, (meio - 1));
        else
            return buscaBinaria(array,word, meio + 1, fim);

        throw new Exception("Elemento não encontrado!");
    }
}
