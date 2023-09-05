import java.util.List;

public class Scramble {

    private static String swapLetters(String word, int i) {
        char temp = word.charAt(i+1);
        return word.substring(0, i) + temp + word.charAt(i) + word.substring(i+2);
    }

    public static String scrambleWord(String word){
        boolean skip = false;
        for (int i = 0; i < word.length()-1; i++){
            if (skip) {
                skip = false;
                continue;
            }
            if (word.charAt(i) == 'A' && word.charAt(i+1) != 'A') {
                word = swapLetters(word, i);
                skip = true;
            }
        }
        return word;
    }

    public static void scrambleOrRemove(List<String> wordList){
        for (int i = wordList.size() - 1; i >= 0; i--) {
            String str = wordList.get(i);
            String scrambled = scrambleWord(str);
            if (!str.equals(scrambled)) {
                wordList.set(i, scrambled);
            } else {
                wordList.remove(i);
            }
        }
    }

}
