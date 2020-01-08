package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q950_RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck == null || deck.length < 2) {
            return deck;
        }
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        return res;
    }
}
