import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle-ii/
 * 
 * @author Ke Wang
 *
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> last = new ArrayList<Integer>();
    	List<Integer> current;
    	
    	if (rowIndex<0) {
    		return last;
    	}
    	
    	last.add(1);
    	if (rowIndex==0) {
    		return last;
    	}

		last.add(1);
    	if (rowIndex==1) {
    		return last;
    	}
    	
    	for (int i = 2;i <= rowIndex;i++) {
    		current = new ArrayList<Integer>();
    		current.add(1);
    		for (int j = 0;j <= i-2;j++) {
    			current.add(last.get(j)+last.get(j+1));
    		}
    		current.add(1);
    		last = current;
    	}
    	
    	return last;
    	
    }
	public static void main(String[] args) {
		PascalsTriangleII p = new PascalsTriangleII();
		List<Integer> l = p.getRow(5);
		for (int i = 0;i != l.size();i++) {
			System.out.print(l.get(i)+" ");
		}
		
	}

}
