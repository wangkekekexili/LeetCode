import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UglyNumberIITest {

	@Test
	public void test() {
		UglyNumberII object = new UglyNumberII();
		assertEquals(1, object.nthUglyNumber(1));
		assertEquals(2, object.nthUglyNumber(2));
		assertEquals(3, object.nthUglyNumber(3));
		assertEquals(12, object.nthUglyNumber(10));
	}

}
