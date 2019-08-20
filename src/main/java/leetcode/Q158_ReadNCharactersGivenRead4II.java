package leetcode;

public class Q158_ReadNCharactersGivenRead4II implements Read4 {
    char[] buff = new char[4];
    int pos = 0;
    int size = 0;

    public int read(char[] buf, int n) {
        int count = 0;
        while (count < n) {
            if (pos == size) {
                pos = 0;
                size = read4(buff);
                if (size == 0) {
                    break;
                }
            }
            while (count < n && pos < size) {
                buf[count] = buff[pos];
                count++;
                pos++;
            }
        }
        return count;
    }

    @Override
    public int read4(char[] buff) {
        return 0;
    }
}

interface Read4 {
    int read4(char[] buff);
}