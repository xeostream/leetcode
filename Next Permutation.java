/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class Solution {
	public void nextPermutation(int[] num) {
		for (int i = num.length-1; i > 0; i--) {
			if (num[i] > num[i-1]) {
				for (int j = num.length-1; j >= i; j--) {
					if (num[j] > num[i-1]) {
						num[i-1] = num[i-1] ^ num[j];
						num[j] = num[i-1] ^ num[j];
						num[i-1] = num[i-1] ^ num[j];
						break;
					}
				}
				swap(num, i, num.length-1);
			}
		}
		swap(num, 0, num.length-1);
	}
	private void swap(int[] num, int start, int end) {
		if (start == end) return ;
		int len = end - start;
		for (int i = 0; i <= len / 2; i++) {
			if (num[start+i] != num[end-i]) {
				num[start+i] = num[start+i] ^ num[end-i];
				num[end-i] = num[start+i] ^ num[end-i];
				num[start+i] = num[start+i] ^ num[end-i];
			}
		}
	}
}