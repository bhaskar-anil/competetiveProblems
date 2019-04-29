package interviewbit;

public class ImplementPowerFunction {
	
	static int pow(int x, int n, int d) {
		long m = recPow(x, n);
		return m < 0 ? (int) (m%d)+d : (int) (m%d);      
    }

	private static long recPow(long x, long n) {
		if(n == 0) {
			return 1;
		}
		return x*recPow(x, n-1);
	}

	public static void main(String[] args) {
		System.out.println(pow(200, 200, 64735492));
	}

}

/*
cpp sol

int Solution::pow(int x, int n, int p) 
{
    if (n == 0) 
        return 1 % p;

    long long ans = 1, base = x;
    while (n > 0) 
    {
        if (n % 2 == 1)
        {
            ans = (ans * base) % p;
            n--;
        } 
        else
        {
            base = (base * base) % p;
            n /= 2;
        }
    }
    if (ans < 0) 
        ans = (ans + p) % p;
    return ans;
}

*/
