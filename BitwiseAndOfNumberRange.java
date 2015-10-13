
public class BitwiseAndOfNumberRange {
    public int rangeBitwiseAnd(int m, int n) {
    	if (m == n) {
    		return m;
    	}
    	int diffBits = 0;
    	while (m != n) {
    		m >>= 1;
    		n >>= 1;
    		diffBits++;
    	}
    	if (m == 0) {
    		return 0;
    	} else {
    		return 1 << diffBits;
    	}
    }
}
