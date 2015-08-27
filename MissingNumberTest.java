import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MissingNumberTest {

	private MissingNumber instance;
	
	@Before
	public void setup() {
		instance = new MissingNumber();
	}
	
	@Test
	public void test() {
		int[] test = {0,1,3};
		int missing = instance.missingNumber(test);
		assertEquals(2, missing);
	}

}
