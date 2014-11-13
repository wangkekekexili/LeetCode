/**
 * Given an input string, reverse the string word by word.
 * 
 * 
 * @author Ke Wang
 *
 */

public class ReverseWordsInAString {
	public String reverseWords(String s) {
		if (s==null) {
			return null;
		}
		
		String[] words = s.split(" +");
		StringBuffer sb = new StringBuffer();
		for (int i = words.length-1;i >=0 ;i--) {
			if (!words[i].equals("")) {
				sb.append(words[i]);
				sb.append(' ');
			}
		}
		
		if (sb.length()==0) {
			return "";
		} else {
			return sb.substring(0, sb.length()-1);
		}
	}
}
