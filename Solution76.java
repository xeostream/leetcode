/*
 * Subsets II
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 *  Elements in a subset must be in non-descending order.
 *  The solution set must not contain duplicate subsets.
 *     
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Solution76 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashSet<String> set = new HashSet<String>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        result.add(temp);
        StringBuffer sb = new StringBuffer("");
        subsetsWithDup(num, 0, num.length, result, temp, set, sb);
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
    public static void main(String ...args) {
        int[] num = {1, 2, 2};
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> result = s.subsetsWithDup(num);
        for (ArrayList<Integer> list : result) {
            for (int i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}