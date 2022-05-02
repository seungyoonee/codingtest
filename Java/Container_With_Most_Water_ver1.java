import java.util.*;

public class Container_With_Most_Water_ver1 {
    
    public static int calculateArea(int[] height) {

        if (height.length < 2) return 0;
        if (height.length == 2) return Math.min(height[0], height[1]);

        int left =  0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) { // > {0, 0, 0, 0} <
            int area;
            if (height[left] < height[right]) {
                area = height[left] * (right - left); // shorter height * distance
                maxArea = Math.max(area, maxArea);
                left++; // ignore the shorter height
            }
            else {
                area = height[right] * (right - left); // shorter height * distance
                maxArea = Math.max(area, maxArea);
                right--; // ignore the shorte height
            }
        }

        return maxArea;
    }

    public static void main(String args[]) {
        int[] test1 = new int[] {6,23,3,1,46,7,534,2,8}; // 115
        int[] test2 = new int[] {1,8,6,2,5,4,8,3,7}; // 49
        int[] test3 = new int[] {1,1}; // 1
        int[] test4 = new int[] {1,6,43,7,2,2,6,5,43,8,63,654,7,3,8}; // 387
        int[] test5 = new int[] {1,62,7,257,4357,35,6724,5624,7,578468,4675,735,63,624,672,72}; // 26142

        System.out.println(calculateArea(test1)); // 115
        System.out.println(calculateArea(test2)); // 49
        System.out.println(calculateArea(test3)); // 1
        System.out.println(calculateArea(test4)); // 387
        System.out.println(calculateArea(test5)); // 26142
    }
}