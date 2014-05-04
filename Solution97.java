public class Solution {
	// 二分法
	public int sqrt(int x) {
		int i = x / 2;
		while (i * i != x) {
			if (i * i > x) {
				i = i / 2;
			} else {
				i = (i + i / 2) / 2;
			}
		}
		return i;
	}
	// 牛顿迭代法
	public int sqrt(int x) {
		if (x < 2) return x;
        double last = 0, res = 1;
        while (res != last) {
            last = res;
            res = (res + x/res) / 2;
        }
        return (int)res;
	}
}