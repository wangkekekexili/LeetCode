/**
 * Given a string, 
 * determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 * @author Ke Wang
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s==null) {
			return false;
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch>='a'&&ch<='z' || ch>='A'&&ch<='Z' || ch>='0'&&ch<='9') {
				if (ch>='A'&&ch<='Z') {
					ch = Character.toLowerCase(ch);
				}
				sb.append(ch);
			}
		}
		s = sb.toString();
		int first = 0;
		int last = s.length()-1;
		while (first < last) {
			if (s.charAt(first) != s.charAt(last)) {
				return false;
			}
			first++;
			last--;
		}
		return true;
	}
}
