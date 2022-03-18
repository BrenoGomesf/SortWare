package models;

public class Search {
    private final String[] array;

    public Search(String[] array) {
        this.array = array;
    }

    public int binary(String word) throws Exception {
        return binary(array, word, 0, (array.length - 1));
    }

    private int binary(String[] array, String word, int start, int end) throws  Exception {
        if (start > end) throw new Exception("Element not found!");

        int middle = (start + end) / 2;
        if (word.length() == array[middle].length()) {
            if (word.equals(array[middle])) {
                return middle;
            } else {
                int i = middle;
                while (word.length() == array[i].length()) {
                    i++;
                    if (word.equals(array[i])) return i;
                }
                i = middle;
                while (word.length() == array[i].length()) {
                    i--;
                    if (word.equals(array[i])) return i;
                }
            }
        } else if (word.length() < array[middle].length()) {
            return binary(array, word, start, (middle - 1));
        } else {
            return binary(array, word, (middle + 1), end);
        }

        throw new Exception("Element not found!");
    }

    public int sequential(String word) throws Exception {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(word))
                return i;
        }
        throw new Exception("Element not found!");
    }

}
