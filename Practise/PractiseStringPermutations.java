package Practise;

public class PractiseStringPermutations {

    public static void main(String[] args) {
        String line = "pig";
        permute(line, 0, line.length() - 1);

    }

    private static void permute(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                str = swap(str, start, i);
                permute(str, start + 1, end);
                str = swap(str, start, i);
            }

        }
    }

    private static String swap(String s, int a, int b) {
        char[] arr = s.toCharArray();
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return new String(arr);
    }

}

/*
 *
 * Sure, let's walk through the algorithm step by step using the example string
 * "pig".
 *
 * Initial call: permute("pig", 0, 2)
 *
 * Since start != end, we enter the else block and start iterating over
 * characters starting from index start = 0.
 *
 * a. Iteration 1: i = 0
 *
 * Swap characters at indices 0 and 0 (no change): "pig"
 * Recursively call permute("pig", 1, 2)
 * b. Iteration 2: i = 1
 *
 * Swap characters at indices 0 and 1: "ipg"
 * Recursively call permute("ipg", 1, 2)
 * After recursion, swap back to restore original string: "pig"
 * c. Iteration 3: i = 2
 *
 * Swap characters at indices 0 and 2: "gip"
 * Recursively call permute("gip", 1, 2)
 * After recursion, swap back to restore original string: "pig"
 * Now, start = 1 and end = 2. Again, start != end, so we continue the process.
 *
 * a. Iteration 1: i = 0
 *
 * Swap characters at indices 1 and 0: "pgi"
 * Recursively call permute("pgi", 2, 2)
 * After recursion, swap back to restore original string: "pig"
 * b. Iteration 2: i = 1
 *
 * Swap characters at indices 1 and 1 (no change): "pig"
 * Recursively call permute("pig", 2, 2)
 * c. Iteration 3: i = 2
 *
 * Swap characters at indices 1 and 2: "pig"
 * Recursively call permute("pig", 2, 2)
 * Finally, start = 2 and end = 2. This indicates that we've fixed all
 * characters in the string, so we print the permutation "pig".
 *
 * The recursion unwinds, and we backtrack to the previous recursive calls.
 *
 * We repeat the process for all other combinations until all permutations are
 * generated and printed.
 *
 * This step-by-step process demonstrates how the algorithm recursively explores
 * all possible permutations of the input string "pig".
 *
 */

/*
 *
 *
 * The purpose of swapping, then permuting, and finally swapping back to the
 * original string is to ensure that the algorithm correctly explores all
 * permutations of the input string.
 *
 * Let's break down why this swapping process is necessary:
 *
 * Swapping: Initially, when we swap characters, it's to fix a character at the
 * current position (start) and explore all possible permutations with the
 * remaining characters. Swapping helps in creating different combinations of
 * characters by temporarily changing the order of characters in the string.
 *
 * Permute: After swapping, we recursively call permute to generate permutations
 * of the remaining characters. By incrementing the start index, we effectively
 * move to the next position in the string, fixing the character at that
 * position and exploring permutations for the rest of the string.
 *
 * Swapping Back: Once we've explored all permutations for a particular fixed
 * character at the current position (start), we need to revert the changes made
 * to the string to ensure that subsequent recursive calls start with the
 * original string. This swapping back ensures that the original order of
 * characters is restored before exploring other permutations. It's a form of
 * backtracking, allowing the algorithm to explore different paths without
 * permanently altering the input string.
 *
 * Overall, this swapping process, combined with recursion, enables the
 * algorithm to systematically explore all possible permutations of the input
 * string by fixing characters at different positions and permuting the
 * remaining characters.
 *
 *
 *
 */