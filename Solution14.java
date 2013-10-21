/*
 * Distinct Subsequences
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 */
public class Solution14 {
	/* Time Limit Exceeded
	public int numDistinct(String S, String T) {
		if (T.length() == 0)
			return 1;
		if (S.length() < T.length())
			return 0;
		else if (S.length() == T.length()) {
			if (S.equals(T))
				return 1;
			else
				return 0;
		} else {
			int count = 0;
			for (int i = 0; i < S.length(); i++) {
				if (S.charAt(i) == T.charAt(0))
					count += numDistinct(S.substring(i+1), T.substring(1));
			}
			return count;
		}
	}*/
	
	public int numDistinct(String S, String T) {
		int[][] result = new int[T.length()+1][S.length()+1];
		for (int i = 0; i <= S.length(); i++)
			result[0][i] = 1;
		for (int i = 1; i <= T.length(); i++)
			result[i][0] = 0;
		for (int i = 1; i <= T.length(); i++)
			for (int j = 1; j <= S.length(); j++) {
				result[i][j] = result[i][j-1] + (S.charAt(j-1)==T.charAt(i-1)?result[i-1][j-1]:0);
			}
		return result[T.length()][S.length()];
	}
	
	public static void main(String ...args) {
		Solution14 s14 = new Solution14();
		System.out.println(s14.numDistinct("ccc", "ccc"));
	}
}
