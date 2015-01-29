

public class NextPermutation {
    
	public static void reverse(int[] n, int first, int last) {
		while (first < last) {
			int temp = n[first];
			n[first] = n[last];
			n[last] = temp;
			first++;
			last--;
		}
	}
	
	public void nextPermutation(int[] num) {
    	if (num == null || num.length == 1) {
    		return;
    	}
    	
    	int last = num.length-1;
    	while (last > 0) {
    		if (num[last] > num[last-1]) {
    			break;
    		} else {
    			last--;
    		}
    	}
    	
    	if (last == 0) {
    		NextPermutation.reverse(num, 0, num.length-1);
    	} else {
    		last--;
    		int toChange = num.length-1;
    		while (num[toChange] <= num[last]) {
    			toChange--;
    		}
    		// change toChange and last
    		int temp = num[toChange];
    		num[toChange] = num[last];
    		num[last] = temp;
    		// reverse last+1 to the end
    		NextPermutation.reverse(num, last+1, num.length-1);
    	}
    	
    }
    
    public static void main(String[] args) {
    	int[] test = {1,3,2};
    	NextPermutation n = new NextPermutation();
    	n.nextPermutation(test);
    	for (int i : test) {
    		System.out.print(i+" ");
    	}
    	
    	int[] test1 = {2,3,1};
    	n.nextPermutation(test1);
    	for (int i : test1) {
    		System.out.print(i+" ");
    	}
    }
}
