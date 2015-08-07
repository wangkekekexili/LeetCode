/**
 * https://leetcode.com/problems/valid-anagram/
 * 
 * @author kewang
 *
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
    	int[] countForS = new int[26];
    	int[] countForT = new int[26];
    	for (char ch : s.toCharArray()) {
    		countForS[ch - 'a']++;
    	}
    	for (char ch : t.toCharArray()) {
    		countForT[ch - 'a']++;
    	}
    	for (int i = 0;i != 26;i++) {
    		if (countForS[i] != countForT[i]) {
    			return false;
    		}
    	}
    	return true;
    }
	
	public static void main(String[] args) {
		ValidAnagram test = new ValidAnagram();
		System.out.println(test.isAnagram("rat", "car"));
		System.out.println(test.isAnagram("anagram", "nagaram"));
	}

}
