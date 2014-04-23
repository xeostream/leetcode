/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".*/
public Class Solution {
	/*public String minWindow(String S, String T) {
		HashMap<Character, Integer> hasFound = initMap(S);
		HashMap<Character, Integer> needToFound = initMap(T);
		for (char c : T.toCharArray) {
			if (hasFound.get(c) < needToFound.get(c)) {
				return "";
			}
		}
		String str1 = minWindow(new HashMap(hasFound), new HashMap(needToFound), S);
		String str2 = minWindow(new HashMap(hasFound), new HashMap(needToFound), (new StringBuffer(S)).reverse().toString());
		return str1.length() > str2.length() ? str2 : str1;
	}
	private Map<Character, Integer> initMap(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}
	private String minWindow(Map<Character, Integer> hasFound, Map<Character, Integer> needToFound, String S) {
		int begin = 0, end = S.length() - 1;
		String str = "";
		for (; begin <= end; begin++) {
			char t = S.charAt(begin);
			if (needToFound.containsKey(t) {
				if (needToFound.get(t) > hasFound.get(t)) {
					hasFound.put(t, hasFound.get(t)-1);
				}
				if (needToFound.get(t) == hasFound.get(t)) {
					break;
				}
			}
		}
		for (; end >= begin; end--) {
			char c = S.charAt(end);
			if (needToFound.containsKey(c) {
				if (needToFound.get(c) > hasFound.get(c)) {
					hasFound.put(c, hasFound.get(c)-1);
				}
				if (needToFound.get(c) == hasFound.get(c)) {
					break;
				}
			}
		}
		return S.substring(begin, end+1);
	}*/
	
	public String minWindow(String S, String T){
        HashMap<Character, Integer> needToFill = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
        int count = 0;
        for(int i = 0; i < T.length(); i++){
            if(!needToFill.containsKey(T.charAt(i))){
                needToFill.put(T.charAt(i), 1);
                hasFound.put(T.charAt(i), 0);
            }else {
                needToFill.put(T.charAt(i), needToFill.get(T.charAt(i)) + 1);
            }
        }
        int minWinBegin = -1;
        int minWinEnd = S.length();
        for(int begin = 0, end = 0; end < S.length(); end++){
            char c = S.charAt(end);
            if(needToFill.containsKey(c)){
                hasFound.put(c, hasFound.get(c) + 1);
                if(hasFound.get(c) <= needToFill.get(c)){
                    count++;
                }
                if(count == T.length()){
                    while(!needToFill.containsKey(S.charAt(begin)) ||
                            hasFound.get(S.charAt(begin)) > needToFill.get(S.charAt(begin))) {
                        if(needToFill.containsKey(S.charAt(begin)) 
                                && hasFound.get(S.charAt(begin)) > needToFill.get(S.charAt(begin))){
                            hasFound.put(S.charAt(begin), hasFound.get(S.charAt(begin)) - 1);
                        }
                        begin++;
                    }
                    if(end - begin < minWinEnd - minWinBegin){
                        minWinEnd = end;
                        minWinBegin = begin;
                    }
                }
            }
        }
        return minWinBegin == -1 ? "" : S.substring(minWinBegin, minWinEnd + 1);
	}
}