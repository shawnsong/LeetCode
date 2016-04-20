package leetcode;

/*
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */
public class Q134_GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0;
		
		int startIdx = -1;
		int sum = 0;
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			
			if (sum < 0) {
				total += sum;
				sum = 0;
				startIdx = i + 1;
			}
		}
		
		if (startIdx == -1)
			return 0;
		else
			total += sum;
		return total < 0 ? -1 : startIdx;
	}
}
