package testing;

public class SingleSumT {
	public int sum(int nums[]) {
		int total = 0;
		/*
		 * Basic implementation of sum of array
		 * total = total + nums[i]
		 * returns total
		 */
		for(int i = 0; i < nums.length;i++) {
			total += nums[i];
		}
		return total;
	}
}
