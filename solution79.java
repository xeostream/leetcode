/*
 * Merge Sorted Array
 */
public class Solution79 {
	public void merge(int A[], int m, int B[], int n) {
		for (int i = 0; i < n; i++) {
			int j = m - 1 + i;
			for (; j >= 0; j--) {
				if (A[j] <= B[i]) {
					break;
				}
				A[j+1] = A[j];
			}
			A[j+1] = B[i];
		}
	}
}