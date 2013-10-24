/*
 * Remove Element
 * Given an array and a value 
 * remove all instances of that value
 * return the new length.
 */
public class Solution21 {
	//begin pointer,if work with end pointer, the time complexity is exactly O(n)
	public int removeElement(int[] A, int elem) {
		int length = A.length;
		int i = 0;
		while (i < length) {
			if (A[i] == elem) {
				swap(A, i, length-1);
				length--;
				continue;
			}
			i++;
		}
		return length;
	}
	
	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String ...args) {
		Solution21 s21 = new Solution21();
		int[] A = {2};
		System.out.println(s21.removeElement(A, 1));
	}
}
