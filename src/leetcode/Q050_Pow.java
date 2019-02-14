package leetcode;

//Implement pow(x, n). 
public class Q050_Pow {
	public double myPow(double x, int n) {
		double sign = 1.0;
		if (x < 0 && n % 2 != 0)
			sign = -1.0;
		
		double ret = pow(Math.abs(x), Math.abs(n));
		if (n < 0)
			return (double)(1.0 / ret) * sign;
		else
			return ret * sign;
	}
	
	private double pow(double x, int n) {
		if (n == 0)
			return 1;
		else if (n == 1)
			return x;
		
		double ret = myPow(x, n / 2);
		if (n % 2 == 1)
			return ret * ret * x;
		else
			return ret * ret;
	}
	
}
