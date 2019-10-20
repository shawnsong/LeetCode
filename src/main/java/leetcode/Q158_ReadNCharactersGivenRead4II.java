package leetcode;

import java.util.Random;

/**
 * Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters.
 * Your method read may be called multiple times.
 */
public class Q158_ReadNCharactersGivenRead4II {

    private char[] buff;
    private int buffCount;
    private int buffPos;

    public int read(char[] buf, int n) {
        int pos = 0;
        while (pos < n) {
            if (buffPos == 0) {
                buffCount = read4(buff);
                if (buffCount == 0) {
                    break;
                }
            }

            while (pos < n && buffPos < buffCount) {
                buf[pos] = buff[buffPos];
                pos++;
                buffPos++;
            }
            if (buffPos == buffCount) {
                buffPos = 0;
            }
        }
        return pos;
    }

    private int read4(char[] buf) {
        return new Random().nextInt(4);
    }
}
