/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
The array may contain duplicates.
*/
public class Solution {
    public int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }
    
    public int findMin(int[] num, int start, int end) {
        if (start == end) {
            return num[start];
        }
        if (end - start == 1) {
            return Math.min(num[start], num[end]);
        }
        if (num[start] < num[end]) {
            return num[start];
        } else {
            int mid = (start + end) >> 1;
            if (num[start] == num[mid]) {
                return Math.min(findMin(num, start, mid), findMin(num, mid+1, end));
            } else if (num[start] < num[mid]) {
                return findMin(num, mid+1, end);
            } else {
                return findMin(num, start, mid);
            }
        }
    }
    
}