
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
		int numberOfPrimes = 0;
		boolean[] visited = new boolean[n+1];
		for (int candidate = 2; candidate <= n; candidate++) {
			if (visited[candidate] == false) {
				numberOfPrimes++;
				for (int toVisit = candidate; toVisit <= n; toVisit+=candidate) {
					visited[toVisit] = true;
				}
			}
		}
		return numberOfPrimes;
	}
}
