public class Solution {
	public int maxSubArray(int[] A) {
		if (A.length == 1) return A[0];
		int len = A.length;
		int[] toLeft = new int[len];
		int[] toRight = new int[len];
		int[] sum = new int[len];
		toLeft[len-1] = A[len-1], toRight[0] = A[0];
		for (int i = len-2; i >= 0; i--) {
			toLeft[i] = (toLeft[i+1]+A[i]) > A[i] ? (toLeft[i+1]+A[i]) : A[i];
		}
		for (int i = 1; i < len; i++) {
			toRight[i] = (toRight[i-1]+A[i]) > A[i] ? (toRight[i-1]+A[i]) : A[i];
		}
		for (int i = 0; i < len; i++) {
			sum[i] = toLeft[i] + toRight[i] - A[i];
		}
		return getMax(sum);
	}
	public int getMax(int[] sum) {
		int max = sum[0];
		for (int i : sum) {
			if (max < i) max = i;
		}
		return max;
	}
}