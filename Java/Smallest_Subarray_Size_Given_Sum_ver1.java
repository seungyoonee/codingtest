public class SmallestSubarraySizeGivenSum {
	
	public static int smallestSubarraySize(int targetSum, int[] arr) {
		int minWindowSize = Integer.MAX_VALUE;
		int windowStart = 0;
		int currentWindowSum = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			currentWindowSum += arr[windowEnd];
			while (currentWindowSum >= targetSum) {
				minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
				// shrink window size from left
				currentWindowSum -= arr[windowStart];
				windowStart++;
			}
		}
		return minWindowSize;
	}

	public static void main(String[] args) {
		int[] input = new int[] {3,7,6,3,1,8,5,3,8,4};
		int targetSum = 8;
		System.out.println(smallestSubarraySize(targetSum, input));
	}
}
