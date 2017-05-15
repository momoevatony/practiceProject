package facebook;

public class PowXN {
	
	//accepted 5.14.2017 20413ms
	public double myPow(double x, int n) {
        // Write your code here
        if (x == 0) {
            return 0;
        }
        
        if (n == 0) {
            return 1;
        }
        
        if (n == 1) {
            return x;
        }
        
        boolean isNeg = false;
        if (n < 0) {
            isNeg = true;
            n = 0 - n;
        }
        
        int k = n / 2;
        int l = n - k * 2;
        
        double t1 = myPow(x, k);
        double t2 = myPow(x, l);
        
        if (isNeg) {
            return 1 / (t1 * t1 * t2);
        } else {
            return t1 * t1 * t2;
        }
    }
}
