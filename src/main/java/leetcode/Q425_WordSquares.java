package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q425_WordSquares {
    TrieNode root;

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new LinkedList<>();

        if (words == null || words.length == 0) {
            return res;
        }

        root = new TrieNode();
        buildTrie(words);

        int len = words[0].length();
        for (String word : words) {
            ArrayList<String> solution = new ArrayList();
            solution.add(word);
            search(solution, 1, len, res);
        }
        return res;
    }

    void search(List<String> solution, int idx, int size, List<List<String>> res) {
        if (idx == size) {
            res.add(new LinkedList(solution));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String str : solution) {
            sb.append(str.charAt(idx));
        }
        List<String> startsWith = searchPrefix(sb.toString());

        for (String next : startsWith) {
            solution.add(next);
            search(solution, idx + 1, size, res);
            solution.remove(solution.size() - 1);
        }
    }

    void buildTrie(String[] words) {
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                node.startsWith.add(w);
            }
        }
    }

    List<String> searchPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return new LinkedList();
            }
            node = node.children[idx];
        }
        return node.startsWith;
    }

    class TrieNode {
        List<String> startsWith;
        TrieNode[] children;
        TrieNode() {
            startsWith = new LinkedList<>();
            children = new TrieNode[26];
        }
    }
}
