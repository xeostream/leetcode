/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public String simplifyPath(String path) {
        String[] list = path.split("/+");
        Pattern pattern = Pattern.compile("\\.{0,2}");
        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if ("..".equals(list[i])) {
                index = i;
                while (index > 0) {
                    Matcher mat = pattern.matcher(list[index-1]);
                    if (!mat.matches()) {
                        list[index-1] = "";
                        break;
                    }
                    index--;
                }
            }
        }
        String result = "";
        for (String str : list) {
            Matcher matcher = pattern.matcher(str);
            if (!"".equals(str) && !matcher.matches()) {
                result += ("/"+str);
            }
        }
        return "".equals(result) ? "/" : result;
    }
    
    public static void main(String ...args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }
}