/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
*/

public class Solution {
	public String convertToTile(int n) {
        String ans = "";
        while (n > 0) {
            n--;
            ans = (char)('A'+ n % 26) + ans;
            n /= 26;
        }
        return ans;
	}
}