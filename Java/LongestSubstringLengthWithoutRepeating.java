import java.util.*;
// using HashMap / Sliding Window Algorithm
public class LongestSubstringLengthWithoutRepeating {
	
	public static int longestSubstringLength(String s) {
		int maxLength = 0;
		int windowStart = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			while (map.containsKey(s.charAt(windowEnd))) {
				map. remove(s.charAt(windowStart));
				windowStart++;
			}
			map.put(s.charAt(windowEnd), 0);
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String input = "abcabcbb";
		System.out.println(longestSubstringLength(input));
	}
}

