// O(n) time | O(1) space
// using iterative algorithm
public class Fibonacci3 {

	public int fib(int n) {
		/*
		int[] lastTwo = {0, 1};
		int counter = 3;
		while (counter <= n) {
			int nextFib = lastTwo[0] + lastTwo[1];
			lastTwo[0] = lastTwo[1];
			lastTwo[1] = nextFib;
			counter++;
		}
		return n > 1 ? lastTwo[1] : lastTwo[0];
		*/
		if (n <= 0) return 0;
		if (n == 1) return 0;
		if (n == 2) return 1;

		int fib1 = 0;
		int fib2 = 1;
		int fib_num = 0;

		for (int i = 3; i <= n; i++) {
			fib_num = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib_num;
		}

		return fib_num;
	}

	public static void main(String args[]) {
		Fibonacci3 test = new Fibonacci3();

		System.out.println("fib(1): " + test.fib(1));
		System.out.println("fib(2): " + test.fib(2));
		System.out.println("fib(3): " + test.fib(3));
		System.out.println("fib(4): " + test.fib(4));
		System.out.println("fib(5): " + test.fib(5));
		System.out.print("fib(6): ");
		System.out.println(test.fib(6));
		System.out.print("fib(15): ");
		System.out.println(test.fib(15));
		System.out.print("fib(47): ");
		System.out.println(test.fib(47));
	}
}
