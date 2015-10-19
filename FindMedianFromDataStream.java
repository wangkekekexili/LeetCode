import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * @author kewang
 *
 */
public class FindMedianFromDataStream {
	
	PriorityQueue<Integer> firstHalf = new PriorityQueue<>((e1,e2) -> {
		if (e1 > e2) {
			return -1;
		} else if (e1 < e2) {
			return 1;
		} else {
			return 0;
		}
	});
	
	PriorityQueue<Integer> secondHalf = new PriorityQueue<>((e1, e2) -> {
		if (e1 < e2) {
			return -1;
		} else if (e1 > e2) {
			return 1;
		} else {
			return 0;
		}
	});
	
	public void addNum(int num) {
		if (firstHalf.size() == 0) {
			firstHalf.add(num);
		} else {
			if (num <= firstHalf.peek()) {
				firstHalf.add(num);
			} else {
				secondHalf.add(num);
			}
			if (firstHalf.size() > secondHalf.size()+1) {
				secondHalf.add(firstHalf.remove());
			} else if (secondHalf.size() > firstHalf.size()+1) {
				firstHalf.add(secondHalf.remove());
			}
		}
    }

    public double findMedian() {
    	if (firstHalf.size() == 0 && secondHalf.size() == 0) {
    		return 0;
    	} else if (firstHalf.size() == secondHalf.size()) {
    		return (0.0+firstHalf.peek()+secondHalf.peek())/2;
    	} else if (firstHalf.size() > secondHalf.size()) {
    		return firstHalf.peek();
    	} else {
    		return secondHalf.peek();
    	}
    }
}
