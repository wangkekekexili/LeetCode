import static org.junit.Assert.*;

import org.junit.Test;

public class HIndexTest {

	@Test
	public void test() {
		int[] citations = {3, 0, 6, 1, 5};
		int hIndex = new HIndex().hIndex(citations);
		assertEquals(3, hIndex);
	}

}
