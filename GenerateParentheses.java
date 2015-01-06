import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/generate-parentheses/
 * 
 * @author Ke Wang
 *
 */

public class GenerateParentheses {
    
	private class Tuple<T1, T2, T3> {
		private T1 t1;
		private T2 t2;
		private T3 t3;
		public Tuple(T1 t1, T2 t2, T3 t3) {
			this.t1 = t1;
			this.t2 = t2;
			this.t3 = t3;
		}
		public T1 getFirst() {
			return t1;
		}
		public T2 getSecond() {
			return t2;
		}
		public T3 getThird() {
			return t3;
		}
	}
	
	public List<String> generateParenthesis(int n) {
    	List<String> result = new ArrayList<String>();
    	Stack<Tuple<String, Integer, Integer>> stack = new Stack<>();
    	if (n<=0) {
    		return result;
    	}
    	
    	stack.add(new Tuple<String, Integer, Integer>("",n,0));
    	
    	while (stack.empty() == false) {
    		Tuple<String, Integer, Integer> current = stack.pop();
    		if (current.getSecond()==0 && current.getThird()==0) {
    			result.add(current.getFirst());
    		} else {
    			if (current.getSecond() > 0) {
    				stack.add(new Tuple<String, Integer, Integer>(current.getFirst()+"(",
    						current.getSecond()-1, current.getThird()+1));
    			}
    			if (current.getThird() > 0) {
    				stack.add(new Tuple<String, Integer, Integer>(current.getFirst()+")",
    						current.getSecond(), current.getThird()-1));
    			}
    		}
    	}
    	return result;
    }
	
	public static void main(String[] args) {
		GenerateParentheses g = new GenerateParentheses();
		List<String> l = g.generateParenthesis(3);
		for (String s : l) {
			System.out.println(s);
		}
	}
	
}
