import java.util.*;

public class romanToInteger {
	
	public static int convert(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

		int result = 0;
		int prev = 0;

		for (char c : s.toCharArray()) {
			int cur = map.get(c);
			if (cur > prev) {
				result -= prev;
				result += cur - prev;
			}
			else {
				result += cur;
			}
			prev = cur;
		}
		
		return result;
	}

	public static void main(String args[]) {
		System.out.println(convert("III"));
		System.out.println(convert("LVIII"));
		System.out.println(convert("MCMXCIV"));
	}
}
