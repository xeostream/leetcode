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
	
	/*
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		record.add(start);
		char[] temp = start.toCharArray();
		for (int i = 0; i < start.length(); i++) {
			char c = temp[i];
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
				temp[i] = c;
			}
		}
		return result;
	}
	
	public void findLadders(ArrayList<String> list, String start, String end,
			HashSet<String> dict) {
		char[] temp = start.toCharArray();
		for (int i = 0; i < temp.length; i++) {
			char j = temp[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (temp[i] == c) continue;
				temp[i] = c;
				String str = new String(temp);
				if (str.equals(end)) {
					list.add(end);
					result.add(list);
					return ;
				} else if (dict.contains(str) && !record.contains(str)) {
					ArrayList<String> tem = new ArrayList<String>();
					for (String s : list)
						tem.add(s);
					tem.add(str);
					record.add(str);
					findLadders(tem, str, end, dict);
				}
				temp[i] = j;
			}
		}
	}*/
	//time exceed
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict){
	    ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
	    ArrayList<String> path = new ArrayList<String>();
	    wordLadderIIHelper(start, end, dict, path, ret);

	    int min = 0;
	    for(ArrayList<String> item : ret){
	        min = min == 0 || item.size() < min ? min = item.size() : min;
	    }

	    for(int i = 0; i < ret.size(); i++){
	        if(ret.get(i).size() > min)
	            ret.remove(i--); // REMEMBER the  "i--" when removing elements from ArrayList
	    }
	    return ret;
	}
	public void wordLadderIIHelper(String start, String end, HashSet<String> dict, ArrayList<String> path, ArrayList<ArrayList<String>> ret){
	    path.add(start);
	    char[] sArr = start.toCharArray();
	    for(int i = 0; i < sArr.length; i++){
	        char origin = sArr[i];
	        for(char c = 'a'; c <= 'z'; c++){
	            if(c != origin){
	                sArr[i] = c;
	                String temp = new String(sArr);
	                if(temp.equals(end)){
	                    path.add(temp);
	                    ret.add(new ArrayList<String>(path));
	                    path.remove(path.size() - 1);
	                }
	                if(dict.contains(temp) && !path.contains(temp)) 
	                    wordLadderIIHelper(temp, end, dict, path, ret);
	            }
	        }
	        sArr[i] = origin;
	    }
	    path.remove(path.size() - 1);
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
				System.out.print(s + " ");
			System.out.println();
		}
	}
}
