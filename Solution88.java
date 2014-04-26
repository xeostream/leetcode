/*Given a set of distinct integers, S, return all possible subsets.
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashSet<String> set = new HashSet<String>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        result.add(temp);
        StringBuffer sb = new StringBuffer("");
        subsetsWithDup(S, 0, S.length, result, temp, set, sb);
        return result;
    }
    
    public void subsetsWithDup(int[] num, int begin, int end, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, HashSet<String> set, StringBuffer sb) {
        if (begin >= end) return ;
        StringBuffer str = null;
        for (int i = begin; i < end; i++) {
            str = new StringBuffer(sb);
            str.append("" + num[i]);
            if (set.contains(str.toString())) continue;
            set.add(str.toString());
            ArrayList<Integer> list = new ArrayList<Integer>(temp);
            list.add(num[i]);
            result.add(list);
            subsetsWithDup(num, i+1, end, result, list, set, str);
        }
    }
}