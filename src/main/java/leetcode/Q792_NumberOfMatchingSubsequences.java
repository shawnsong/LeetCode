package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q792_NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            return 0;
        }

        Queue<WordIterator>[] map = new LinkedList[256];
        for (int i = 0; i < 256; i++) {
            map[i] = new LinkedList();
        }

        for (String word : words) {
            char c = word.charAt(0);
            map[c].add(new WordIterator(word, 0));
        }

        int count = 0;
        for (char c : s.toCharArray()) {
            Queue<WordIterator> queue = map[c];
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                WordIterator it = queue.poll();
                it.idx++;
                if (it.idx == it.word.length()) {
                    count++;
                    continue;
                }
                char nextChar = it.word.charAt(it.idx);
                map[nextChar].add(it);
            }
        }
        return count;
    }

    class WordIterator {
        String word;
        int idx;
        public WordIterator(String w, int i) {
            word = w;
            idx = i;
        }
    }
}
