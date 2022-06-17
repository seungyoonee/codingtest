/*
Boggle Game word checker:
Given 2D matrix of characters, check whether an input word exist in the matrix by going up, down, left, and right.
Follow-up questions:
what if we want to allow diagonal traversal?
what if we have an array of words to check?

input:
[[q, u, w, t, a, x, h, j, v, m]
 [y, e, d, b, a, n, a, n, a, f]
 [o, q, w, e, t, f, s, x, c, g]
 [q, w, w, a, p, p, l, e, w, w]
 [o, q, w, p, p, f, s, x, c, g]
 [o, q, w, p, t, p, s, x, c, g]
 [o, q, w, l, t, f, l, x, c, g]
 [o, e, l, e, p, h, a, n, t, g]
 [o, q, w, e, t, f, s, x, c, g]
 [o, q, w, e, t, f, s, x, c, g]]

Make horizontal and vetical chars into a String
Check if the String contains the word
*/

public class BoggleGameWordChecker {

    public static boolean exist(char[][] input, String[] words) {

        StringBuilder sb = new StringBuilder();

        // check horizontal
        for (int i = 0; i < input.length; i++) {

            //StringBuilder sb = new StringBuilder();

            for (char c : input[i]) {
                sb.append(c);
            }

/*            if (sb.toString().contains(word)) {
                return true;
            }*/
        }
        System.out.println();
        // check vertical
        for (int i = 0; i < input.length; i++) {

            //StringBuilder sb = new StringBuilder();

            for (int j = 0; j < input.length; j++) {
                sb.append(input[j][i]);
            }
/*
            if (sb.toString().contains(word)) {
                return true;
            }*/
        }

        int length = input.length;
        int diagonalLines = (input.length * 2) - 1; // 19
        int midPoint = (diagonalLines / 2) + 1; // 10
        int numOfDiag = 0;

        // \ diagonal 
        // [9][0] -> [8][0] -> [9][1] -> [7][0] -> [8][1] -> [9][2]
        for (int i = 0; i < diagonalLines; i++) {

            // StringBuilder sb = new StringBuilder();            
            int row, col;
            
            if (i < midPoint) { // 0, 1, ..., 9
                numOfDiag++; // 1, 2, ..., 9
                row = length - i - 2; // 9, 8, ..., -1
                for (int j = 0; j < numOfDiag; j++) {
                    row++; // 9 -> 8, 9 -> 7, 8, 9 -> ... -> 0, 1, ..., 9
                    col = j;
                    sb.append(input[row][col]);
                }
            }
            else { // 10, 11, ..., 18
                numOfDiag--;
                row = -1;
                col = i - length;
                for (int j = 0; j < numOfDiag; j++) { // 
                    // j < 10 -> 0, 1, ..., 9
                    row++; // 0, 1, ..., 9 -> 0, 1, ..., 8 -> 0, 1, ..., 7 -> 0
                    col++; // 
                    sb.append(input[row][col]);
                }
            }
            /*
            if (sb.toString().contains(word)) {
                return true;
            }
            */
        }

        numOfDiag = 0;
        // \ diagonal
        // [0, 0] -> [1, 0], [0, 1] -> [2, 0], [1, 1], [0, 2] -> ... -> [0, 0], [1, 1], ..., [9, 9] -> [1, 0], [2, 1], ... -> [9, 0]
        for (int i = 0; i < diagonalLines; i++) {

            //StringBuilder sb = new StringBuilder();
            int row, col;

            if (i < midPoint) {
                numOfDiag++;
                row = i + 1;
                for (int j = 0; j < numOfDiag; j++) {
                    row--;
                    col = j;
                    sb.append(input[row][col]);
                }
            }
            else {
                numOfDiag--;
                row = length;
                col = length - numOfDiag - 1;
                for (int j = 0; j < numOfDiag; j++) {
                    row--;
                    col++;
                    sb.append(input[row][col]);
                }
            }

            /*if (sb.toString().contains(word)) {
                return true;
            }*/
        }
        
        for (String s : words) {
            if (sb.toString().contains(s)) {
                System.out.println(s + " exists");
            }
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] input = 
        // 0    1    2    3    4    5    6    7    8    9
        {{'1', '2', '3', '4', '5', 'h', '7', '8', '9', '0'}, // 0
         {'1', '2', '3', '4', '5', '6', 'e', '8', '9', '0'}, // 1
         {'1', '2', '3', '4', '5', '6', '7', 'l', '9', '0'}, // 2
         {'1', '2', 'b', 'a', 'n', 'a', 'n', 'a', 'l', '0'}, // 3
         {'1', '2', '3', 'p', '5', '6', 'n', '8', '9', 'o'}, // 4
         {'1', '2', '3', 'p', '5', 'e', '7', '8', '9', '0'}, // 5
         {'1', '2', '3', 'l', 'v', '6', '7', '8', '9', '0'}, // 6
         {'1', '2', '3', 'e', '5', '6', '7', '8', '9', '0'}, // 7
         {'1', '2', 'l', '4', '5', '6', '7', '8', '9', '0'}, // 8
         {'1', 'e', '3', '4', '5', '6', '7', '8', '9', '0'}};// 9
        // horizontal = "banana"
        // vertical = "apple"
        // diag / = "eleven"
        // diag \ = "hello"
        String[] words = {"banana", "apple", "eleven", "hello"};
        System.out.println("words? " + exist(input, words));

        //System.out.println("banana? " + exist(input, "banana"));
        //System.out.println("apple? " + exist(input, "apple"));
        //System.out.println("eleven? " + exist(input, "eleven"));
        //System.out.println("hello? " + exist(input, "hello"));
    }
}
