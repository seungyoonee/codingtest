import java.util.*;

public class ReorganizeString {
    public static String reorganizeString(String s) {
        // put all the characters into a hashmap
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // put all the characters into a maxheap
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        System.out.println(maxHeap);

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            char curr = maxHeap.remove();
            char next = maxHeap.remove();
            System.out.println(curr);
            System.out.println(next);
            sb.append(curr);
            sb.append(next);

            map.put(curr, map.get(curr) - 1);
            map.put(next, map.get(next) - 1);

            if (map.get(curr) > 0) {
                maxHeap.add(curr);
            }
            if (map.get(next) > 0) {
                maxHeap.add(next);
            }
        }
        
        if (!maxHeap.isEmpty()) {
            char leftOver = maxHeap.remove();
            if (map.get(leftOver) > 1) {
                return "";
            }
            sb.append(leftOver);
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String test1 = "aab";
        String test2 = "aaaaabbbb";
        String test3 = "aaabc";
        String test4 = "aaaaabbbc";
        String test5 = "aaab";

        System.out.println(reorganizeString(test1));
        System.out.println(reorganizeString(test2));
        System.out.println(reorganizeString(test3));
        System.out.println(reorganizeString(test4));
        System.out.println(reorganizeString(test5));
    }
}
