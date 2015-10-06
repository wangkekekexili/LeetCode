import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
		String[] arr = new String[26];
		String[] item = str.split(Pattern.quote(" "));
		if (pattern.length() != item.length) {
			return false;
		}
		for (int index = 0; index != item.length; index++) {
			if (arr[pattern.charAt(index) - 'a'] == null) {
				arr[pattern.charAt(index) - 'a'] = item[index];
			} else if (arr[pattern.charAt(index) - 'a'].equals(item[index])
					== false) {
				return false;
			}
		}
		
		Set<String> s = new HashSet<>();
		for (int i = 0; i != 26; i++) {
			if (arr[i] == null) {
				continue;
			} else if (s.contains(arr[i])) {
				return false;
			} else {
				s.add(arr[i]);
			}
		}
		
		return true;
    }
}
