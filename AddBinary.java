
public class AddBinary {
    
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0'; // - '0' to get int value of the char from ascii
            if (j >= 0) sum += b.charAt(j--) - '0'; // j--: j - 1 after j
            sb.append(sum % 2); // if first sum = 0 + 1 = 1 => 1 % 2 = 1;
            carry = sum / 2; // if 1 + 1, sum = 2 => 2 / 2 = 1 (carry)
        }

        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        String a1 = "11";
        String a2 = "1";
        String b1 = "1010";
        String b2 = "1011";

        System.out.println(addBinary(a1, a2)); // 11 + 1 = 100
        System.out.println(addBinary(b1, b2)); // 1010 + 1011 = 10101
    }
}
