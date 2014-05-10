/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
*/
public class Solution {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> ret = new ArrayList<String>();
		int wordsLen = words.length;
		int curWordIdx = 0;
		while (curWordIdx < wordsLen) {
			int charLen = 0;
			int probeWordIdx = curWordIdx;
			while (probeWordIdx < wordsLen && charLen+words[probeWordIdx].length() <= L) {
				charLen += (words[probeWordIdx++].length() + 1);
			}
			if (probeWordIdx-curWordIdx == 1) {
				String tmp = words[curWordIdx];
				tmp = addSpace(tmp, L-words[curWordIdx].length());
				ret.add(tmp);
				curWordIdx = probeWordIdx;
				continue;
			}
			int wordCharLen = charLen - (probeWordIdx - curWordIdx);
			int meanSpace = probeWordIdx < wordsLen ? (L-wordCharLen) / (probeWordIdx-curWordIdx-1) : 1;
			int leftSpace = probeWordIdx < wordsLen ? (L-wordCharLen) % (probeWordIdx-curWordIdx-1) : L-wordCharLen-(probeWordIdx-curWordIdx-1);
			String tmp = new String();
			for (int i = curWordIdx; i < probeWordIdx-1; i++) {
				tmp += words[i];
				tmp = addSpace(tmp, meanSpace);
				if (probeWordIdx < wordsLen && leftSpace > 0) {
					tmp += " ";
					leftSpace--;
				}
			}
			tmp += words[probeWordIdx-1];
			if (leftSpace > 0) {
				tmp = addSpace(tmp, leftSpace);
			}
			ret.add(tmp);
			curWordIdx = probeWordIdx;
		}
		return ret;
	}
	public static String addSpace(String tmp, int size) {
		for (int i = 0; i < size; i++)
			tmp += " ";
		return tmp;
	}
}