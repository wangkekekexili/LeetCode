import java.util.ArrayList;
import java.util.List;

public class Skyline {
    public List<int[]> getSkyline(int[][] buildings) {
    	List<int[]> result = new ArrayList<>();
    	if (buildings == null || buildings.length == 0) {
    		return result;
    	}
    	result = getSkyline(buildings, 0, buildings.length - 1);
    	result = removeDuplicateHeight(result);
    	return result;
    }
    
    private List<int[]> getSkyline(int[][] buildings, int start, int end) {
    	if (start > end) {
    		return new ArrayList<>();
    	} else if (start == end) {
    		List<int[]> currentResult = new ArrayList<>();
    		currentResult.add(new int[]{buildings[start][0], buildings[start][2]});
    		currentResult.add(new int[]{buildings[start][1], 0});
    		return currentResult;
    	} else {
    		int middle = (start + end) / 2;
    		List<int[]> left = getSkyline(buildings, start, middle);
    		List<int[]> right = getSkyline(buildings, middle + 1, end);
    		return merge(left, right);
    	}
    }
    
    private List<int[]> merge(List<int[]> left, List<int[]> right) {
    	List<int[]> currentResult = new ArrayList<>();
    	int leftIndex = 0;
    	int rightIndex = 0;
    	int leftHeight = 0;
    	int rightHeight = 0;
    	while (leftIndex < left.size() && rightIndex < right.size()) {
    		if (left.get(leftIndex)[0] == right.get(rightIndex)[0]) {
    			if (left.get(leftIndex)[1] < right.get(rightIndex)[1]) {
    				leftHeight = left.get(leftIndex)[1];
    				leftIndex++;
    			} else {
    				rightHeight = right.get(rightIndex)[1];
    				rightIndex++;
    			}
    		} else if (left.get(leftIndex)[0] < right.get(rightIndex)[0]) {
				leftHeight = left.get(leftIndex)[1];
    			int currentHeight = leftHeight>rightHeight?leftHeight:rightHeight;
    			currentResult.add(new int[]{left.get(leftIndex)[0], currentHeight});
    			leftIndex++;
    		} else {
				rightHeight = right.get(rightIndex)[1];
    			int currentHeight = leftHeight>rightHeight?leftHeight:rightHeight;
    			currentResult.add(new int[]{right.get(rightIndex)[0], currentHeight});
    			rightIndex++;
    		}
    	}
    	while (leftIndex < left.size()) {
			leftHeight = left.get(leftIndex)[1];
			currentResult.add(new int[]{leftIndex, leftHeight});
			leftIndex++;
    	}
    	while (rightIndex < right.size()) {
			rightHeight = right.get(rightIndex)[1];
			currentResult.add(new int[]{rightIndex, rightHeight});
			rightIndex++;
    	}
    	return currentResult;
    }
    
    private List<int[]> removeDuplicateHeight(List<int[]> input) {
    	List<int[]> output = new ArrayList<>();
    	int previousHeight = 0;
    	for (int[] item : input) {
    		if (item[1] == previousHeight) {
    			continue;
    		} else {
    			output.add(item);
    			previousHeight = item[1];
    		}
    	}
    	return output;
    }
}
