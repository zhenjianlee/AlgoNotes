# 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

Medium - Harder than Picking Numbers from hackerrank

## The Question

Example 1:

Input: nums = [8,2,4,7], limit = 4
Output: 2
Explanation: All subarrays are:
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4.
Therefore, the size of the longest subarray is 2.
Example 2:

Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
Example 3:

Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
0 <= limit <= 109


## My Code 1 - Failed Attempt 1

Because the array is not sorted. If any number in between does is bigger than next number, the window no longer holds true.

```java

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int i=0 , maxSize=0;
        for (int j=0; j<nums.length;j++){
            int delta =Math.abs(nums[j]-nums[i]);
            if(delta<=limit){
                maxSize = Math.max(maxSize,j-i+1);
                System.out.println(String.format("A i=%s, j=%s, nums[i]=%s, nums[j]=%s maxSize=%s"
                    ,i,j,nums[i],nums[j],maxSize));
            }else{
                int key=nums[j];
                while (i<j && Math.abs(nums[i]-key)>limit){
                    i++;
                }
                System.out.println(String.format("B i=%s, j=%s, nums[i]=%s, nums[j]=%s maxSize=%s"
                    ,i,j,nums[i],nums[j],maxSize));
            }
        }
        return maxSize;
        
    }
}

/*
Case 4
 0 1 2 3 4 5  6 7 8 , limit =4
[1,5,6,7,8,10,6,5,6]
     i
              j !

A i=0, j=0, nums[i]=1, nums[j]=1 maxSize=1 x
A i=0, j=1, nums[i]=1, nums[j]=5 maxSize=2 x
B i=1, j=2, nums[i]=5, nums[j]=6 maxSize=2 x
A i=1, j=3, nums[i]=5, nums[j]=7 maxSize=3 x
A i=1, j=4, nums[i]=5, nums[j]=8 maxSize=4 x
B i=2, j=5, nums[i]=6, nums[j]=10 maxSize=4 x
A i=2, j=6, nums[i]=6, nums[j]=6 maxSize=5 x  ok
A i=2, j=7, nums[i]=6, nums[j]=5 maxSize=6 !!! logic issue!!!!
A i=2, j=8, nums[i]=6, nums[j]=6 maxSize=7



Case 2 - ok
  0 1 2 3 4 5  limit =5
[10,1,2,4,7,2]

A i=0, j=0, nums[i]=1, nums[j]=1 maxSize=1
A i=0, j=1, nums[i]=1, nums[j]=5 maxSize=2
B i=1, j=2, nums[i]=5, nums[j]=6 maxSize=2
A i=1, j=3, nums[i]=5, nums[j]=7 maxSize=3
A i=1, j=4, nums[i]=5, nums[j]=8 maxSize=4
B i=2, j=5, nums[i]=6, nums[j]=10 maxSize=4
A i=2, j=6, nums[i]=6, nums[j]=6 maxSize=5
A i=2, j=7, nums[i]=6, nums[j]=5 maxSize=6
A i=2, j=8, nums[i]=6, nums[j]=6 maxSize=7


Case 3 - ok

 0 1 2 3 4 5 6 7
[4,2,2,2,4,4,2,2]

A i=0, j=0, nums[i]=4, nums[j]=4 maxSize=1
B i=1, j=1, nums[i]=2, nums[j]=2 maxSize=1
A i=1, j=2, nums[i]=2, nums[j]=2 maxSize=2
A i=1, j=3, nums[i]=2, nums[j]=2 maxSize=3
B i=4, j=4, nums[i]=4, nums[j]=4 maxSize=3
A i=4, j=5, nums[i]=4, nums[j]=4 maxSize=3
B i=6, j=6, nums[i]=2, nums[j]=2 maxSize=3
A i=6, j=7, nums[i]=2, nums[j]=2 maxSize=3

*/

```