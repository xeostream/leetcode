/*
Implement pow(x, n)
*/

public class Solution {
	public double pow(double x, int n) {
		/*double half = pow(x, n / 2);
	    if (n % 2 == 0)
	        return half * half;
	    else if (n > 0)
	        return half * half * x;
	    else
	        return half * half / x;*/
	    double ans = 1;
        double tmp = x;
        boolean neg = false;
        long m = n;
        if (m < 0) {
            neg = true;
            m = -m;
        }
        long bound = m;
         
        while (bound != 0) {
            long i = 1;
            for (; i*2 <= bound; i*=2) {
                tmp = tmp * tmp;
            }
            ans *= tmp;
            tmp = x;
            bound = bound - i;
        }
         
        if (neg) return 1.0 / ans;
         
        return ans;
	}
}