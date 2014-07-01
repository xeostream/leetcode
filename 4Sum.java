/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/
public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (num.length < 4) {
			return rst;
		}
		Arrays.sort(num);
		Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
		for (int i = 0; i < num.length; i++) {
			for (int j = i+1; j < num.length; j++) {
				int m = num[i] + num[j];
				int[] nums = {i, j};
				if (map.containsKey(m)) {
					map.get(m).add(nums);
				} else {
					List<int[]> list = new ArrayList<int[]>();
					list.add(nums);
					map.put(m, list);
				}
			}
		}
		for (int i = 0; i < num.length; i++) {
			for (int j = i+1; j < num.length; j++) {
				int sub = target - num[i] - num[j];
				if (map.containsKey(sub)) {
					for (int[] tmp : map.get(sub)) {
						if (tmp[0] > j) {
							List<Integer> list = new ArrayList<Integer>();
							list.add(num[i]);
							list.add(num[j]);
							list.add(num[tmp[0]]);
							list.add(num[tmp[1]]);
							rst.add(list);
						}
					}
				}
			}
		}
		Set<List<Integer>> set = new HashSet<List<Integer>>(rst);
		rst.clear();
		rst.addAll(set);
		return rst;
	}
}