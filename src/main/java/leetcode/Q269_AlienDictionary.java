package leetcode;

import java.util.*;

public class Q269_AlienDictionary {

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        if (words.length == 1) {
            return words[0];
        }

        Map<Character, Set<Character>> graph = new HashMap<>();

        buildGraph(words, graph);

        int count = 0;
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 0) {
                count++;
                queue.offer(entry.getKey());
                sb.append(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
                if (entry.getValue().contains(c)) {
                    entry.getValue().remove(c);
                    if (entry.getValue().size() == 0) {
                        queue.offer(entry.getKey());
                        sb.append(entry.getKey());
                        count++;
                    }
                }
            }
        }
        if (count != graph.size()) {
            return "";
        }
        return sb.toString();
    }

    private void buildGraph(String[] words, Map<Character, Set<Character>> graph) {
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            addWords(word1, word2, graph);
        }
    }

    private void addWords(String word1, String word2, Map<Character, Set<Character>> graph) {
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            char c1 = word1.charAt(i), c2 = word2.charAt(j);

            if (!graph.containsKey(c1)) {
                graph.put(c1, new HashSet<>());
            }
            if (!graph.containsKey(c2)) {
                graph.put(c2, new HashSet<>());
            }

            if (c1 == c2) {
                i++;
                j++;
            } else  {
                // word2 > word1
                graph.get(c2).add(c1);
                break;
            }
        }
        while (i < word1.length()) {
            Set<Character> set = graph.getOrDefault(word1.charAt(i), new HashSet<>());
            graph.put(word1.charAt(i), set);
            i++;
        }
        while (j < word2.length()) {
            Set<Character> set = graph.getOrDefault(word2.charAt(j), new HashSet<>());
            graph.put(word2.charAt(j), set);
            j++;
        }
    }
}
