
/**
 * https://leetcode.com/problems/count-primes/
 * 
 * @author kewang
 *
 */
public class CountPrimes {
	public int countPrimes(int n) {
		if (n <= 1) {
			return 0;
		}
		boolean[] visited = new boolean[n];
		int primeCount = 0;
		for (int number = 2; number < n; number++) {
			if (visited[number] == false) {
				primeCount++;
				for (int multi = number; multi < n; multi += number) {
					visited[multi] = true;
				}
			}
		}
		return primeCount;
	}
}
