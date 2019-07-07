package leetcode;


/**
 * For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications
 * of the following extension operation:
 * choose a group consisting of characters c, and add some number of characters c to the group
 * so that the size of the group is 3 or more.
 *
 * hello -> helllo is valid, as long as the repetitive char is longer than 3
 */
public class Q809_ExpressiveWords {

    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isValid(s, word)) {
                count++;
            }
        }
        return count;
    }

    boolean isValid(String stretch, String word) {
        int sStart = 0;
        int wStart = 0;
        int sEnd = 0;
        int wEnd = 0;
        while (sEnd < stretch.length() && wEnd < word.length()) {
            if (stretch.charAt(sStart) != word.charAt(wStart)) return false;
            while (sEnd < stretch.length() && stretch.charAt(sEnd) == stretch.charAt((sStart))) {
                sEnd++;
            }
            while (wEnd < word.length() && word.charAt(wEnd) == word.charAt(wStart)) {
                wEnd++;
            }

            // if sEnd - sStart != wEnd - wStart => the repeating length is different
            // could be lll => ll, || l => ll
            // that's why sEnd - sStart has to be greater than 3 AND greater wStart - wEnd
            if (sEnd - sStart != wEnd - wStart && sEnd - sStart < Math.max(3, wStart - wEnd)) {
                return false;
            }
            sStart = sEnd;
            wStart = wEnd;
        }
        return sEnd == stretch.length() && wStart == word.length();
    }
}
