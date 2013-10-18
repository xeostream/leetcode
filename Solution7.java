/*
 * Length of Last Word
 * Given s = "Hello World"
 * return 5
 */
public class Solution7 {
	public int lengthOfLastWord(String s) {
		int length = 0, temp = 0;
		for (int i = 0; i < s.length(); i++) {
			//many blank space
			if (i >0 && s.charAt(i) == ' ' && s.charAt(i-1) != ' ') {
				temp = length;
				length = 0;
			} else if (s.charAt(i) != ' ')
				length++;
		}
		return (length>0?length:temp);
	}
	
	public static void main(String ...args) {
		Solution7 s7 = new Solution7();
		System.out.println(s7.lengthOfLastWord("b a  "));
	}
}
