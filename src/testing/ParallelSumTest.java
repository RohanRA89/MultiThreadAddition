package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParallelSumTest {
	int testNums[] = {3,4,5,2,10,9,10,2};
	int testSum = 45;
	int numOfProcessors = Runtime.getRuntime().availableProcessors();
	ParallelSumT parallelSum = new ParallelSumT(numOfProcessors);
	@Test
	void test() {
		assertEquals(testSum,parallelSum.sum(testNums));
	}

}
