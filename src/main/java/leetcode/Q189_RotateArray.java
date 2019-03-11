package leetcode;

/*
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Let the array be - 123456789 and k = 4

 Step 1 - 12345 6789 ---> 54321 6789

 Step 2 - 54321 6789 ---> 54321 9876

 Step 3 - 543219876 ---> 678912345
 */
public class Q189_RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length <= 1)
			return;
		
		if (k % nums.length == 0)
			return;
		
		k = k % nums.length;
		reverse(nums, 0, nums.length -1 - k);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}
	
	private void reverse(int[] nums, int l, int r) {
		while (l < r) {
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
			l++;
			r--;
		}
	}

	void rotate1(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        //find GCD between nums length and step
        int gcd = findGcd(nums.length, step);
        int position, count;

        //gcd path to finish move
        for(int i = 0; i < gcd; i++){
            //beginning position of each path
            position = i;
            //count is the number we need swap each path
            count = nums.length / gcd - 1;
            for(int j = 0; j < count; j++){
                position = (position + step) % nums.length;
                //swap index value in index i and position
                nums[i] ^= nums[position];
                nums[position] ^= nums[i];
                nums[i] ^= nums[position];
            }
        }
    }

    public int findGcd(int a, int b){
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }

}
