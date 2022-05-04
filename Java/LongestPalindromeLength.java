public class LongestPalindromeLength {

    public static String palindromeLength(String s) {
        if (s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i); // odd length of string e.g. abcba
            int len2 = expandFromMiddle(s, i, i + 1); // even length of string e.g. abba
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - ((len - 1) / 2); // if i = 2, len = 5, substring(3, 8) -> 2 - ((5 - 1) / 2) = 2 - (2) = 0
                end = i + (len / 2); // 2 + (5 / 2) = 2 + 2 = 4
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String args[]) {
        String test1 = "babad";
        String test2 = "";
        String test3 = "cbbd";
        String test4 = "a";
        String test5 = "racecar";
        String test6 = "aaabbbbaaa";
        String test7 = "abcdefgfedcb";

        System.out.println(palindromeLength(test1));
        System.out.println(palindromeLength(test2));
        System.out.println(palindromeLength(test3));
        System.out.println(palindromeLength(test4));
        System.out.println(palindromeLength(test5));
        System.out.println(palindromeLength(test6));
        System.out.println(palindromeLength(test7));
    }
}