package testing;

/*
 * Computes the sum of the intervals
 * @param low is low index
 * @param high is high index
 */
public class ParallelComputingT extends Thread{
	private int[] nums;
	private int low;
	private int high;
	private int partialSum;
	
	public ParallelComputingT(int[] nums, int low, int high) {
		this.nums = nums;
		this.low = low;
		this.high = high;
	}
	
	//Sum between the low index and high index
	public int getPartialSum() {
		return this.partialSum;
	}
	
	@Override
	public void run() {
		partialSum = 0;
		for(int i = low; i<high;i++) {
			partialSum += nums[i];
		}
	}
}
