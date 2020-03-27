
public class ParallelSum {
	

	private ParallelComputing[] sums;
	private int numOfThreads;
	
	public ParallelSum(int numOfThreads) {
		this.numOfThreads = numOfThreads;
		this.sums = new ParallelComputing[numOfThreads];
	}
	
	public int sum(int[] nums) {
		int steps = (int) Math.ceil(nums.length * 1.0/ numOfThreads);
		
		for(int i=0;i<numOfThreads;i++) {
			sums[i] = new ParallelComputing(nums,i*steps,(i+1)*steps);
			sums[i].start();
		}
		try {
			
			for (ParallelComputing compute: sums) {
				compute.join();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		int total = 0;
		
		for(ParallelComputing compute : sums) {
			total += compute.getPartialSum();
		}
		
		return total;
	}
}
