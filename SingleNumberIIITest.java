import static org.junit.Assert.*;

import org.junit.Test;

public class SingleNumberIIITest {

	@Test
	public void test() {
		SingleNumberIII instance = new SingleNumberIII();
		int[] test = {1,2,1,3,2,5};
		int[] result = instance.singleNumber(test);
		assertEquals(result.length, 2);
		assertTrue(result[0]==3 || result[1]==3);
		assertTrue(result[0]==5 || result[1]==5);
	}

}
