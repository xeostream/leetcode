/*
* Suppose a sorted array is rotated at some pivot unknown to you beforehand.

* (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

* Find the minimum element.

* You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] num) {
        if (null == num) {
            return 0;
        }
        int start = 0, end = num.length - 1;
        while (start != end) {
            if (num[start] > num[end]) {
                start++;
            } else if (num[start] < num[end]) {
                end--;
            }
        }
        return num[start];
    }
}