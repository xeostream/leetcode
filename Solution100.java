/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	// 正则表达式 time:776ms
	public boolean isNumber(String s) {
		Pattern pattern = Pattern.compile("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?");
		Matcher mat = pattern.matcher(s.trim());
		return mat.matches();
	}
	// time:484ms
	public boolean isNumber(String s) {
		s = s.trim();
		if (s.startsWith("-") || s.startsWith("+")) {
			s = s. substring(1);
		}
		if ("".equals(s)) {
			return false;
		}
		int dotPos = -1, ePos = -1;
		for (int i = 0; i < s.length(); i++) {
			if (dotPos == -1 && s.charAt(i) == '.') {
				dotPos = i;
			} else if (ePos == -1 && s.charAt(i) == 'e') {
				ePos = i;
				if (i+1 < s.length() && (s.charAt(i+1) == '-' || s.charAt(i+1) == '+')) {
					i++;
				}
			} else {
				if (Character.isDigit(s.charAt(i))) {
					continue;
				} else {
					return false;
				}
			}
		}
		//xxx.xxexx
		String startStr, midStr, endStr;
		if (dotPos != -1 && ePos == -1) {
			startStr = s.substring(0, dotPos);
			endStr = s.substring(dotPos+1);
			if (startStr.length() < 1 && endStr.length() < 1) {
				return false;
			}
		} else if (dotPos == -1 && ePos != -1) {
			startStr = s.substring(0, ePos);
			if (startStr.length() < 1) {
				return false;
			}
			endStr = s.substring(ePos+1);
			if (endStr.startsWith("-") || endStr.startsWith("+")) {
				endStr = endStr.substring(1);
			}
			if (endStr.length() < 1) {
				return false;
			}
		} else if (dotPos != -1 && ePos != -1) {
			if (dotPos >= ePos) {
				return false;
			}
			startStr = s.substring(0, dotPos);
			midStr = s.substring(dotPos+1, ePos);
			if (startStr.length() < 1 && midStr.length() < 1) {
				return false;
			}
			endStr = s.substring(ePos+1);
			if (endStr.startsWith("-") || endStr.startsWith("+")) {
				endStr = endStr.substring(1);
			}
			if (endStr.length() < 1) {
				return false;
			}
		}
		return true;
	}
}