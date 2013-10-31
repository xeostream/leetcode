import java.util.HashSet;

/*
 * Longest Consecutive Sequence
 * Given an unsorted array of integers 
 * find the length of the longest consecutive elements sequence
 * Given [100, 4, 200, 1, 3, 2], return 4
 */
public class Solution37 {
	public int longestConsecutive(int[] num) {
		int length = 1;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : num)
			set.add(i);
		for (int i : num)
			if (set.contains(i) && set.size() > length)
				length = Math.max(length, longestConsecutive(set, i));
		return length;
	}

	public int longestConsecutive(HashSet<Integer> set, int i) {
		int max = 1;
		for (int j = i - 1;; j--) {
			if (set.contains(j)) {
				max++;
				set.remove(j);
			} else
				break;
		}
		for (int j = i + 1;; j++) {
			if (set.contains(j)) {
				max++;
				set.remove(j);
			} else
				break;
		}
		return max;
	}

	public static void main(String... args) {
		Solution37 s37 = new Solution37();
		int[] num = { 100, 4, 200, 1, 3, 2 };
		System.out.println(s37.longestConsecutive(num));
	}
}
