# 1004. Max Consecutive Ones III

Medium - Able to solve on my own

## The Question

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length

## My Code - 3ms 82.59%

```java
class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int curCount = 0;
        int maxCount = 0;
        int k2 = k;
        boolean toOffset = false;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1)
                curCount++;
            else {
                if (k2 > 0) {
                    curCount++;
                }
                k2--;
            }
            while (k2 < 0) {
                toOffset = true;
                if (nums[left] == 0) {
                    k2++;
                    curCount--;
                } else {
                    curCount--;
                }
                left++;
            }

            if (toOffset) {
                curCount++;
                toOffset = false;
            }

            maxCount = Math.max(maxCount, curCount);
            // System.out.println(String.format("left=%s, right=%s, k2=%s, curCount=%s,
            // maxCount=%s"
            // ,left, right, k2, curCount, maxCount));
        }
        return maxCount;
    }
}

/*
 * r
 * l
 * 0 1 2 3 4 5 6 7 8 9 10
 * [1,1,1,0,0,0,1,1,1,1,0]
 * 
 * left=0, right=0, k2=2, curCount=1, maxCount=1 x
 * left=0, right=1, k2=2, curCount=2, maxCount=2 x
 * left=0, right=2, k2=2, curCount=3, maxCount=3 x
 * left=0, right=3, k2=1, curCount=4, maxCount=4 x
 * left=0, right=4, k2=0, curCount=5, maxCount=5 x
 * 
 * l=0, r=5 , k2=-1 , c=0 ---> once the while loop finish running, we need to
 * take into account the nums[right] can be included as count as well!! so
 * offset plus 1
 * 
 * 
 * left=4, right=5, k2=0, curCount=1, maxCount=5 ??? , count should be 2 !!
 * 
 * 
 * left=4, right=6, k2=0, curCount=2, maxCount=5
 * left=4, right=7, k2=0, curCount=3, maxCount=5
 * left=4, right=8, k2=0, curCount=4, maxCount=5
 * left=4, right=9, k2=0, curCount=5, maxCount=5
 * left=5, right=10, k2=0, curCount=4, maxCount=5
 * 
 * 
 * 
 * 
 */



```