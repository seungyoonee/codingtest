import java.util.*;
// O(n) time | O(n) space
// using hash map
class Fibonacci2 {
	public int fib(int n) {
		Map<Integer, Integer> memoize = new HashMap<Integer, Integer>();
		memoize.put(1, 0);
		memoize.put(2, 1);
		return fib(n, memoize);
	}

	public static int fib(int n, Map<Integer, Integer> memoize) {
		if (memoize.containsKey(n)) {
			return memoize.get(n);
		} else {
			memoize.put(n, fib(n - 1, memoize) + fib(n - 2, memoize));
			return memoize.get(n);
		}
	}

	public static void main(String arg[]) {
		Fibonacci2 test = new Fibonacci2();
 
		System.out.print("fib(6): ");
      	System.out.println(test.fib(6));
		System.out.print("fib(15): ");
		System.out.println(test.fib(15));
		System.out.print("fib(47): ");
		System.out.println(test.fib(47));
	}
}

