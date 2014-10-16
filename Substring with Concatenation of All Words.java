/*
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

public class Solution {
	/*
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> rst = new ArrayList<Integer>();
		int lLen = L[0].length();
		int len = S.length() - lLen * L.length;
		for (int i = 0; i < len; i++) {
			String tmp = S.substring(i, i+L[j].length());
			for (int j = 0; j < L.length; j++) {
				if (L[j].equals(tmp)) {
					L[j] = "";
					if (findSubstring(S, L, i+L[j].length(), 1, lLen)) {
						rst.add(i);
					}
					L[j] = tmp;
				}
			}
		}
		return rst;
	}
	private boolean findSubstring(String S, String[] L, int sCur, int cnt, int lLen) {
		if (cnt == L.length) {
			return true;
		}
		String tmp = S.substring(sCur, sCur+lLen);
		for (int i = 0; i < L.length; i++) {
			if (L[i].equals(tmp)) {
				L[i] = "";
				return findSubstring(S, L, sCur+lLen, cnt+1, lLen);
				L[i] = tmp;
			}
		}
		return false;
	}*/
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> rst = new ArrayList<Integer>();
		int lLen = L[0].length();
		int len = lLen * L.length;
		if (S.length() < len) {
			return rst;
		}
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		for (String str : L) {
			if (wordCount.containsKey(str)) {
				int cnt = wordCount.get(str);
				wordCount.put(str, cnt+1);
			} else {
				wordCount.put(str, 1);
			}
		}
		for (int i = 0; i < S.length()-len; i++) {
			Map<String, Integer> map = new HashMap<String, Integer>(wordCount);
			String substr = S.substring(i, i+len);
			for (int j = i; !map.isEmpty() && j < substr.length()-lLen; j += lLen) {
				String tmp = S.substring(j, j+lLen);
				if (map.containsKey(tmp)) {
					int cnt = wordCount.get(tmp);
					if (cnt == 1) {
						map.remove(tmp);
					} else {
						map.put(tmp, cnt-1);
					}
				} else {
					break;
				}
			}
			if (map.isEmpty()) {
				rst.add(i);
			}
		}
		return rst;
	}
}