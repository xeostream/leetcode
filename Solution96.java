/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
public class Solution {
	public int climbStairs(int n) {
		if (n == 0 || n == 1) return 1;
		int[] record = new int[n];
		return climbStairs(n-1, record) + climbStairs(n-2, record);
	}
	public int climbStairs(int n, int[] record) {
		if (n == 0 || n == 1) return 1;
		if (record[n] == 0) {
			record[n] = climbStairs(n-1, record) + climbStairs(n-2, record);
		}
		return record[n];
	}
}