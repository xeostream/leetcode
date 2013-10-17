/*
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * first Missing Positive
 */

public class Solution1 {
	public int firstMissingPositive(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] >= 1 && A[i] != (i + 1) && A[i] < A.length
					&& A[A[i] - 1] != A[i]) {
				int temp = A[i];
				A[i] = A[temp - 1];
				A[temp - 1] = temp;
			} else
				i++;
		}
		for (int j = 0; j < A.length; j++) {
			if (A[j] != (j + 1))
				return (j + 1);
		}
		return A.length + 1;
	}

	public static void main(String... args) {
		Solution1 s = new Solution1();
		int[] A = { -1, 4, 2, 1, 9, 10 };
		System.out.println(s.firstMissingPositive(A));
	}
}
