/**
 * https://leetcode.com/problems/reverse-bits/
 * 
 * @author Ke Wang
 *
 */
public class ReverseBits {

    public int reverseBits(int n) {
        long l = Integer.toUnsignedLong(n);
        long newLong = 0;
        int count = 0;
        while (l > 0) {
        	count++;
        	newLong = newLong*2 + l%2;
        	l /= 2;
        }
        while (count != 32) {
        	count++;
        	newLong *= 2;
        }
        return (int)newLong;
    }	
	
	public static void main(String[] args) {
		ReverseBits r = new ReverseBits();
		System.out.println(r.reverseBits(43261596));
	}

}
