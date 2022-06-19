import java.util.*;
// using HashMap / Sliding Window Algorithm
public class LongestSubstringLengthKDistinctCharacters {

	public static int longestSubstringLength(char[] arr, int k) {
		int maxLength = Integer.MIN_VALUE;
		int windowStart = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			if (map.containsKey(arr[windowEnd]))
				map.replace(arr[windowEnd], map.get(arr[windowEnd]) + 1);
			else 
				map.put(arr[windowEnd], 1);	
			
			while (map.size() > k) {
				map.replace(arr[windowStart], map.get(arr[windowStart]) - 1);
				if (map.get(arr[windowStart]) == 0)
					map.remove(arr[windowStart]);
				windowStart++;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		char[] input = new char[] {'A','A','A','H','H','I','B','C'};
		int k = 2;
		System.out.println(longestSubstringLength(input, k));
	}
}
