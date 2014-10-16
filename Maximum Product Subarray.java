/*
* Find the contiguous subarray within an array (containing at least one number) which has the largest product.

* For example, given the array [2,3,-2,4],
* the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], temp = 0;
        int rst = A[0];
        for (int i = 1; i < A.length; i++) {
            temp = Math.max(Math.max(max * A[i], A[i]), min * A[i]);
            min = Math.min(Math.min(max * A[i], A[i]), min * A[i]);
            max = temp;
            rst = Math.max(rst, max);
        }
        return rst;
    }
}