/*
 * Palindrome Number
 * without extra space
 */
public class Solution12 {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		else if (equal(x, x) != -1)
			return true;
		return false;	
	}
	
	public int equal(int i, int j) {
		if (i == 0)
			return j;
		j = equal(i/10, j);
		if (i%10 == j % 10)
			return j / 10;
		return -1;
	}
	
	public static void main(String ...args) {
		Solution12 s12 = new Solution12();
		System.out.println(s12.isPalindrome(12321));
	}
}
