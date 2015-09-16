import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

/**
 * https://leetcode.com/problems/largest-number/
 * 
 * @author kewang
 *
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<Integer> numbers = new ArrayList<>(nums.length);
        for (int number : nums) {
        	numbers.add(number);
        }
        Collections.sort(numbers, new Comparator<Integer>() {
			@Override
			public int compare(Integer first, Integer second) {
				String firstFirstString = Integer.toString(first) + 
						Integer.toString(second);
				String secondFirstString = Integer.toString(second) +
						Integer.toString(first);
				Long firstFirstLong = Long.parseLong(firstFirstString);
				Long secondFirstLong = Long.parseLong(secondFirstString);
				if (firstFirstLong > secondFirstLong) {
					return -1;
				} else if (firstFirstLong < secondFirstLong) {
					return 1;
				} else {
					return 0;
				}
			}
		});
        StringJoiner sj = new StringJoiner("");
        for (Integer i : numbers) {
        	sj.add(Integer.toString(i));
        }
        String possibleResult = sj.toString();
        int zeroIndex = 0; // to track leading zeros
        while (zeroIndex < possibleResult.length() &&
        		possibleResult.charAt(zeroIndex) == '0') {
        	zeroIndex++;
        }
        possibleResult = possibleResult.substring(zeroIndex);
        if (possibleResult.equals("")) {
        	return "0";
        } else {
        	return possibleResult;
        }
    }
}
