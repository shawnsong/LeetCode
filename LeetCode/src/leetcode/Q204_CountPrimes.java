package leetcode;

/*
 Count the number of prime numbers less than a non-negative number, n.
 */
public class Q204_CountPrimes {
	public int countPrimes(int n) {
		if (n < 2)
			return 0;
		
		boolean[] flag = new boolean[n];
		flag[0] = false;
		flag[1] = true;
		
		int max = (int) Math.sqrt(n);
		for (int i = 2; i * i < n; i++) {
			if (flag[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				flag[j] = true;
			}
		}
		
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (flag[i] == false)
				count++;
		}
		return count;
	}
}
