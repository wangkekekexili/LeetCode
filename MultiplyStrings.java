public class MultiplyStrings {
	
	class MyBigInteger {
		int[] digits;
		MyBigInteger(String number) {
			digits = new int[number.length()];
			for (int index = number.length() - 1; index >= 0; index--) {
				digits[number.length() - 1 - index] = number.charAt(index) - '0';
			}
		}
		MyBigInteger(int[] digits) {
			this.digits = digits;
		}
		MyBigInteger multiply(MyBigInteger another) {
			int[] newBigIntegerDigits = new int[digits.length + another.digits.length];
			for (int index1 = 0; index1 != digits.length; index1++) {
				int remaining = 0;
				for (int index2 = 0; index2 != another.digits.length; index2++) {
					int current = digits[index1] * another.digits[index2] + remaining + newBigIntegerDigits[index1+index2];
					newBigIntegerDigits[index1+index2] = current % 10;
					remaining = current / 10;
				}
				if (remaining > 0 && remaining < 10) {
					newBigIntegerDigits[index1+another.digits.length] += remaining;
				} else if (remaining >= 10) {
					newBigIntegerDigits[index1+another.digits.length] += remaining%10;
					newBigIntegerDigits[index1+another.digits.length+1] += remaining/10;
				}
			}
			return new MyBigInteger(newBigIntegerDigits);
		}
		
		@Override
		public String toString() {
			boolean hasStart = false;
			StringBuffer result = new StringBuffer();
			for (int index = digits.length-1; index >= 0; index--) {
				if (digits[index] != 0 || (digits[index] == 0 && hasStart == true)) {
					result.append(digits[index]);
					hasStart = true;
				}
			}
			if (result.length() == 0) {
				return "0";
			} else {
				return result.toString();
			}
		}
	}
	
    public String multiply(String num1, String num2) {
    	MyBigInteger value1 = new MyBigInteger(num1);
    	MyBigInteger value2 = new MyBigInteger(num2);
    	return value1.multiply(value2).toString();
    }
    
}
