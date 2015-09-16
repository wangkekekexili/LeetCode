import static org.junit.Assert.*;

import org.junit.Test;

public class LargestNumberTest {

	@Test
	public void testFunctionality() {
		int[] nums = {3, 30, 34, 5, 9};
		String result = new LargestNumber().largestNumber(nums);
		assertEquals("9534330", result);
	}
	
	@Test
	public void testLeadingZeros() {
		int[] nums = {0, 0};
		String result = new LargestNumber().largestNumber(nums);
		assertEquals("0", result);
	}

}
