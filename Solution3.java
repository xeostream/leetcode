import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * Word break ||
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class Solution3 {
	/*
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return result;
		}
		int length = s.length();
		dfs(s, 0, 0, length, dict, result, new StringBuffer());
		return result;
	}*/
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			boolean key = false;
			for (String d : dict) {
				if (d.indexOf(s.charAt(i)) >= 0) {
					key = true;
					break;
				}
			}
			if (!key)
				return result;
		}
		for (String str : dict) {
			if (s.startsWith(str)) {
				dfs(s.replaceFirst(str, ""), str, dict, result);
			}
		}
		return result;
	}
	
	public void dfs(String s, String left, Set<String> dict, ArrayList<String> result) {
		if (s.equals(""))
			result.add(left);
		else {
			for (String str : dict) {
				if (s.startsWith(str))
					dfs(s.replaceFirst(str, ""),left+" "+str,dict,result);
			}
		}
	}
	/*
	public void dfs(String s, int start, int depth, int length,
			Set<String> dict, ArrayList<String> result, StringBuffer sb) {
		if (depth == length) {
			String t = sb.toString();
			result.add(t.substring(0, t.length() - 1));
			return;
		}

		for (int len = 1; len <= length - start; len++) {
			String t = s.substring(start, start + len);
			if (dict.contains(t)) {
				int beforeAddLen = sb.length();
				sb.append(t).append(" ");
				dfs(s, start + len, depth + len, length, dict, result, sb);
				sb.delete(beforeAddLen, sb.length());
			}
		}
	}*/

	public static void main(String... args) {
		Solution3 s3 = new Solution3();
		String s = "catsanddog";
		Set<String> set = new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		ArrayList<String> list = new ArrayList<String>();
		list = s3.wordBreak(s, set);
		for (String l : list)
			System.out.println(l);
	}
}
