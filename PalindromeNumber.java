/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author Ke Wang
 */

public class PalindromeNumber {
    /**
     * inverse an int variable
     */
    private int inverse(int x) {
        int result = 0;
        while (x>0) {
            result = result*10 + x%10;
            x /= 10;
        }
        return result;
    }
    /**
     * determine if an int variable is palindrome
     * for example, 101 is a paindrome and 100 is not
     * 
     * @return true if the variable is palindrome and false if not
     */
    public boolean isPalindrome(int x) {
        return x>=0 && inverse(x)==x;
    }
}