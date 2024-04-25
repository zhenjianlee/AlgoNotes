# Regular Expression using JS

https://www.hackerrank.com/challenges/js10-regexp-1/problem?isFullScreen=true

More resourcces : https://regexone.com/

## The Question

Objective

In this challenge, we use a Regular Expression to evaluate a string. Check out the attached tutorial for more details.

Task

Complete the function in the editor below by returning a RegExp object, , that matches any string  that begins and ends with the same vowel. Recall that the English vowels are a, e, i, o, and u.

Constraints

The length of string  is  .
String  consists of lowercase letters only (i.e., [a-z]).
Output Format

The function must return a RegExp object that matches any string  beginning with and ending in the same vowel.

Sample Input 0

bcd
Sample Output 0

false
Explanation 0

This string starts with (and ends in) a consonant, so it cannot start and end with the same vowel.

Sample Input 1

abcd
Sample Output 1

false
Explanation 1

This string ends in a consonant, so it cannot start and end with the same vowel.

Sample Input 2

abcda
Sample Output 2

true
Explanation 2

This string starts and ends with the same vowel (a).

Sample Input 3

abcdo
Sample Output 3

false
Explanation 3

This string starts with the vowel a but ends in the vowel o.


## The Code

```java

function regexVar() {
    /*
     * Declare a RegExp object variable named 're'
     * It must match a string that starts and ends with the same vowel (i.e., {a, e, i, o, u})
     */
    const re = /^([aeiou]).*\1$/i;
    
    
    /*
     * Do not remove the return statement
     */
    return re;
}

```

### Breakdown According to Professor GPT

```
.: Matches any single character except for a newline character.
*: Quantifier that matches the preceding element (in this case, .) zero or more times.
So, .* together means "match zero or more occurrences of any character."

Now, let's put it in context within the regular expression /^([aeiou]).*\1$/i:

^: Asserts the start of the string.
([aeiou]): This part captures any one character that is a vowel (a, e, i, o, or u) and stores it in a capturing group.
.*: This part matches zero or more occurrences of any character.
\1: This is a backreference to the first capturing group (the vowel captured at the beginning). It ensures that the same vowel as the one matched at the start of the string is also matched at the end.
$: Asserts the end of the string.
i: This flag makes the regex case-insensitive, so it will match both uppercase and lowercase vowels.
So, altogether, the pattern /^([aeiou]).*\1$/i matches a string that:

Starts with a vowel.
Can have any number of characters in between.
Ends with the same vowel as the one at the start.
This ensures that the string starts and ends with the same vowel.

```