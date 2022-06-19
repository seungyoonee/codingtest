import java.util.*;

public class PlusOne {
    
    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1]; // [0, 0, ..., 0];
        newDigits[0] = 1;

        return newDigits;
    }
    
    public static void main(String args[]) {
        int[] test1 = {1, 2, 4};
        int[] test2 = {9};
        int[] test3 = {3, 8, 9, 9};
        int[] test4 = {9, 9, 9, 9};

        System.out.println(Arrays.toString(plusOne(test1)));
        System.out.println(Arrays.toString(plusOne(test2)));
        System.out.println(Arrays.toString(plusOne(test3)));
        System.out.println(Arrays.toString(plusOne(test4)));
    }
}
