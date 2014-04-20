/*
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
*/
public class Solution82 {
    public String reverseWords(String s) {
        String[] strs = s.split("\\s{1,}");
        StringBuffer sb = new StringBuffer();
        StringBuffer temp = null;
        for (String str : strs) {
            temp = new StringBuffer(str);
            temp = temp.reverse();
            sb.append(temp.toString()+" ");
        }
        return sb.reverse().toString().trim();
    }
}