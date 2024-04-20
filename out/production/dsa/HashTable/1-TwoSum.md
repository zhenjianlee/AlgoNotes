# 1. Two Sum

A classic problem requiring the use of HashMap. 2ms 98.9%.

Used a one pass solution , its almost similar to the solution, but my code is 'dirtier'.



## Question

Easy
Topics
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

## My Code

```java

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i=0;i<nums.length;i++){
            int find = target-nums[i];
            int curNum = nums[i];
            if (!map.containsKey(curNum)){
                map.put(find,i);
            }else{
                res[0]=map.get(curNum);
                res[1]=i;
                break;
            }
        }
        return res;
    }
}

```

## Other Peoples Code

HOw come other ppl's brute force approach is only 0ms ? Strange ! It;s a nested for looop!

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 1000 || nums.length > 9999)
        {
            for(int i=1;i<nums.length;i++)
            {
                for(int j=i;j<nums.length;j++)
                {
                    if(nums[j-i]+nums[j]==target)
                    {
                        return new int[]{j-i,j};
                    }
                }
            }
        }
        return new int[]{};
     }
}


```