package testing;

public class ParallelSumT {
	//create many threads
	private ParallelComputingT[] sums;
	private int numOfThreads;
	
	public ParallelSumT(int numOfThreads) {
		this.numOfThreads = numOfThreads;
		//set the number of threads according to the number
		//Of processors called from int numOfProcessors = Runtime.getRuntime().availableProcessors();
		this.sums = new ParallelComputingT[numOfThreads];
	}
	
	public int sum(int[] nums) {
		//Split the array in to equal separate tasks according to the number of threads
		int steps = (int) Math.ceil(nums.length * 1.0/ numOfThreads);
		
		for(int i=0;i<numOfThreads;i++) {
			sums[i] = new ParallelComputingT(nums,i*steps,(i+1)*steps);
			sums[i].start();
		}
		try {
			//try to join the threads when each thread has finished its job
			for (ParallelComputingT compute: sums) {
				compute.join();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		int total = 0;
		
		for(ParallelComputingT compute : sums) {
			total += compute.getPartialSum();
		}
		
		return total;
	}
}
