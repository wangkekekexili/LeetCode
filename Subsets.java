
/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * @author Ke Wang
 * @version 9/18/2014
 */

import java.util.List;
import java.util.ArrayList;

public class Subsets
{
    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    private void quicksort(int[] array, int first, int last) {
        if (first < last-1) {
            int p = partition(array, first, last);
            quicksort(array, first, p-1);
            quicksort(array, p+1, last);
        }
        else if (first == last-1) {
            if (array[first]>array[last]) {
                swap(array, first, last);
            }
        }
    }
    private int partition(int[] array, int first, int last) {
        int privotPosition = last;
        int privotValue = array[last];
        int position = first;
        for (int i = first;i != last;i++) {
            if (array[i]<privotValue) {
                swap(array,i,position);
                position++;
            }
        }
        swap(array,position,privotPosition);
        return position;
    }
    public List<List<Integer>> subsets(int[] S) {
        if (S==null)
            return null;
        
        // to contain the return result
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        if (S.length==0)
            return (List<List<Integer>>)results;
            
        // sort the S array
        quicksort(S,0,S.length-1);
        
        int index = 0;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        results.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(new Integer(S[index]));
        results.add(temp);
        for (index = 1; index != S.length;index++) {
            int currentSize = results.size();
            for (int j = 0;j != currentSize;j++) {
                List<Integer> array = results.get(j);
                temp = new ArrayList<Integer>();
                for (Integer integer : array) {
                    temp.add(integer);
                }
                temp.add(new Integer(S[index]));
                results.add(temp);
            }
        }
        return results;
    }
}
