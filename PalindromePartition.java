
/**
 * Given a string s, 
 * partition s such that every substring of the partition is a palindrome.
 * 
 * @author Ke Wang
 *
 */

import java.util.*;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
		if (s==null) {
			return null;
		}
		int sLength = s.length();
		
		// dynamic programming
		// isPalindrome[i][j] <- isPalindrome[i+1][j-1] && s.i==s.j
		boolean isPalindrome[][] = new boolean[sLength][sLength]; // already initialized to false 
		for (int last = 0;last != sLength;last++) {
			for (int first = 0;first <= last;first++) {
				if (first==last) {
					isPalindrome[first][last] = true;
				}
				if (first==last-1 && s.charAt(first)==s.charAt(last)) {
					isPalindrome[first][last] = true;
				}
				if (last-first>1 && isPalindrome[first+1][last-1] && s.charAt(first)==s.charAt(last)) {
					isPalindrome[first][last] = true;
				}
			}
		}
		
		
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> temp;
		for (int i = 0;i <= sLength-1;i++) {
			int tempResultSize = result.size();
			for (int j = 0;j != tempResultSize;j++) {
				List<String> currentResultItem = result.get(j);
				int currentItemLength = 0;
				for (String str : currentResultItem) {
					currentItemLength += str.length();
				}
				if (isPalindrome[currentItemLength][i]) {
					temp = new ArrayList<String>(currentResultItem);
					temp.add(s.substring(currentItemLength,i+1));
					result.add(temp);
				}
			}
			if (isPalindrome[0][i]) {
				temp = new ArrayList<String>();
				temp.add(s.substring(0,i+1));
				result.add(temp);
			}
	
		}
		

		Set<List<String>> toRemove = new HashSet<List<String>>();
		for (List<String> item : result) {
			int itemLength = 0;
			for (String str : item) {
				itemLength += str.length();
			}
			if (itemLength < sLength) {
				toRemove.add(item);
			}
		}
		result.removeAll(toRemove);
		
		return result;
    }
    public static void main(String[] args){
    	System.out.println(new PalindromePartition().partition("baa"));
    }
}
