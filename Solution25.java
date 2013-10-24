import java.util.ArrayList;

/*
 * Letter Combinations of a Phone Number
 * Given a digit string
 * return all possible letter combinations that the number could represent
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class Solution25 {
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (!digits.equals("")) {
			int length = digits.length();
			char[][] c = {{' '},{' '},{'a','b','c'},{'d','e','f'},{'g','h','i'},
					{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},
					{'w','x','y','z'}};
			int[] total = {0,0,3,3,3,3,3,4,3,4};
			int[] number = new int[length];
			int[] answer = new int[length];
			for (int i = 0; i < length; i++)
				number[i] = digits.charAt(i) - '0';
			while (true) {
				String temp = "";
				for (int i = 0; i < length; i++)
					temp += c[number[i]][answer[i]];
				result.add(temp);
				int k = length - 1;
				while (k >= 0) {
					if (answer[k] < total[number[k]] - 1) {
						answer[k]++;
						break;
					} else {
						answer[k] = 0;
						k--;
					}
				}
				if (k < 0)
					break;
			}
		} else
			result.add("");
		return result;
	}
	
	public static void main(String ...args) {
		Solution25 s25 = new Solution25();
		s25.letterCombinations("23");
	}
}
