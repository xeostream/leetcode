import java.util.HashSet;
import java.util.Set;

/*
 * Word Break
 */
public class Solution28 {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s.equals("")) return true;
		for (String str : dict)
			if (s.endsWith(str) && wordBreak(s.replaceFirst(str, ""), dict))
				return true;
		return false;
	}
	
	public static void main(String ...args) {
		Solution28 s28 = new Solution28();
		Set<String> set = new HashSet<String>();
		set.add("leet");
		set.add("code");
		System.out.println(s28.wordBreak("leetcode", set));
	}
}
