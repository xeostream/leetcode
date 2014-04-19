/*Word Search
Given a 2D board and a word,find if the word exists in the grid.
The word can be constructed from letters of swquentially adjacent cell, where
"adjacent" cells are those horizontally or vertically neighboring.The same letter
cell may not be used morethan once.
For example,
Given board = 
			[
				["ABCE"],
				["SFCS"],
				["ADEE"]
			]
word = "ABCCED", returns true,
word = "SEE", returns true,
word = "ABCB", returns false.
*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (null == board || null == word) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    board[i][j] = ' ';
                    String w = word.substring(1);
                    if (exist(board, w, i - 1, j) || exist(board, w, i + 1, j) || exist(board, w, i, j - 1) || exist(board, w, i, j + 1))
                        return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int x, int y) {
        if ("".equals(word)) return true;
        if (0 <= x && board.length > x && 0 <= y && board[x].length > y) {
            if (word.charAt(0) == board[x][y]) {
                board[x][y] = ' ';
                String w = word.substring(1);
                if (exist(board, w, x - 1, y))
                    return true;
                if (exist(board, w, x + 1, y))
                    return true;
                if (exist(board, w, x, y - 1))
                    return true;
                if (exist(board, w, x, y + 1))
                    return true;
                board[x][y] = word.charAt(0);
            }
        }
        return false;
    }
    public static void main(String ...args) {
        Solution s = new Solution();
        System.out.println(s.exist(new char[][]{new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}}, "ABCE"));
    }
}