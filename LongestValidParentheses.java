import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 
 * @author kewang
 *
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int result = 0;
        int indexBeforeStart = -1;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int index = 0; index != s.length(); index++) {
        	if (s.charAt(index) == '(') {
        		stack.addLast(index);
        	} else {
        		if (stack.isEmpty() == true) {
        			indexBeforeStart = index;
        		} else {
        			stack.removeLast();
        			if (stack.isEmpty() == false) {
        				result = Math.max(result, index - stack.getLast());
        			} else {
        				result = Math.max(result, index - indexBeforeStart);
        			}
        		}
        	}
        }
        return result;
    }
}
