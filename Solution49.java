import java.util.ArrayList;

/*
 * Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 * given numRows = 5
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows > 0) {
			ArrayList<Integer> one = new ArrayList<Integer>();
			one.add(1);
			result.add(one);
			for (int i = 1; i < numRows; i++) {
				ArrayList<Integer> next = new ArrayList<Integer>();
				ArrayList<Integer> prev = result.get(result.size() - 1);
				for (int j = 0; j < prev.size(); j++) {
					int num = prev.get(j);
					if (j > 0)
						num += prev.get(j - 1);
					next.add(num);
				}
				next.add(1);
				result.add(next);
			}
		}
		return result;
	}

	public static void main(String... args) {
		Solution s = new Solution();
		ArrayList<ArrayList<Integer>> result = s.generate(5);
		for (ArrayList<Integer> list : result) {
			for (int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}