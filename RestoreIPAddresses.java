/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * @author Ke Wang
 */

import java.util.List;
import java.util.ArrayList;

public class RestoreIPAddresses {
    private boolean isIpPartLegal(int n) {
        if (n >= 0 && n <= 255)
            return true;
        return false;
    }
    private boolean isSubLegal(String s) {
        if (s.length()==1)
            return true;
        if (s.charAt(0)=='0')
            return false;
        return true;
    }
    public List<String> restoreIpAddresses(String s) {
        if (s==null)
            return null;
        ArrayList<String> list = new ArrayList<String>();
        int length = s.length();
        if (length<4 || length>12)
            return list;
        for (int i = 1;i <= length-3;i++) {
            if (i<=4)
                for (int j = i+1;j <= length-2;j++) {
                    if (j-i < 4)
                        for (int k = j+1;k <= length-1;k++) {
                            if (k-j < 4 && length-k < 4) {
                                String sub1 = s.substring(0,i);
                                String sub2 = s.substring(i,j);
                                String sub3 = s.substring(j,k);
                                String sub4 = s.substring(k,length);
                                int part1 = Integer.parseInt(sub1);
                                int part2 = Integer.parseInt(sub2);
                                int part3 = Integer.parseInt(sub3);
                                int part4 = Integer.parseInt(sub4);
                                if (isSubLegal(sub1)&&isSubLegal(sub2)&&
                                isSubLegal(sub3)&&isSubLegal(sub4)&&
                                isIpPartLegal(part1)&&isIpPartLegal(part2)&&
                                isIpPartLegal(part3)&&isIpPartLegal(part4)) {
                                    list.add(""+part1+"."+part2+"."+part3+"."+part4);
                                }
                            }
                        }
                }
        }
        return list;
    }
}