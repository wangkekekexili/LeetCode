/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * @author Ke Wang
 * @version 9/20/2014
 */

import java.util.Stack;
import java.util.ListIterator;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path==null)
            return null;
        if (path.equals(""))
            return "";
        Stack<String> s = new Stack<String>();
        String[] parts = path.split("/");
        String result = new String();
        for (int i = 0;i != parts.length;i++) {
            if (parts[i].equals("")) {
                continue;
            }
            else if (parts[i].equals(".")) {
                continue;
            }
            else if (parts[i].equals("..")) {
                if (s.isEmpty()==false) {
                    s.pop();
                }
            }
            else {
                s.push(parts[i]);
            }
        }
        if (s.size()==0)
            return "/";
        else {
            ListIterator iter = s.listIterator();
            while (iter.hasNext()) {
                result += "/"+iter.next();
            }
        }
        return result;
    }
}