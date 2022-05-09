public class ClimbStairs {
    
    public static int climbStairs(int n) {

        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int stair1 = 1;
        int stair2 = 2;
        int result = 0;

		for (int i = 3; i <= n; i++) {
			result = stair1 + stair2;
            stair1 = stair2;
            stair2 = result;
		}

		return result;
    }

    public static void main(String args[]) {
        int test1 = 45; // 1836311903
        int test2 = 2; // 2
        int test3 = 3; // 3
        int test4 = 4; // 5
        int test5 = 5; // 8
        int test6 = 1; // 1

        System.out.println(climbStairs(test1));
        System.out.println(climbStairs(test2));
        System.out.println(climbStairs(test3));
        System.out.println(climbStairs(test4));
        System.out.println(climbStairs(test5));
        System.out.println(climbStairs(test6));
    }
}
