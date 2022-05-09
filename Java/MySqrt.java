public class MySqrt {
    
    public static int mySqrt(int x) {

        if (x == 0) return 0;

        int start = 1;
        int end = x;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == x / mid) {
                return mid;
            }
            else if (mid < x / mid) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return end;
    }

    public static void main(String args[]) {
        int test1 = 2147483647;
        int test2 = 0; // 0
        int test3 = 1; // 1
        int test4 = 2; // 1
        int test5 = 4; // 2
        int test6 = 8; // 2

        System.out.println(mySqrt(test1));
        System.out.println(mySqrt(test2));
        System.out.println(mySqrt(test3));
        System.out.println(mySqrt(test4));
        System.out.println(mySqrt(test5));
        System.out.println(mySqrt(test6));
    }
}
