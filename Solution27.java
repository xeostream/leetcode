import java.util.ArrayList;

/*
 * Triangle
 * [
 *   [2],
 *  [3,4],
 * [6,5,7],
 *[4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11)
 */
public class Solution27 {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		Integer[] result = triangle.get(triangle.size()-1).toArray(new Integer[0]);
		for (int i = triangle.size()-2; i >= 0; i--)
			for (int j = 0; j < triangle.get(i).size(); j++)
				result[j] = triangle.get(i).get(j) + Math.min(result[j], result[j+1]);
		return result[0];
	}
	
	public static void main(String ...args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> one = new ArrayList<Integer>();
		one.add(-1);
		list.add(one);
		one = new ArrayList<Integer>();
		one.add(2);
		one.add(3);
		list.add(one);
		one = new ArrayList<Integer>();
		one.add(1);
		one.add(-1);
		one.add(-3);
		list.add(one);
		Solution27 s27 = new Solution27();
		System.out.println(s27.minimumTotal(list));
		System.out.println();
	}
}
