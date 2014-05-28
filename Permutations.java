/*
Given a collection of numbers, return all possible permutations.
For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1],
[3,1,2], and [3,2,1].
*/

public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below // DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(num);
		int n = num.length;
		boolean[] visited = new boolean[n];
		permuteImp(res, tmp, num, visited);
		return res;
	}

	private void permuteImp(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> tmp, int[] num, boolean[] visited) {
		if (tmp.size() == num.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				tmp.add(num[i]);
				visited[i] = true;
				permuteImp(res, tmp, num, visited);
				visited[i] = false;
				tmp.remove(tmp.size() - 1);
				while (i + 1 < num.length && num[i + 1] == num[i])
					i++;
			}
		}
	}
}