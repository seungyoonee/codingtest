/*
Given two integers ‘n’ and ‘m’,
find all the stepping numbers in range [n, m].
A number is called stepping number
if all adjacent digits have an absolute difference of 1.
321 is a Stepping Number while 421 is not.
*/

public class SteppingNumbers {
    // takes one integer at a time
    // and decide whether it is a stepping number.
    public static boolean isSteppingNumber(int n) {

        int prevDigit = -1;

        while (n > 0) {
            // 1) n = 321, curDigit = 1
            // 2) n = 32,  curDigit = 2
            // 3) n = 3,   curDigit = 3
            int curDigit = n % 10;

            if (prevDigit != -1) {
                if (Math.abs(curDigit - prevDigit) != 1) {
                    return false;
                }
            }

            // if n = 321, n = 32 => n = 3
            n /= 10;
            // 1) prevDigit = 1
            // 2) prevDigit = 2
            // 3) prevDigit = 3
            prevDigit = curDigit;
        }
        return true;
    }

    public static void printSteppingNumbers(int n, int m) {

        for (int i = n; i <= m; i++) {
            if (isSteppingNumber(i)) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }

    public static void main(String args[]) {
        int n = 0, m = 21;

        printSteppingNumbers(n, m);

        n = 300;
        m = 400;

        printSteppingNumbers(n, m);
    }

}
