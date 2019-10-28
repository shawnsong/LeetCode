package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q212_WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        buildTrie(words, root);

        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuilder sb = new StringBuilder();
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, sb, res, visited);
            }
        }
        return res;
    }

    void dfs(char[][] board, int row, int col, TrieNode node, StringBuilder sb, List<String> res, boolean[][] visited) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || visited[row][col]) {
            return;
        }

        char c = board[row][col];
        if (node.children[c - 'a'] == null) {
            return;
        }
        sb.append(c);
        node = node.children[c - 'a'];
        visited[row][col] = true;
        if (node.isWord) {
            node.isWord = false;
            res.add(sb.toString());
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        for (int[] dir : dirs) {
            dfs(board, row + dir[0], col + dir[1], node, sb, res, visited);
        }
        visited[row][col] = false;
        sb.setLength(sb.length() - 1);
    }

    private void buildTrie(String[] words, TrieNode root) {
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isWord = true;
        }
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
}
