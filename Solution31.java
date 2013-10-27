/*
 * Search in Rotated Sorted Array
 */
public class Solution31 {
	public int search(int[] A, int target) {
		for (int i = 0; i < A.length; i++)
			if (A[i] == target)
				return i;
		return -1;
	}
}
