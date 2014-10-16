/*
The string ”PAYPALISHIRING” is written in a zigzag pattern on a given number of rows like this: (you
may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: ”PAHNAPLSIIGYIR”
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert(”PAYPALISHIRING”, 3) should return ”PAHNAPLSIIGYIR”.
*/

public class Solution {
	public String convert(String s, int nRows) {
		int nCols = s.length() / 2 > 0 ? s.length() / 2 + 1 : 1;
		char[][] matrix = new char[nRows][nCols];
		int index = 0;
		String rst = "";
		for (int i = 0; i < nCols; i++) {
			if (index >= s.length()) break;
			if (i % (nRows - 1) == 0) {
				for (int j = 0; j < nRows; j++) {
					if (index >= s.length()) break;
					matrix[j][i] = s.charAt(index++);
				}
			} else {
				matrix[nRows- 1 - (i % (nRows - 1))][i] = s.charAt(index++);
			}
		}
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (matrix[i][j] != 0) {
					rst += matrix[i][j];
				}
			}
		}
		return rst;
	}
	public String convert(String s, int nRows) {
		if (nRows <= 1 || s.length() <= 1) return s;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nRows; i++) {
			for (int j = 0, index = i; index < s.length(); j++, index = (2 * nRows - 2) * j + i) {
				sb.append(s.charAt(index));
				if (i == 0 || i == nRows - 1) continue;
				if (index + (nRows - i - 1) * 2 < s.length())
					sb.append(s.charAt(index + (nRows - i - 1) * 2));
			}
		}
		return sb.toString();
	}
}