import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDnaSequences {
	
	private static Map<Character, Integer> map = new HashMap<>();
	static{
		map.put('A',0);
		map.put('C',1);
		map.put('G',2);
		map.put('T',3);
	}
	private int encode(String s) {
		int result = 0;
		for (char ch : s.toCharArray()) {
			result = result << 2 | map.get(ch);
		}
		return result;
	}
	
    public List<String> findRepeatedDnaSequences(String s) {
    	Set<Integer> allSequence = new HashSet<>();
    	Set<Integer> repeatedSequence = new HashSet<>();
    	List<String> result = new ArrayList<>();
    	if (s.length() <= 10) {
    		return new ArrayList<>();
    	}
    	for (int lastIndex = 10; lastIndex <= s.length(); lastIndex++) {
    		String current = s.substring(lastIndex-10, lastIndex);
    		Integer currentAsInt = encode(current);
    		if (allSequence.contains(currentAsInt) == false) {
    			allSequence.add(currentAsInt);
    		} else if (repeatedSequence.contains(current) == false) {
    			result.add(current);
    			repeatedSequence.add(currentAsInt);
    		}
    	}
    	return result;
    }
}
