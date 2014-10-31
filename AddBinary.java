/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * 
 * @author Ke Wang
 *
 */

public class AddBinary {
	public String addBinary(String a, String b) {
		if (a==null || b==null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int aLength = a.length();
		int bLength = b.length();
		int indexA = aLength-1;
		int indexB = bLength-1;
		int carry = 0;
		while (indexA>=0 && indexB>=0) {
			int binaryA = Integer.parseInt(a.substring(indexA,indexA+1));
			int binaryB = Integer.parseInt(b.substring(indexB,indexB+1));
			int current = carry+binaryA+binaryB;
			switch (current) {
			case 0:
				sb.insert(0,0);
				carry = 0;
				break;
			case 1:
				sb.insert(0,1);
				carry = 0;
				break;
			case 2:
				sb.insert(0,0);
				carry = 1;
				break;
			case 3:
				sb.insert(0,1);
				carry = 1;
				break;
			default:
				return null;
			}
			indexA--;
			indexB--;
		}
		while (indexA>=0) {
			int binaryA = Integer.parseInt(a.substring(indexA,indexA+1));
			int current = binaryA+carry;
			switch (current) {
			case 0:
				sb.insert(0,0);
				carry = 0;
				break;
			case 1:
				sb.insert(0,1);
				carry = 0;
				break;
			case 2:
				sb.insert(0,0);
				carry = 1;
				break;
			default:
				return null;
			}
			indexA--;
		}
		while (indexB>=0) {
			int binaryB = Integer.parseInt(b.substring(indexB,indexB+1));
			int current = binaryB+carry;
			switch (current) {
			case 0:
				sb.insert(0,0);
				carry = 0;
				break;
			case 1:
				sb.insert(0,1);
				carry = 0;
				break;
			case 2:
				sb.insert(0,0);
				carry = 1;
				break;
			default:
				return null;
			}
			indexB--;			
		}
		if (carry==1) {
			sb.insert(0,1);
		}
		return sb.toString();
	}
}
