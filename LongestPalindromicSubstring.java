/**
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
 * 
 * @author Ke Wang
 *
 */

public class LongestPalindromicSubstring {
	private int longest(String s, int index) {
		int count = 1;
		int first = index-1;
		int last = index+1;
		while (first>=0 && last <= s.length()-1) {
			if (s.charAt(first)==s.charAt(last)) {
				count += 2;
				first--;
				last++;
			} else {
				break;
			}
		}
		return count;
	}
	private int longest(String s, int index1, int index2) {
		assert(index2==index1+1);
		int count = 2;
		int first = index1-1;
		int last = index2+1;
		while (first>=0 && last<=s.length()-1) {
			if (s.charAt(first)==s.charAt(last)) {
				count += 2;
				first--;
				last++;
			} else {
				break;
			}
		}
		return count;
	}
	public String longestPalindrome(String s) {
		if (s==null) {
			return null;
		}
		if (s.length()==0) {
			return "";
		}
		
		int max = 1;
		String maxString = s.substring(0,1);
		
		for (int i = 1;i < s.length()-1;i++) {
			int temp = longest(s,i);
			if (temp > max) {
				max = temp;
				maxString = s.substring(i-max/2,i+max/2+1);
			}
		}
		
		for (int i = 0;i < s.length()-1;i++) {
			if (s.charAt(i)!=s.charAt(i+1)) {
				continue;
			}
			int temp = longest(s,i,i+1);
			if (temp > max) {
				max = temp;
				maxString = s.substring(i-(max-1)/2,i+max/2+1);
			}
		}
		
		return maxString;
		
    }
	
	public static void main(String[] args) {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome("banana"));
	}
	
}
