/*
A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -∞.
For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Note:
Your solution should be in logarithmic complexity.
*/

public class Solution {
	public int findPeakElement(int[] num) {
        int[] array = new int[num.length + 2];
        array[0] = Integer.MIN_VALUE;
        array[array.length - 1] = Integer.MIN_VALUE;
        System.arraycopy(num, 0, array, 1, num.length);
        return this.findPeakElement(array, 1, num.length);
    }

    public int findPeakElement(int[] num, int start, int end) {
        if (start == end) {
            if (num[start] > num[start - 1] && num[start] > num[start + 1]) {
                return start - 1;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        int mid = (start + end) / 2;
        if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
            return mid - 1;
        }
        int rst = findPeakElement(num, start, mid);
        if (Integer.MIN_VALUE == rst) {
            return findPeakElement(num, mid + 1, end);
        } else {
            return rst;
        }
    }
}