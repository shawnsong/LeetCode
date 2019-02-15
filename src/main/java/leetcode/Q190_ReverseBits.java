package leetcode;

/*
 Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 Related problem: Reverse Integer
 */
public class Q190_ReverseBits {

	public int reverseBits(int n) {
		int c = n;
		int b = 0;
		int ret = 0;
		
		for (int i = 0; i < 32; i++) {
			b = c & 1;
			c = c >> 1;
			ret = ret | b;
			if (ret == 31)
				break;
			ret = ret << 1;
		}
		return ret;
	}
}
