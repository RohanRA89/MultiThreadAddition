import java.util.Random;
/*
 * Created by ROHAN AYUB
 * March 26 2020
 * Program adds array of 2 million random numbers first by traditional for loop
 * then by spitting the array in to separate threads to do calculations,
 * then to be joined displaying the final sum. 
 * Most comments are in the testing package classes.
 */
public class App {

	public static void main(String[] args) {
		//create random
		Random r = new Random();
		int nums[] = new int [200000000];
		
		//get the number of processors explained further in testing package -> ParallelSumT
		int numOfProcessors = Runtime.getRuntime().availableProcessors();

		//Checking the number of processors I had available on my machine.
		//System.out.println(numOfProcessors);
		
		for(int i = 0; i<nums.length;i++) {
			nums[i] = r.nextInt(10)+1;
		}
	
		
		long start = System.currentTimeMillis();
		
		SingleSum singleSum = new SingleSum();
		System.out.println("The sum is: " + singleSum.sum(nums));
		System.out.println("Single thread takes: " + (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		ParallelSum parallelSum = new ParallelSum(numOfProcessors);
		System.out.println("Sum is: " + parallelSum.sum(nums));
		System.out.println("Parallel computing takes: " + (System.currentTimeMillis() - start) + "ms");
		
		
	}
	

}
