/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
	public int majorityElement(int[] num) {
		int element = num[0], temp = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(element, 1);
        for (int i = 1; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                temp = map.get(num[i]) + 1;
            } else {
                temp = 1;
            }
            if (temp > num.length / 2) {
                return num[i];
            } else {
                map.put(num[i], temp);
            }
        }
        return element;
	}

	public int majorityElement(int[] num) {
		int maj=0;
        int count = 0;
        int n = num.length;
        for (int i = 0; i < n; i++){
            if (count == 0){
                maj = num[i];
                count++;
            }
            else if (num[i] == maj){
                count++;
                if (count > n/2) return maj;
            }
            else count--;
        }
        return maj;
	}
}