package leetcode;

// test commit1
public class Q306_AdditiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "123";
		
		Q306_AdditiveNumber obj = new Q306_AdditiveNumber();
		
		boolean res = obj.isAdditiveNumber(num);
		System.out.println(res);
	}

	public boolean isAdditiveNumber(String num) {
		if (num.length() < 3)
			return false;
        for (int i = 1; i <= num.length() / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            String num1 = num.substring(0, i);
            for (int j = 1; i + j < num.length(); j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }
                String num2 = num.substring(i, i+j);
                if (isValid(num1, num2, i + j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String num1, String num2, int startIdx, String num) {
	    if (startIdx == num.length()) {
	        return true;
        }
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
        String sum = String.valueOf(n2 + n1);
        return num.startsWith(sum, startIdx) && isValid(num2, sum, startIdx + sum.length(), num);
    }
	
	public String add(String num1, String num2) {
		int carry = 0;
		
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		
		StringBuilder sb = new StringBuilder();
		while (i >= 0 && j >=0) {
			char c1 = num1.charAt(i);
			char c2 = num2.charAt(j);
			
			int val = (c1-'0') + (c2 - '0') + carry;
			if (val > 9) {
				carry = 1;
				val -= 10;
			}
			else 
				carry = 0;
			
			sb.append(val);
			i--;
			j--;
		}
		while (i >= 0) {
			char c = num1.charAt(i);
			int val = c - '0' + carry;
			if (val > 9)  {
				carry = 1;
				val -= 10;
			}
			else
				carry = 0;
			sb.append(val);
			i--;
		}
		while (j >= 0) {
			char c = num2.charAt(j);
			int val = c - '0' + carry;
			if (val > 9) {
				carry = 1;
				val -= 10;
			}
			else
				carry = 0;
			sb.append(val);
			j--;
		}
		
		if (carry == 1)
			sb.append(1);
		
		return sb.reverse().toString();
	}
}
