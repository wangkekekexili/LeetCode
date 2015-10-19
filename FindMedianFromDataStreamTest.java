import static org.junit.Assert.*;

import org.junit.Test;

public class FindMedianFromDataStreamTest {

	@Test
	public void test() {
		FindMedianFromDataStream instance = new FindMedianFromDataStream();
		instance.addNum(1);
		instance.addNum(2);
		assertEquals(1.5, instance.findMedian(), 0.0001);
		instance.addNum(3);
		assertEquals(2, instance.findMedian(), 0.0001);
	}

}
