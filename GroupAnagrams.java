import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, Integer> n = new HashMap<>();
    	Map<String, TreeSet<String>> map = new HashMap<>();
    	for (String str : strs) {
    		Integer oldCount = n.get(str);
    		if (oldCount == null) {
    			oldCount = 0;
    		}
    		n.put(str, oldCount+1);
    		int[] count = new int[26];
    		for (char ch : str.toCharArray()) {
    			count[ch - 'a']++;
    		}
    		StringBuilder token = new StringBuilder();
    		for (int index = 0; index != 26; index++) {
    			if (count[index] != 0) {
    				token.append((char)(index+'a'));
    				token.append(count[index]);
    			}
    		}
    		TreeSet<String> temp = map.get(token.toString());
    		if (temp == null) {
    			temp = new TreeSet<>();
    			map.put(token.toString(), temp);
    		}
    		temp.add(str);
    	}
    	
    	List<List<String>> result = new ArrayList<>();
    	for (Entry<String, TreeSet<String>> entry : map.entrySet()) {
    		List<String> list = new ArrayList<>();
    		for (String s : entry.getValue()) {
    			list.add(s);
    			for (int i = 1; i < n.get(s); i++) {
    				list.add(s);
    			}
    		}
    		result.add(list);
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	GroupAnagrams instance = new GroupAnagrams();
    	String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    	System.out.println(instance.groupAnagrams(strs));
    	String[] strs2 = {"", ""};
    	System.out.println(instance.groupAnagrams(strs2));
    }
}
