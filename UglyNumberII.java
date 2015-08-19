import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 * 
 * @author kewang
 *
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
    	if (n <= 0) {
    		return 0;
    	}
    	if (n == 1) {
    		return 1;
    	}
    	n--;
    	Queue<Integer> two = new LinkedList<>();
    	Queue<Integer> three = new LinkedList<>();
    	Queue<Integer> five = new LinkedList<>();
    	two.add(2);
    	three.add(3);
    	five.add(5);
    	while (true) {
    		// get the next ugly number
    		int ugly = two.element();
    		if (three.element() < ugly) {
    			ugly = three.element();
    		}
    		if (five.element() < ugly) {
    			ugly = five.element();
    		}
    		if (two.element() == ugly) {
    			two.poll();
    		}
    		if (three.element() == ugly) {
    			three.poll();
    		}
    		if (five.element() == ugly) {
    			five.poll();
    		}
    		
    		// check if this is the number we want
    		n--;
    		if (n == 0) {
    			return ugly;
    		}
    		two.add(ugly * 2);
    		three.add(ugly * 3);
    		five.add(ugly * 5);
    	}
    }
}
