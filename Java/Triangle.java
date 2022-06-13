import java.util.*;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] result = new int[triangle.size() + 1]; // 4
        
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> tmp = triangle.get(i);
            // [4, 1, 8, 3]
            // [6, 5, 7]
            // [3, 4]
            // [2]
            for (int j = 0; j < tmp.size(); j++) {
                result[j] = Math.min(result[j], result[j+1]) + tmp.get(j);
                // [0] = 4, [1] = 1, [2] = 8, [3] = 3
                // [0] = 1 + 6, [1] = 1 + 5, [2] = 3 + 7
                // [0] = 6 + 3, [1] = 6 + 4
                // [0] = 9 + 2
            }
        }
        return result[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(0, new ArrayList<Integer>());
        triangle.add(1, new ArrayList<Integer>());
        triangle.add(2, new ArrayList<Integer>());
        triangle.add(3, new ArrayList<Integer>());
        triangle.get(0).add(2);
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);

        System.out.println(triangle);
        System.out.println(minimumTotal(triangle));
    }
}
