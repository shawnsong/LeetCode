package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q950_RevealCardsInIncreasingOrderTest {
    Q950_RevealCardsInIncreasingOrder test = new Q950_RevealCardsInIncreasingOrder();

    @Test
    void deckRevealedIncreasing() {
        int[] deck = {17,13,11,2,3,5,7};
        List<Integer> res = Arrays.asList(2,13,3,11,5,17,7);
        int[] cards = test.deckRevealedIncreasing(deck);
        for (int i = 0; i < deck.length; i++) {
            assertEquals(cards[i], res.get(i));
        }
    }
}