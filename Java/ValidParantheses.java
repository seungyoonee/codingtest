import java.util.*;

public class ValidParantheses {

    public static boolean checkParantheses(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (st.isEmpty() || st.pop() != map.get(c)) {
                    return false;
                }
            }
            else {
                st.push(c);
            }
        }

        return st.isEmpty();
    }

    public static void main(String args[]) {
        String test1 = "{([])}"; // true
        String test2 = "]"; // false
        String test3 = "]{"; // false
        String test4 = "{}()[]}"; // false
        String test5 = "{{{}}"; // false
        String test6 = "(){[[]]}(){}"; // true

        System.out.println(checkParantheses(test1));
        System.out.println(checkParantheses(test2));
        System.out.println(checkParantheses(test3));
        System.out.println(checkParantheses(test4));
        System.out.println(checkParantheses(test5));
        System.out.println(checkParantheses(test6));
    }
}