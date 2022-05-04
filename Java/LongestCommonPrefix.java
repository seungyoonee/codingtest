import java.util.*;

public class LongestCommonPrefix {

    public static String commonPrefix(String[] str) {

        if (str.length == 0 || str == null) return "";

        Arrays.sort(str);
        String str1 = str[0];
        String str2 = str[str.length - 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            }
            else {
                return sb.toString();
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String[] test1 = new String[] {"d", "c", "b", "a"};
        String[] test2 = new String[] {"flower", "flow", "flat", "flight"};
        String[] test3 = new String[] {"dog", "cat", "base", "apple"};
        String[] test4 = new String[] {"hallow", "hat", "hall", "happy"};

        System.out.println(commonPrefix(test1)); // ""
        System.out.println(commonPrefix(test2)); // fl
        System.out.println(commonPrefix(test3)); // ""
        System.out.println(commonPrefix(test4)); // ha

    }
}