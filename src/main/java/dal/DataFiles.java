package dal;

import java.io.*;
import java.util.ArrayList;

public class DataFiles {

    private File file = null;

    public DataFiles(String path) throws IllegalArgumentException {
        if (path.isBlank() || path.isEmpty()) throw new IllegalArgumentException();
        file = new File(path);
    }

    public String[] lerAquivoDic() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int i = 0;
            String[] words = new String[Integer.parseInt(br.readLine())];
            String word;
            while ((word = br.readLine()) != null) {
                words[i] = word.split("/")[0];
                i++;
            }

            return words;
        }
    }

    public ArrayList<String> lerAquivo() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            ArrayList<String> words = new ArrayList<>();
            String word;
            while ((word = br.readLine()) != null) {
                words.add(word);
            }
            return words;
        }
    }

    public void salvarArquivo(String[] array) throws Exception{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String word : array) {
                bw.write(word + "\n");
            }
        }
    }
}

