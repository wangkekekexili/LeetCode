import static org.junit.Assert.*;

import org.junit.Test;

public class CountPrimesTest {

	@Test
	public void test() {
		CountPrimes instance = new CountPrimes();
		assertEquals(25, instance.countPrimes(100));
	}

}
