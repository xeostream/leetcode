/*
 * Gas Station
 * There are N gas stations along a circular route
 * where the amount of gas at station i is gas[i]
 * You have a car with an unlimited gas tank
 * it costs cost[i] of gas to travel from station i to its next station (i+1) 
 * You begin the journey with an empty tank at one of the gas stations
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 */
public class Solution33 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int currentGas = 0;
		int len = gas.length;
		if (len == 1) return 0;
		for (int i = 0; i < len; i++) {
			if (gas[i] >= cost[i]) {
				currentGas = gas[i] - cost[i];
				int j = i + 1;
				while (j % len != i && currentGas >= cost[j%len]-gas[j%len]) {
					currentGas -= (cost[j%len] - gas[j%len]);
					j++;
				} 
				if (j % len == i) return i;
				if (j >= len) 
					return -1;
				else
					i = j;
				
			}
		}
		return -1;
	}
	
	public static void main(String ...args) {
		int[] gas = {1, 2};
		int[] cost = {2, 1};
		Solution33 s33 = new Solution33();
		System.out.println(s33.canCompleteCircuit(gas, cost));
	}
}
