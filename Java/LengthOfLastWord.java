public class lengthOfLastWord {

	public static int getLength(String s) {
		int length = 0;
		int idx = s.length() - 1;

		while (idx >= 0 && s.charAt(idx) == ' ') {
			idx--;
		}

		while (idx >= 0 && s.charAt(idx) != ' ') {
			idx--;
			length++;
		}
		
		return length;
	}

	public static void main(String[] s) {
		String input = "   fly  me    to  the   moon    ";
		System.out.println(getLength(input));
	}
}
