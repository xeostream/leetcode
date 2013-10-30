import java.util.ArrayList;

/*
 * Palindrome Partitioning
 * Given a string s,Return all possible palindrome partitioning of s.
 */
public class Solution35 {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (!s.equals("")) {
			for (int i = 0; i < s.length(); i++) {
				if (isPalindrome(s.substring(0, i+1))) {
					ArrayList<String> temp = new ArrayList<String>();
					temp.add(s.substring(0, i+1));
					partition(result, temp, s.substring(i+1));
				}
			}
		}
		return result;
	}
	
	public void partition(ArrayList<ArrayList<String>> result, ArrayList<String> temp, String s) {
		if (s.equals("")) {
			result.add(temp);
			return ;
		}
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s.substring(0, i+1))) {
				ArrayList<String> str = new ArrayList<String>();
				for (String st: temp)
					str.add(st);
				str.add(s.substring(0, i+1));
				partition(result, str, s.substring(i+1));
			}
		}
	}
	
	public boolean isPalindrome(String s) {
		for (int i = 0; i < s.length()/2; i++)
			if (s.charAt(i) != s.charAt(s.length()-1-i))
				return false;
		return true;
	}
	
	public static void main(String ...args) {
		ArrayList<ArrayList<String>> result = null;
		Solution35 s35 = new Solution35();
		result = s35.partition("aab");
		for (ArrayList<String> list : result) {
			for (String str : list)
				System.out.print(str+" ");
			System.out.println();
		}
	}
}
