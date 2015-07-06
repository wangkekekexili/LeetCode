
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
		while (n > 1) {
			if (n % 2 != 0) {
				return false;
			}
			n >>= 1;
		}
		return true;
	}
	public static void main(String[] args) {
		PowerOfTwo object = new PowerOfTwo();
		System.out.println(object.isPowerOfTwo(1024));
		System.out.println(object.isPowerOfTwo(1023));
	}
}
