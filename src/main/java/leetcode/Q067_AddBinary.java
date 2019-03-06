package leetcode;

/*
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100". 
 */
public class Q067_AddBinary {
	public String addBinary(String a, String b) {
	    if (a == null || b == null) {
	        return a == null ? b : a;
        }

        int i = a.length() - 1, j = b.length() - 1;
	    StringBuilder sb = new StringBuilder();
	    int carrier = 0;

	    while (i >= 0 || j >= 0) {
	        int sum  = 0;
	        if (i >= 0) {
	            sum += a.charAt(i) - '0';
	            i--;
            }

            if (j >=0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            sum += carrier;
            if (sum > 1) {
                sum -= 2;
                carrier = 1;
            } else {
                carrier = 0;
            }
            sb.append(sum);
        }
        if (carrier == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
