

/*
 * Valid Palindrome
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */
public class Solution15 {
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < s.length()
					&& !((s.charAt(i) >= '0' && s.charAt(i) <= '9')
							|| (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s
							.charAt(i) >= 'a' && s.charAt(i) <= 'z')))
				i++;
			while (j >= 0
					&& !((s.charAt(j) >= '0' && s.charAt(j) <= '9')
							|| (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') || (s
							.charAt(j) >= 'a' && s.charAt(j) <= 'z')))
				j--;
			if (i < j) {
				int size = Math.abs(s.charAt(i) - s.charAt(j));
				if (size != 0 && size != 32)
					return false;
				i++;
				j--;
			}
		}
		return true;
	}

	public static void main(String... args) {
		Solution15 s15 = new Solution15();
		System.out.println(s15.isPalindrome(".,"));
	}
}
