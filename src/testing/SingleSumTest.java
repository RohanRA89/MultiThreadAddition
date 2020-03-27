package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingleSumTest {
	int testNums[] = {3,4,5,2,10,9,10,2};
	int testSum = 45;
	SingleSumT singleSumTest = new SingleSumT();
	@Test
	void test() {
		assertEquals(singleSumTest.sum(testNums),testSum);
	}

}
