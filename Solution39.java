import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

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
	/*time exceed
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
	}*/
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        
        // Start typing your Java solution below
        // DO NOT write main() function              
        
        HashMap<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();
        
        dict.add(start);
        dict.add(end);
        
        // init adjacent graph        
        for(String str : dict){
            calcNeighbours(neighbours, str, dict);
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        // BFS search queue
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(null, start, 1));
        
        // BFS level
        int previousLevel = 0;
        
        // mark which nodes have been visited, to break infinite loop
        HashMap<String, Integer> visited = new HashMap<String, Integer>(); 
        while(!queue.isEmpty()){
            Node n = queue.pollFirst();            
            if(end.equals(n.str)){ 
                // fine one path, check its length, if longer than previous path it's valid
                // otherwise all possible short path have been found, should stop
                if(previousLevel == 0 || n.level == previousLevel){
                    previousLevel = n.level;
                    findPath(n, result);                    
                }else {
                    // all path with length *previousLevel* have been found
                    break;
                }                
            }else {
                HashSet<String> set = neighbours.get(n.str);                 
                
                if(set == null || set.isEmpty()) continue;
                // note: I'm not using simple for(String s: set) here. This is to avoid hashset's
                // current modification exception.
                ArrayList<String> toRemove = new ArrayList<String>();
                for (String s : set) {
                    
                    // if s has been visited before at a smaller level, there is already a shorter 
                    // path from start to s thus we should ignore s so as to break infinite loop; if 
                    // on the same level, we still need to put it into queue.
                    if(visited.containsKey(s)){
                        Integer occurLevel = visited.get(s);
                        if(n.level+1 > occurLevel){
                            neighbours.get(s).remove(n.str);
                            toRemove.add(s);
                            continue;
                        }
                    }
                    visited.put(s,  n.level+1);
                    queue.add(new Node(n, s, n.level + 1));
                    if(neighbours.containsKey(s))
                        neighbours.get(s).remove(n.str);
                }
                for(String s: toRemove){
                    set.remove(s);
                }
            }
        }

        return result;
    }
    
    public void findPath(Node n, ArrayList<ArrayList<String>> result){
        ArrayList<String> path = new ArrayList<String>();
        Node p = n;
        while(p != null){
            path.add(0, p.str);
            p = p.parent; 
        }
        result.add(path);
    }

    /*
     * complexity: O(26*str.length*dict.size)=O(L*N)
     */
    void calcNeighbours(HashMap<String, HashSet<String>> neighbours, String str, HashSet<String> dict) {
        int length = str.length();
        char [] chars = str.toCharArray();
        for (int i = 0; i < length; i++) {
            
            char old = chars[i]; 
            for (char c = 'a'; c <= 'z'; c++) {

                if (c == old)  continue;
                chars[i] = c;
                String newstr = new String(chars);                
                
                if (dict.contains(newstr)) {
                    HashSet<String> set = neighbours.get(str);
                    if (set != null) {
                        set.add(newstr);
                    } else {
                        HashSet<String> newset = new HashSet<String>();
                        newset.add(newstr);
                        neighbours.put(str, newset);
                    }
                }                
            }
            chars[i] = old;
        }
    }
    
    private class Node {
        public Node parent;
        public String str;
        public int level;
        public Node(Node p, String s, int l){
            parent = p;
            str = s;
            level = l;
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
				System.out.print(s + " ");
			System.out.println();
		}
	}
}
