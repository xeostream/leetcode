/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arthur
 */
public class Solution43 {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int i = 0;
        int begin = 0;
        while (i < s.length()) {
            if (!s.substring(begin, i).contains(s.charAt(i)+"")) {
                i++;
                if (len < i-begin)
                    len = i - begin;
            }
            else {
                begin += (s.substring(begin, i).indexOf(s.charAt(i)+"")+1);
                i++;
            }
        }
        return len;
    }
    
    public static void main(String ...args) {
        Solution43 s43 = new Solution43();
        System.out.println(s43.lengthOfLongestSubstring(""));
    }
}
