public class Solution80 {
	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2)) return true;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String s3 = new String(c1), s4 = new String(c2);
		if (!s3.equals(s4)) return false;
		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);
			if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
			s21 = s2.substring(s2.length()-i);
			s22 = s2.substring(0, s2.length()-i);
			if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
		}
		return false;
	}
}