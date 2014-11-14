/**
 * Reverse digits of an integer
 * 
 * @author Ke Wang
 *
 */

public class ReverseInteger {
	public int reverseInteger(int x) {
		if (x==0) {
			return 0;
		}
		
		int sign = 0; // sign of x
		
		if (x > 0) {
			sign = 1;
		} else {
			sign = -1;
			x = -x;
		}
		
		int digits[] = new int[10];
		int numberOfDigits = 0;
		while (x > 0) {
			digits[numberOfDigits] = x % 10;
			x = x / 10;
			numberOfDigits++;
		}
		
		x = 0;
		for (int i = 0;i != numberOfDigits;i++) {
			x = 10*x + digits[i];
		}
		
		// if overflow, return 0
		if (x < 0) {
			return 0;
		} else {
			return sign * x;
		}
		
	}
}
