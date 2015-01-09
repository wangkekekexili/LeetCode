import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/triangle/
 * 
 * @author Ke Wang
 *
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle==null) {
    		return 0;
    	}
    	
    	for (int i = triangle.size()-2;i >= 0;i--) {
    		List<Integer> currentRow = triangle.get(i);
    		List<Integer> nextRow = triangle.get(i+1);
    		
    		for (int j = 0;j <= i;j++) {
    			if (nextRow.get(j)<nextRow.get(j+1)) {
    				currentRow.set(j,currentRow.get(j)+nextRow.get(j));
    			} else {
    				currentRow.set(j,currentRow.get(j)+nextRow.get(j+1));
    			}
    		}
    	}
    	
    	return triangle.get(0).get(0);
    	
    }
	public static void main(String[] args) {
		List<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(10);
		List<Integer> secondRow = new ArrayList<Integer>();
		secondRow.add(1);
		secondRow.add(5);
		List<List<Integer>> toTest = new ArrayList<List<Integer>>();
		toTest.add(firstRow);
		toTest.add(secondRow);
		
		Triangle t = new Triangle();
		System.out.println(t.minimumTotal(toTest));
		
	}

}
