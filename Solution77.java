/*
 * Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.    
 */
public class Solution77 {
	public int numDecodings(String s) {
		if (s.length() == 0) return 0;
		int[] num = new int[s.length() + 2];
		for (int i = 0; i < num.length; i++) {
			num[i] = 1;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '0')
				num[i] = 0;
			else
				num[i] = num[i + 1];

			if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')))
				num[i] += num[i + 2];
		}
		return num[0];
	}
}