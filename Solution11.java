/*
 * Add Binary
 * a = "11"
 * b = "1"
 * result = "100"
 */
public class Solution11 {
	public String addBinary(String a, String b) {
		int[] result = new int[a.length()+b.length()];
		for (int i = 0; i < a.length(); i++)
			result[i] = a.charAt(a.length()-i-1)-'0';
		for (int i = 0; i < b.length(); i++)
			result[i] += (b.charAt(b.length()-i-1)-'0');
		for (int i = 0; i < result.length; i++)
			if (result[i] >= 2) {
				result[i] -= 2;
				result[i+1] += 1;
			}
		String str = "";
		for (int i : result)
			System.out.print(i+" ");
		for (int i = result.length; i > 0; i--)
			if (result[i-1] == 1) {
				for (int j = i-1; j >= 0; j--)
					str += result[j];
				return str;
			}
		return "0";
	}
	public static void main(String ...args) {
		Solution11 s11 = new Solution11();
		System.out.println(s11.addBinary("1111", "1111"));
	}
	
	
}
