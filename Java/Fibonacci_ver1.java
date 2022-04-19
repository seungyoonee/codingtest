import java.util.*;
// O(2^n) time | O(n) space
// using brute force
class Fibonacci {
	public static int fib(int n) {
		if (n == 1) // fib(1) = 0
			return 0;
		else if (n == 2) // fib(2) = 1
			return 1;
		else // fib(3) = fib(1) + fib(2)
			return fib(n - 1) + fib(n - 2);
	}
	public static void main(String args []) {
		Fibonacci test = new Fibonacci();

		System.out.print("fib(6): ");
		System.out.println(test.fib(6));
		System.out.print("fib(15): ");
		System.out.println(test.fib(15));
		System.out.print("fib(47): ");
		System.out.println(test.fib(47));
	}
}

