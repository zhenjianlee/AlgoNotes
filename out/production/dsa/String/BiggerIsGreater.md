# Bigger Is Greater

Medium - Rearrange the string so that it is the next lexicographical order bigger

Need to follow a specialized algorithm to solve this problem

## The Question

https://www.hackerrank.com/challenges/bigger-is-greater/problem?isFullScreen=true

Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:

It must be greater than the original word
It must be the smallest word that meets the first condition
Example

The next largest word is .

Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.

Function Description

Complete the biggerIsGreater function in the editor below.

biggerIsGreater has the following parameter(s):

string w: a word
Returns
- string: the smallest lexicographically higher string possible or no answer

Input Format

The first line of input contains , the number of test cases.
Each of the next  lines contains .

Constraints

will contain only letters in the range ascii[a..z].
Sample Input 0

```
5
ab
bb
hefg
dhck
dkhc
```

Sample Output 0
```
ba
no answer
hegf
dhkc
hcdk
Explanation 0
```
Test case 1:
ba is the only string which can be made by rearranging ab. It is greater.
Test case 2:
It is not possible to rearrange bb and get a greater string.
Test case 3:
hegf is the next string greater than hefg.
Test case 4:
dhkc is the next string greater than dhck.
Test case 5:
hcdk is the next string greater than dkhc.
Sample Input 1
```
6
lmno
dcba
dcbb
abdc
abcd
fedcbabcd
```
Sample Output 1
```
lmon
no answer
no answer
acbd
abdc
fedcbabdc
```

## Referenced Solution

Too difficult, need to follow this method  https://www.nayuki.io/page/next-lexicographical-permutation-algorithm

<img alt="Alt text" height="500" src="https://www.nayuki.io/res/next-lexicographical-permutation-algorithm/next-permutation-algorithm.svg" width="500"/>



```java

public static String biggerIsGreater(String w) {
    // Write your code here
        char[] array = w.toCharArray();
        
        int i= array.length-1;
        while (i>0 && array[i-1]-'a'>= array[i]-'a'){
            i--;
        }
        
        if (i <= 0)return "no answer";

        int j= array.length-1;
        while (array[i-1]-'a' >= array[j]-'a'){
            j--;
        }
        
        swap(array, i-1,j);
        
        int left= i;
        int right = array.length-1;
        while (left < right){
            swap(array,left, right);
            left++;
            right--;
        }
        
        return new String(array);

    }
    
    private static void swap(char[] array , int idxA, int idxB){
        char temp = array[idxA];
        array[idxA]=array[idxB];
        array[idxB]=temp;
    }



```