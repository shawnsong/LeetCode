package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q068_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        if (words == null || words.length == 0 || maxWidth <= 0) {
            return res;
        }

        List<String> lineWords = new LinkedList<>();
        int lineWidth = 0;
        for (int i = 0; i < words.length; i++) {
            if (lineWidth + words[i].length() + lineWords.size() <= maxWidth) {
                lineWords.add(words[i]);
                lineWidth += words[i].length();
            } else {
                if (i == words.length - 1) {
                    res.add(buildLine(lineWords, maxWidth - lineWidth, maxWidth, true));
                } else {
                    res.add(buildLine(lineWords, maxWidth - lineWidth, maxWidth, false));
                }
                lineWords.clear();
                lineWords.add(words[i]);
                lineWidth = words[i].length();
            }
        }
        if (lineWords.size() > 0) {
            res.add(buildLine(lineWords, maxWidth - lineWidth, maxWidth,true));
        }
        return res;
    }

    private String buildLine(List<String> words, int emptySpaces, int maxWidth, boolean isLastLine) {

        StringBuilder sb = new StringBuilder();

        if (!isLastLine) {
            int spacesBetween = emptySpaces / (words.size() - 1);
            int firstSpaces = spacesBetween + emptySpaces % (words.size() -  1);
            String prefix = "";
            for (String word : words) {
                sb.append(prefix).append(word);
                prefix = buildSpaces(spacesBetween);
                if (word.equals(words.get(0))) {
                    prefix = buildSpaces(firstSpaces);
                }
            }
        } else {
            String prefix = "";
            for (String word : words) {
                sb.append(prefix).append(word);
                prefix = " ";
            }
            if (sb.length() < maxWidth) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String buildSpaces(int count) {
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            sb.append(" ");
            count--;
        }
        return sb.toString();
    }
}
