/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
public class Solution {
	public String getPermutation(int n, int k) {
        if (n < 1 || k < 1 || k > factorial(n)) return null;
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = i + 1;
        }
        return getPermutation(number, n-1, k-1, "");
    }
    public String getPermutation(int[] number, int n, int k, String str) {
        if (k == 0) {
            for (int i : number) {
                str += ("" + i);
            }
            return str;
        }
        if (k == 1) {
            for (int i = 0; i < number.length-2; i++) {
                str += ("" + number[i]);
            }
            str += ("" + number[number.length-1]);
            str += ("" + number[number.length-2]);
            return str;
        }
        int fact = factorial(n);
        str += ("" + getElement(number, k/fact));
        int[] num = initArray(number);
        return getPermutation(num, n-1, k%fact, str);
    }
    public int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public int getElement(int[] number, int index) {
        int temp = number[index];
        number[index] = -1;
        return temp;
    }
    public int[] initArray(int[] number) {
        int[] num = new int[number.length-1];
        int i = 0;
        for (int j = 0; j < number.length; j++) {
            if (number[j] != -1) {
                num[i++] = number[j];
            }
        }
        return num;
    }
}