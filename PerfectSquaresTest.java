import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PerfectSquaresTest {

	PerfectSquares instance;
	
	@Before
	public void setup() {
		instance = new PerfectSquares();
	}
	
	@Test
	public void test() {
		assertEquals(3, instance.numSquares(12));
		assertEquals(2, instance.numSquares(13));
	}

}
