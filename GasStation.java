/**
 * https://leetcode.com/problems/gas-station/
 * 
 * @author kewang
 *
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int totalGas = 0;
    	int totalCost = 0;
    	for (int g : gas) {
    		totalGas += g;
    	}
    	for (int c : cost) {
    		totalCost += c;
    	}
    	if (totalGas < totalCost) {
    		return -1;
    	}
    	int remainingGas = 0;
    	int toStartGuess = 0;
    	for (int station = 0; station != cost.length; station++) {
    		remainingGas = remainingGas + gas[station] - cost[station];
    		if (remainingGas < 0) {
    			remainingGas = 0;
    			toStartGuess = station + 1;
    		}
    	}
    	return toStartGuess;
    }
}
