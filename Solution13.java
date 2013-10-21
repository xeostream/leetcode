import java.util.ArrayList;
import java.util.Arrays;

/*
 * Permutations II
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class Solution13 {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
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
	
	public static void main(String ...args) {
		Solution13 s13 = new Solution13();
		int[] num = {1,2,1,3};
		ArrayList<ArrayList<Integer>> result = s13.permuteUnique(num);
		for (ArrayList<Integer> res : result) {
			for (int i : res)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}
