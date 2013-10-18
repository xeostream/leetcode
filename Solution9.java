/*
 * Interleaving String leetcode
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class Solution9 {
	/*
	 * Time Limit Exceeded
	public boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
		if (l1 == 0 || l2 == 0)
			return s3.equals(s1+s2);
		if (l3-l1 == l2) {
			int i = 0, j = 0;
			String temp = "";
			while ((l3-j) >= (l1-i)) {
				if (s1.charAt(i) == s3.charAt(j) && dfs(s1,s2,s3,i+1,j+1,temp))
					return true;
				if (j == (l3-1))
					return false;
				temp += s3.charAt(j++);
			}
		}
		return false;
	}
	
	public boolean dfs(String s1, String s2, String s3, int i, int j, String temp) {
		if (!(temp.equals("") || s2.startsWith(temp)))
			return false;
		if (i == s1.length()) {
			temp += s3.substring(j);
			if (s2.equals(temp))
				return true;
			return false;
		}
		int m = i, n = j;
		String str = temp;
		while ((s3.length()-n) >= (s1.length()-m)) {
			if (s1.charAt(m) == s3.charAt(n) && dfs(s1,s2,s3,m+1,n+1,str))
				return true;
			if (n == s3.length()-1)
				return false;
			str += s3.charAt(n++);
		}
		return false;
	}*/
	public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if (s3.length() != s1.length() + s2.length())
            return false;
        else return dp(s1, s1.length()-1, s2, s2.length()-1, s3, s3.length()-1);
    }

    public boolean dp(String s1, int end1, String s2, int end2, String s3,
    		int end3) {
        if (end3 < 0)
            return true;
        else if (end1 <0) {
            return s2.substring(0,end2+1).equals(s3.substring(0, end3+1));
        } else if (end2 < 0) {
            return s1.substring(0,end1+1).equals(s3.substring(0, end3+1));
        }
        char c3 = s3.charAt(end3);
        char c1 = s1.charAt(end1);
        char c2 = s2.charAt(end2);
        if (c3 == c1 && c3 == c2) {
            return dp(s1, end1-1, s2, end2, s3, end3-1) || dp(s1, end1, s2,
            		end2-1, s3, end3-1);
        } else if (c3 == c1)
            return dp(s1, end1-1, s2, end2, s3, end3-1);
        else if (c3 == c2)
            return dp(s1, end1, s2, end2-1, s3, end3-1);
        else
            return false;
    }
	
	public static void main(String ...args) {
		Solution9 s9 = new Solution9();
		System.out.println(s9.isInterleave("aabcc","dbbca","aadbbcbcac"));
	}
}
