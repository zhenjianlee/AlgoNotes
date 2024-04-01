package Practise;

public class PractiseStringPermutation2 {

    public static void main(String[] args) {
        String line = "emilia";
        PractiseStringPermutation2 pm = new PractiseStringPermutation2();
        pm.permute(line, 0, line.length() - 1);

    }

    private void permute(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                str = swap(str, start, i); // dont understand this part
                permute(str, start + 1, end); // dont understand this part
                str = swap(str, start, i); // dont understand this part
            }
        }
    }

    private String swap(String s, int a, int b) {
        char[] array = s.toCharArray();
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return new String(array);
    }

}
/*
 *
 * I see the confusion. Let's clarify the parts you mentioned:
 *
 * str = swap(str,start,end);: This line attempts to swap the characters at
 * indices start and end, and then assigns the result back to the str variable.
 * However, in the context of generating permutations, this line should actually
 * be str = swap(str, start, i);. The purpose of this line is to swap the
 * character at index start with the character at index i for the current
 * iteration of the loop. This step is crucial because it fixes a character at
 * the start position, and then the algorithm proceeds to generate permutations
 * for the remaining characters starting from the start + 1 position.
 *
 * permute(str, i+1, end);: This line is responsible for the recursive call to
 * generate permutations for the remaining characters after fixing the character
 * at index start. The i+1 argument indicates that the next recursive call
 * should start generating permutations from the next index after the current
 * one. This helps in exploring all possible combinations of characters for the
 * remaining positions in the string.
 *
 * str = swap(str,start,end);: After the recursive call returns, this line is
 * used to swap back the characters at indices start and end (which were swapped
 * before the recursive call). However, similar to the first point, this line
 * should actually be str = swap(str, start, i); to correctly restore the
 * original order of characters at the start position. This step is essential
 * for backtracking and ensuring that subsequent iterations of the loop start
 * with the original string.
 *
 *
 */