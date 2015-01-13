/**
 * https://oj.leetcode.com/problems/compare-version-numbers/
 * 
 * @author Ke Wang
 *
 */

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if (version1==null || version2==null) {
			return 0;
		}
		
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		if (v1.length < v2.length) {
			String[] temp = new String[v2.length];
			int i = 0;
			while (i < v1.length) {
				temp[i] = v1[i];
				i++;
			}
			while (i < v2.length) {
				temp[i] = "0";
				i++;
			}
			v1 = temp;
		} else if (v1.length > v2.length) {
			String[] temp = new String[v1.length];
			int i = 0;
			while (i < v2.length) {
				temp[i] = v2[i];
				i++;
			}
			while (i < v1.length) {
				temp[i] = "0";
				i++;
			}
			v2 = temp;
		}
		
		int index = 0;
		
		while (index < v1.length) {
			int temp1 = Integer.parseInt(v1[index]);
			int temp2 = Integer.parseInt(v2[index]);
			if (temp1 > temp2) {
				return 1;
			} 
			if (temp1 < temp2) {
				return -1;
			}
			index++;
		}
		
		return 0;
		
	}
	
	public static void main(String[] args) {
		CompareVersionNumbers c = new CompareVersionNumbers();
		System.out.println(c.compareVersion("1.1.1.0.0", "1.1.1"));
	}
}