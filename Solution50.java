import java.util.ArrayList;

/*
 * Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.
 * given k = 3,Return [1,3,3,1].
 */
public class Solution50 {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (rowIndex < 0) return result;
		result.add(1);
		for (int i = 0; i < rowIndex; i++) {
			int temp = 1, p;
			for (int j = 1; j < (i + 1); j++) {
				p = result.get(j);
				result.set(j, p+temp);
				temp = p;
			}
			result.add(1);
		}
		return result;
	}
	
	public static void main(String ...args) {
		Solution50 s50 = new Solution50();
		ArrayList<Integer> result = s50.getRow(10);
		for (int i : result)
			System.out.print(i + " ");
		System.out.println();
	}
}
