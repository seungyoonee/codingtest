import java.util.*;
public class ReverseString {
    
    public static void reverse(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(s); // olleh
        System.out.println(Arrays.toString(s)); // [o, l, l, e, h]
    }

    public static void main(String args[]) {
        char[] test1 = new char[] {'h', 'e', 'l', 'l', 'o'};
        reverse(test1);
    }
}
