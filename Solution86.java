public class Solution86 {
    //Solution I
    public int removeDuplicates(int[] A) {
        if (null == A) return 0;
        if (A.length < 2) return A.length;
        int num = 1, temp = A[1];
        for (int i =2; i < A.length; i++) {
            if (A[i] != A[i-2]) {
                A[num++] = temp;
                temp = A[i];
            }
        }
        A[num++] = temp;
        return num;
    }
    //Solution II
    public int remvoeDuplicates(int[] A) {
        int len = A.length;
        if (len < 2) return len;
        int index = 2;
        for (int i = 2; i < len; i++) {
            if (A[i] != A[i-2])
                A[index++] = A[i];
        }
        return index;
    }
    public static void main(String ...args) {
        Solution86 s = new Solution86();
        System.out.println(s.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}