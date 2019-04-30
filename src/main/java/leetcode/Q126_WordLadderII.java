package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Q126_WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Map<String, List<String>> nb = new HashMap();
        Map<String, Integer> distance = new HashMap();
        List<List<String>> res = new LinkedList();
        dict.add(beginWord);

        distance.put(beginWord, 0);
        bfs(beginWord, endWord, nb, distance, dict);

        backtrack(beginWord, endWord, 0, nb, distance, new ArrayList(), res);
        return res;
    }

    private void backtrack(String start, String end, int level, Map<String, List<String>> nb, Map<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(start);
        if (start.equals(end)) {
            res.add(new LinkedList(solution));
        } else {
            for (String next : nb.get(start)) {
                if (distance.get(next) == level + 1) {
                    backtrack(next, end, level + 1, nb, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    private void bfs(String start, String end, Map<String, List<String>> nb, Map<String, Integer> distance, Set<String> dict) {
        dict.stream().forEach(w -> nb.put(w, new LinkedList()));

        Queue<String> queue = new LinkedList();
        queue.add(start);
        System.out.println(start);
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> nexts = transform(cur, dict);

                for (String next : nexts) {
                    nb.get(cur).add(next);
                    if (!distance.containsKey(next)) { // check if visited
                        distance.put(next, dist + 1);
                        if (end.equals(next)) {
                            found = true;
                            break;
                        } else {
                            queue.add(next);
                            System.out.println(next);
                        }
                    }
                }
                if (found) break;
            }
            dist++;
        }
    }

    private List<String> transform(String word, Set<String> dict) {
        char[] arr = word.toCharArray();
        List<String> res = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            char old = arr[i];
            for (char j = 'a'; j <= 'z'; j++ ) {
                arr[i] = j;
                String newWord = new String(arr);
                if (j != old && dict.contains(newWord)) {
                    res.add(newWord);
                }
            }
            arr[i] = old;
        }
        return res;
    }
}
