public class Candy {
    public int candy(int[] ratings) {
    	if (ratings == null || ratings.length == 0) {
    		return 0;
    	}
    	if (ratings.length == 1) {
    		return 1;
    	}
    	int[] candy = new int[ratings.length];
    	for (int index = 0; index != candy.length; index++) {
    		candy[index] = 1;
    	}
    	for (int index = 0; index != candy.length; index++) {
    		if (index == 0) {
    			if (ratings[0] > ratings[1]) {
    				candy[0] = candy[1] + 1;
    			}
    		} else if (index == candy.length - 1) {
    			if (ratings[candy.length-1] > ratings[candy.length-2]) {
    				candy[candy.length-1] = candy[candy.length-2] + 1;
    			}
    		} else {
    			int left = 1;
    			int right = 1;
    			if (ratings[index] > ratings[index-1]) {
    				left = candy[index-1] + 1;
    			}
    			if (ratings[index] > ratings[index+1]) {
    				right = candy[index+1] + 1;
    			}
    			candy[index] = (left>right?left:right);
    		}
    	}
    	for (int index = candy.length - 1; index >= 0; index--) {
    		if (index == candy.length - 1) {
    			if (ratings[candy.length-1] > ratings[candy.length-2]) {
    				candy[candy.length-1] = candy[candy.length-2] + 1;
    			}
    		} else if (index == 0) {
    			if (ratings[0] > ratings[1]) {
    				candy[0] = candy[1] + 1;
    			}
    		} else {
    			int left = 1;
    			int right = 1;
    			if (ratings[index] > ratings[index-1]) {
    				left = candy[index-1] + 1;
    			}
    			if (ratings[index] > ratings[index+1]) {
    				right = candy[index+1] + 1;
    			}
    			candy[index] = (left>right?left:right);
    		}
    	}
    	int sum = 0;
    	for (int c : candy) {
    		sum += c;
    	}
    	return sum;
    }
}
