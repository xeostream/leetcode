import java.lang.System;

/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class Solution {
    public void sortColors(int[] A) {
        int begin = 0, end = A.length - 1;
        while (begin < end) {
            while (begin < A.length && A[begin] == 0) {
                begin++;
            }
            while (end >= 0 && A[end] != 0) {
                end--;
            }
            if (begin < end) {
                int temp = A[begin];
                A[begin] = A[end];
                A[end] = temp;
                begin++;
                end--;
            }
        }
        end = A.length - 1;
        while (begin < end) {
            while (begin < A.length && A[begin] <= 1) {
                begin++;
            }
            while (end >= 0 && A[end] == 2) {
                end--;
            }
            if (begin < end) {
                int temp = A[begin];
                A[begin] = A[end];
                A[end] = temp;
                begin++;
                end--;
            }
        }
    }
    public static void main(String... args) {
        Solution s = new Solution();
        int[] A = new int[]{1,0,0};
        s.sortColors(A);
        for (int i : A) {
            System.out.print(i);
        }
        System.out.println();
    }
}