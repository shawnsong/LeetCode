package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q833_FindAndReplaceStringTest {

    Q833_FindAndReplaceString test = new Q833_FindAndReplaceString();

    @Test
    void findReplaceString() {
        String str = "abcd";
        int[] idx = {0, 2};
        String[] src = {"ab","ec"};
        String[] targets = {"eee", "ffff"};

        assertEquals("eeecd", test.findReplaceString(str, idx, src, targets));
    }

    @Test
    void findReplaceString1() {
        String str = "mhnbzxkwzxtaanmhtoirxheyanoplbvjrovzudznmetkkxrdmr";
        int[] indexes = {46,29,2,44,31,26,42,9,38,23,36,12,16,7,33,18};
        String[] sources = {"rym","kv","nbzxu","vx","js","tp","tc","jta","zqm","ya","uz","avm","tz","wn","yv","ird"};
        String[] targets = {"gfhc","uq","dntkw","wql","s","dmp","jqi","fp","hs","aqz","ix","jag","n","l","y","zww"};

        assertEquals("mhnbzxkwzxtaanmhtoirxheaqznoplbvjrovzudznmetkkxrdmr",
                test.findReplaceString(str, indexes, sources, targets)) ;
    }
}