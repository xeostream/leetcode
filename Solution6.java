/*
 * Jump Game II
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Solution6 {
	/*dp time too long 
	public int jump(int[] A) {
		int[] jumps = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			jumps[i] = i;
			for (int j = 0; j < i; j++) {
				if (j+A[j] >= i && jumps[j]+1 < jumps[i])
					jumps[i] = jumps[j] + 1;
			}
		}
		return jumps[A.length-1];
	}*/
	public int jump(int[] A) {
		int temp = 0, max = 0, jumps = 0;
		for (int i = 0; i < A.length;) {
			if (temp >= A.length-1) break;
			while (i <= temp) {
				if (i+A[i] > max)
					max = i+A[i];
				i++;
			}
			temp = max;
			jumps++;
		}
		return jumps;
	}
	
	public static void main(String ...args) {
		int[] A = {2,3,1,1,4};
		Solution6 s6 = new Solution6();
		System.out.println(s6.jump(A));
 	}
}
