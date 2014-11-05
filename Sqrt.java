/**
 * Implement int sqrt(int x).
 * 
 * 
 * @author Ke Wang
 *
 */

public class Sqrt {
	public int sqrt(int x) {
		int min = 0;
		int max = 46341;
		int middle = (min+max)/2;
		while (!(middle*middle<=x && (middle+1)*(middle+1)>x)){
			if (middle*middle>x) {
				max = middle;
			}
			else {
				min = middle;
			}
			middle = (min+max)/2;
			if (middle == 46340) {
				break;
			}
		}
		return middle;
	}
}
