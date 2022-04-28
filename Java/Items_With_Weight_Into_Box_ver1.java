import java.util.*;

class itemsWithWeightIntoBox {
	public static int getMaxItems(int[] weights) {
		HashMap<Integer, Integer> grams = new HashMap<>();

		int capacityLeft = 5000 - weights[0];
		Arrays.sort(weights);

		int max = 0;

		for (int i = 0; i < weights.length - 1; i++) {
			if (weights[i] < capacityLeft) {
				max++;
				capacityLeft = capacityLeft - weights[i];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[] input = new int[]{4850, 100, 30, 30, 100, 50, 100};

		System.out.println(getMaxItems(input));
	}
}
