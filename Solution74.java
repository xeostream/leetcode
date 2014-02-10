import java.util.ArrayList;

/*
 * Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"].
 */
public class Solution74 {
	public static ArrayList<String> restoreIPAddresses(String s) {
		ArrayList<String> result = new ArrayList<String>();
		if (s.length() > 3 && s.length() < 13) {
			for (int i = 0; i < 3; i++) {
				String s1 = s.substring(0, i+1), s2 = s.substring(i+1);
				if (s2.length() < 3 || s2.length() > 9 || Integer.parseInt(s1) > 255 || (s1.length() > 1 && s1.startsWith("0"))) continue;
				for (int j = 0; j < 3; j++) {
					String s3 = s2.substring(0, j+1), s4 = s2.substring(j+1);
					if (s4.length() < 2 || s4.length() > 6 || Integer.parseInt(s3) > 255 || (s3.length() > 1 && s3.startsWith("0"))) continue;
					for (int m = 0; m < 3 && m < s4.length(); m++) {
						String s5 = s4.substring(0, m+1), s6 = s4.substring(m+1);
						if (s6.length() < 1 || s6.length() > 3 || Integer.parseInt(s5) > 255 || Integer.parseInt(s6) > 255 || (s5.length() > 1 && s5.startsWith("0")) || (s6.length() > 1 && s6.startsWith("0"))) continue;
						result.add(s1+"."+s3+"."+s5+"."+s6);
					}
				}
			}
		}
		return result;
	}
	public static void main(String ...args) {
		ArrayList<String> result = Solution74.restoreIPAddresses("172162541");
		for (String s : result)
			System.out.println(s);
	}
}
