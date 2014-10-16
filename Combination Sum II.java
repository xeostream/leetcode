/*
Given a set of candidate numbers (C) and a target number (T ), find all unique combinations in C where
the candidate numbers sums to T .
The same repeated number may be chosen from C once number of times.
Note:
• All numbers (including target) will be positive integers.
• Elements in a combination (a1; a2; ...; ak) must be in non-descending order. (ie, a1 > a2 > ... > ak).
• The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
*/

public class Solution {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(num);
		combinationSum2(rst, tmp, num, 0, target);
		return rst;
	}
	private void combinationSum2(List<List<Integer>> rst, ArrayList<Integer> tmp, int[] num, int start, int target) {
		if (target == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>(tmp);
			rst.add(list);
			return ;
		}
		int previous = -1;
		for (int i = start; i < num.length; i++) {
			if (previous == num[i])
				continue;
			if (target >= num[i]) {
				previous = num[i];
				ArrayList<Integer> array = new ArrayList<Integer>(tmp);
				array.add(num[i]);
				combinationSum2(rst, array, num, i+1, target-num[i]);
			}
		}
	}
}