public class Solution86 {
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

        return num;
    }
    public static void main(String ...args) {
        Solution86 s = new Solution86();
        System.out.println(s.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}