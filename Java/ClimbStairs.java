import java.util.*;

public class ClimbStairs {
    
    public static int climbStairs(int n) {

        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

		for (int i = 2; i < n; i++) {
			all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
		}

		return all_ways;
    }

    public static void main(String args[]) {
        int test1 = 45;
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
