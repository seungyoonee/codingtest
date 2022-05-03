// O(n) time | O(1) space
// using iterative algorithm
public class Fibonacci3 {

	public static int fib(int n) {
		int[] lastTwo = {0, 1};
		int counter = 3;
		while (counter <= n) {
			int nextFib = lastTwo[0] + lastTwo[1];
			lastTwo[0] = lastTwo[1];
			lastTwo[1] = nextFib;
			counter++;
		}
		return n > 1 ? lastTwo[1] : lastTwo[0];
	}

	public static void main(String args[]) {
		Fibonacci3 test = new Fibonacci3();

		System.out.print("fib(6): ");
		System.out.println(test.fib(6));
		System.out.print("fib(15): ");
		System.out.println(test.fib(15));
		System.out.print("fib(47): ");
		System.out.println(test.fib(47));
	}
}
