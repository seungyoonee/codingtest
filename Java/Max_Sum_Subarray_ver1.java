// using Sliding Window Algorithm
public class MaxSumSubarray {
	public static int findMaxSumSubarray(int[] arr, int k) {
		int maxValue = Integer.MIN_VALUE;
		int currentRunningSum = 0;

		for (int i = 0; i < arr.length; i++) {
			currentRunningSum += arr[i];
			if (i >= k - 1) {
				maxValue = Math.max(maxValue, currentRunningSum);
				currentRunningSum -= arr[i - (k - 1)];
			}
		}
		return maxValue;
	}

	public static void main(String[] args) {
		System.out.println(findMaxSumSubarray(new int[] {4, 2, 1, 6, 3, 7, 9, 3, 6}, 3));
	}
}
