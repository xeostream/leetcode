public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n < k) return result;
		for (int i =1; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(i);
			combine(i+1, end, k-1, result, list);
		}
		return result;
	}
	public void combine(int start, int end, int k, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
		if (k > (end-start+1)) return;
		if (k == 0) {
			result.add(temp);
			return;
		}
		for (int i = start; i <= end; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>(temp);
			list.add(i);
			combine(i+1, end, k-1, result, list);
		}
	}
}