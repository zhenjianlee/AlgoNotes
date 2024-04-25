# 1456. Maximum Number of Vowels in a Substring of Given Length

Medium - Was able to solve all test cases in one try! Yay~

https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75

## The Question

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length

## My code - 24ms 24.82%

Naive solution - use a deque to keep track of subtring. if vowel add count when place into deque. 

when size is over, remove from head and check if it is vowel. if vowel remove count.

keep track of max count at all times.

p/s - noticed other solutions are faster - they dont even use a collection to keep track of substring!

```java

class Solution {
    public int maxVowels(String s, int k) {

        int left=0;
        int size=0;
        Deque<Character> d = new LinkedList<>();
        int vowelsCount = 0;
        int maxVowelsCount=0;

        for (int right=0; right<s.length() ; right++){
            Character curCh= s.charAt(right);
            if (isVowel(curCh))vowelsCount++;
            d.offerLast(curCh);
            size++;

            while (size>k){
                Character removeCh = d.pollFirst();
                if (isVowel(removeCh))vowelsCount--;
                size--;
            }

            maxVowelsCount= Math.max(maxVowelsCount, vowelsCount);

        }
        return maxVowelsCount;
    }
    
    public static boolean isVowel(Character ch){
        ch = Character.toLowerCase(ch);
        if (ch== 'a' || ch=='e' || ch=='i'|| ch=='o'|| ch == 'u'){
            return true;
        }
        
        return false;
    }
}


```