package leetcode;

public class Q043_MultiplyString {

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] num = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int n1 = i + j;
                int n2 = i + j + 1;
                int sum = mul + num[n2];
                num[n1] += sum / 10;
                num[n2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(num[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
