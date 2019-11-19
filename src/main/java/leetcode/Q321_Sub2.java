package leetcode;

/**
 Given two array of length m and n, create maximum number of length k = m + n.

 OK, this version is a lot closer to our original problem with the exception that we will use all the digits we have.

 Still, for this version, Greedy is the first thing come to mind. We have k decisions to make, each time will just need to decide ans[i]
 is from which of the two. It seems obvious, we should always choose the larger one right? This is correct,
 but the problem is what should we do if they are equal?

 This is not so obvious. The correct answer is we need to see what behind the two to decide. For example,

 nums1 = [6, 7]
 nums2 = [6, 0, 4]
 k = 5
 ans = [6, 7, 6, 0, 4]
 */
public class Q321_Sub2 {

    public String maxArray(int[] num1, int[] num2) {
        int k = num1.length + num2.length;
        int[] arr = new int[k];
        int i = 0, j = 0, pos = 0;
        while (pos < k) {
            if (greater(num1, i, num2, j)) {
                arr[pos] = num1[i];
                i++;
            } else {
                arr[pos] = num2[j];
                j++;
            }
            pos++;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }

    boolean greater(int[] num1, int i, int[] num2, int j) {
        while (i < num1.length && j < num2.length && num1[i] == num2[j]) {
            i++;
            j++;
        } return j == num2.length || (i < num1.length && num1[i] > num2[j]);
    }
}
