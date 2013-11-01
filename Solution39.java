import java.util.ArrayList;
import java.util.HashSet;

/*
 * Word Ladder II
 * Given two words (start and end) and a dictionary
 * find all shortest transformation sequence(s) from start to end
 * Rule1. Only one letter can be changed at a time
 * Rule2. Each intermediate word must exist in the dictionary
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return:
 * [
 *  ["hit","hot","dot","dog","cog"],
 *  ["hit","hot","lot","log","cog"]
 * ]
 */
public class Solution39 {
	private ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	private HashSet<String> record = new HashSet<String>();
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		record.add(start);
		char[] temp = start.toCharArray();
		for (int i = 0; i < start.length(); i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				if (temp[i] == j) continue;
				temp[i] = j;
				String str = new String(temp);
				if (str.equals(end)) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(start);
					list.add(end);
					result.add(list);
					record.add(str);
				} else if (dict.contains(str) && !record.contains(str)) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(start);
					list.add(str);
					record.add(str);
					findLadders(list, str, end, dict);
				}
			}
		}
		return result;
	}
	
	public void findLadders(ArrayList<String> list, String start, String end,
			HashSet<String> dict) {
		char[] temp = start.toCharArray();
		for (int i = 0; i < temp.length; i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (temp[i] == c) continue;
				temp[i] = c;
				String str = new String(temp);
				if (str.equals(end)) {
					list.add(end);
					result.add(list);
				} else if (dict.contains(str) && !record.contains(str)) {
					ArrayList<String> tem = new ArrayList<String>();
					for (String s : list)
						tem.add(s);
					tem.add(str);
					findLadders(tem, str, end, dict);
				}
			}
		}
	}
	
	public static void main(String ...args) {
		Solution39 s39 = new Solution39();
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("lot");
		dict.add("dot");
		dict.add("dog");
		dict.add("log");
		ArrayList<ArrayList<String>> result = s39.findLadders("hit", "cog", dict);
		for (ArrayList<String> str : result) {
			for (String s : str)
				System.out.println(s + " ");
			System.out.println();
		}
	}
}
