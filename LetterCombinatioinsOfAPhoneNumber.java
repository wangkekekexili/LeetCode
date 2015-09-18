import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @author kewang
 *
 */
public class LetterCombinatioinsOfAPhoneNumber {
	
	private List<String> result = new ArrayList<>();
	private Map<Integer, char[]> map = new HashMap<>();
	
    public List<String> letterCombinations(String digits) {
    	
    	if (digits == null || digits.length() == 0) {
    		return result;
    	}
    	
    	// put relationships in a map
    	char[] temp2 = {'a','b','c'};
    	map.put(2, temp2);
    	char[] temp3 = {'d','e','f'};
    	map.put(3, temp3);
    	char[] temp4 = {'g','h','i'};
    	map.put(4, temp4);
    	char[] temp5 = {'j','k','l'};
    	map.put(5, temp5);
    	char[] temp6 = {'m','n','o'};
    	map.put(6, temp6);
    	char[] temp7 = {'p','q','r','s'};
    	map.put(7, temp7);
    	char[] temp8 = {'t','u','v'};
    	map.put(8, temp8);
    	char[] temp9 = {'w','x','y','z'};
    	map.put(9, temp9);
    	
    	letterCombinations(digits, 0, "");
    	return result;
    }
    
    private void letterCombinations(String digits, int index, String old) {
    	if (index == digits.length()) {
    		result.add(old);
    		return;
    	}
    	// get the number
    	int number;
    	try {
    		number = Integer.parseInt(digits.substring(index, index+1));
    		char[] choices = map.get(number);
    		if (choices == null) {
    			letterCombinations(digits, index+1, old);
    		}
    		for (char choice : choices) {
    			old = old + choice;
    			letterCombinations(digits, index+1, old);
    			old = old.substring(0, old.length() - 1);
    		}
    	} catch (NumberFormatException e) {
    		letterCombinations(digits, index+1, old);
    	}
    }
}
