import java.util.*;

public class integerToRoman {

	public static String convert(int num) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

		int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String result = "";

		while (num > 0) {
			int i;
			for (i = 0; i < arr.length; i++) {
				if (arr[i] > num) {
					continue;
				}
				else {
					break;
				}
			}
				result += map.get(arr[i]);
				num -= arr[i];
		}

		return result;
	}

	public static void main(String args[]) {
		System.out.println(convert(3));
		System.out.println(convert(58));
		System.out.println(convert(1994));
	}
}
