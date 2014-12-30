/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 *
 * @author Ke Wang
 */

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s==null||s.equals(""))
            return 0;
        String[] parts = s.split(" +");
        if (parts.length==0)
            return 0;
        return parts[parts.length-1].length();
    }
}