import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle/
 * 
 * @author Ke Wang
 *
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (numRows <= 0) {
    		return result;
    	}
    	
    	List<Integer> row;
    	// add the first row
    	row = new ArrayList<Integer>();
    	row.add(1);
    	result.add(row);
    	
    	// add the second row, if needed
    	if (numRows >= 2) {
    		row = new ArrayList<Integer>();
    		row.add(1);
    		row.add(1);
    		result.add(row);
    	}
    	
    	// add the remaining rows
    	for (int i = 3;i <= numRows;i++) {
    		row = new ArrayList<Integer>();
    		row.add(1);
    		for (int j = 0;j <= i-3;j++) {
    			row.add(result.get(result.size()-1).get(j)+result.get(result.size()-1).get(j+1));
    		}
    		row.add(1);
    		result.add(row);
    	}
    	
    	return result;
    	
    }
    
	public static void main(String[] args) {
		PascalsTriangle p = new PascalsTriangle();
		List<List<Integer>> result = p.generate(5);
		for (int i = 0;i != result.size();i++) {
			for (int j = 0;j != result.get(i).size();j++) {
				System.out.print(result.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
