public class Fibonacci {
    Integer[] memoization = null;
    int count = 0;

    public Fibonacci(int n) {
        memoization = new Integer[n+1];
    }

    // Top down - recursive approach
    public int Fib(int n) {
        count++;
        if(memoization != null && memoization[n] != null) {
            return memoization[n];
        }

        if(n == 0 || n == 1) return n;

        memoization [n] = Fib(n-1) + Fib (n-2);

        return memoization[n];
    }

    // Bottom up - recursive approach
    public int Fib1(int n) {
        memoization = new Integer[n+1];
        
        memoization[0] = 0;
        memoization[1] = 1;

        for(int i = 2; i < n+1; i++) {
            count++;
            memoization [i] = memoization[i-1] + memoization[i-2];
        }

        return memoization[n];
    }

    public int getCount() {
        return count;
    }

    public void resetCount() {
        count = 0;
    }
    
    public static void main(String[] args) {
        
        Fibonacci t = new Fibonacci(40);
        System.out.println(t.Fib(40));
        System.out.println(t.getCount());
        t.resetCount();
        System.out.println(t.Fib1(40));
        System.out.println(t.getCount());
    }
}
