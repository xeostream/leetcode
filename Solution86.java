public class Solution86 {
    public int removeDuplicates(int[] A) {
        if (null == A) return 0;
        if (A.length < 2) return A.length;
        int cnt = 0;
        int[] B = new int[A.length + 2];
        B[A.length] = Integer.MAX_VALUE, B[A.length + 1] = Integer.MAX_VALUE;
        System.arraycopy(A, 0, B, 0, A.length);
        boolean key = false;
        for (int i = 0; i < A.length; i++) {
            if (B[i] != B[i + 2])
                cnt++;
        }
        /*Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : A) {
            if (!map.containsKey(i)) {
                cnt++;
                map.put(i, 1);
            } else if (map.get(i) == 1) {
                cnt++;
                map.put(i, 2);
            }
        }*/

        return cnt;
    }
    public static void main(String ...args) {
        Solution86 s = new Solution86();
        System.out.println(s.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}