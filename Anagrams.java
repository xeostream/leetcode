import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

/*
Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case
*/

public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> rst = new ArrayList<String>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String s = Arrays.toString(c);
			if (map.containsKey(s)) {
				map.get(s).add(str);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(str);
				map.put(s, list);
			}
		}
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1) {
				rst.addAll(entry.getValue());
			}
		}
		return rst;
	}
}