/*
 * Search in Rotated Sorted Array II 
 */
public class Solution85 {
    public boolean search(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target)
                return true;
        }
        return false;
    }
}