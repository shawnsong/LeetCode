package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Master {
    int guess(String word) {
        return 0;
    }
}
public class Q843_GuessTheWord {
    public void findSecretWord(String[] wordList, Master master) {
        for (int i = 0; i < 10; i++) {
            String guess = wordList[new Random().nextInt(wordList.length)];
            int count = master.guess(guess);
            if (count == 6) return;

            List<String> nextGuesses = new ArrayList<>();

            for (String word : wordList) {
                if (match(guess, word, count)) {
                    nextGuesses.add(word);
                }
            }

            String[] newList = new String[nextGuesses.size()];
            for (int j = 0; j < newList.length; j++)
                newList[j] = nextGuesses.get(j);
            wordList = newList;
        }
    }

    private boolean match(String guess, String word, int count) {
        int c = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == word.charAt(i)) {
                c++;
                if (c > count) return false;
            }
        }
        return c == count;
    }
}
