/*
 * Palindrome Partitioning II
 * given s = "aab",
 * Return 1 the palindrome partitioning ["aa","b"] could be produced using 1 cut
 */
public class Solution19 {
	/*recurse delete longest palidrome substring is wrong
	public int minCut(String s) {
		if (s.equals("")) return 0;
		int cnt = pralidrome(s);
		return cnt-1;
	}
	
	public int pralidrome(String s) {
		if (s.equals("")) return 0;
		int length = 1;
		int begin = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length()-1; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j) && (j-i+1) > length) {
					int m = i+1, n = j-1;
					while (m < n && s.charAt(m) == s.charAt(n)) {
						m++;
						n--;
					}
					if (m == n || m-n == 1) {
						length = j - i + 1;
						begin = i;
						end = j;
					}
				}
			}
		}
		if (begin == 0 && end == s.length()-1)
			return 1;
		else
			return pralidrome(s.substring(0, begin))+pralidrome(s.substring(end+1))+1;
	}*/
	
	public int minCut(String s) {
		int length = s.length();
		int[] dp = new int[length+1];
		boolean[][] palidrome = new boolean[length][length];
		for (int i = 0; i < dp.length; i++)
			dp[i] = length - i;
		for (int i = length-1; i >= 0; i--)
			for (int j = i; j < length; j++)
				if (s.charAt(i)==s.charAt(j) && (j-i < 2 || palidrome[i+1][j-1])) {
					palidrome[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j+1]+1);
				}
		return dp[0]-1;
	}
	
	public static void main(String ...args) {
		Solution19 s19 = new Solution19();
		String s = "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
		System.out.println(s.length());
		System.out.println(s19.minCut(s));
	}
}
