# 713- Subarray Product Less Then K

Medium sliding window problem

## Question
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106

## Proper sliding window solution - 4ms

https://leetcode.com/problems/subarray-product-less-than-k/

Quite complicated.

Consider an example window containing elements 3, 4, and 5. If we include 6 in the window, we need to count all possible subarrays that end with 6. These subarrays can be formed by starting at any element within the current window and extending to 6. Therefore, the subarrays would be:

[6] (subarray consisting only of 6)

[5, 6] (subarray starting from 5 and ending at 6)

[4, 5, 6] (subarray starting from 4 and ending at 6)

[3, 4, 5, 6] (subarray starting from 3 and ending at 6)

By calculating right - left + 1, we enumerate all subarrays that end with the current element of the window (nums[right]). This ensures that we count all possible subarrays as we slide the window across the array. As we can observe, adding element 6 to the window created 4 new subarrays.

The crucial insight is that once the product becomes less than k, all possible subarrays formed by selecting subsets of elements within the current window (from left to right) will also have a product strictly less than k.

Hence, whenever the product is valid, we add the current window size (right - left + 1)

```java
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k<=1) return 0;
        int left=0;
        int res=0;
        int product=1;
        for (int right=0; right<nums.length;right++){
            product *=nums[right];
            while (product>=k){
                product /= nums[left];
                left++;
            }
            res += right-left+1;

        }

        return res;
    }
}

```


## My brute force solution - 855ms

```java
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                res++;
                int prod = nums[i];
                int j = i + 1;
                while (prod < k && j < nums.length) {
                    if (j < nums.length && prod * nums[j] < k) {
                        prod *= nums[j];
                        j++;
                        res++;
                    } else {
                        break;
                    }
                }

   
            }
        }
        return res;
    }
}


```

## My "subarray" brute force solution-does not work

```java
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res=0;
        boolean flag=false;
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer>curList = new ArrayList<>();
            if (nums[i] < k) {
                res++;
                ArrayList<Integer> single = new ArrayList<>();
                single.add(nums[i]);
                resList.add(single);
                curList.add(nums[i]);
                int prod = nums[i];
                int j = i + 1;
                while (prod < k && j < nums.length) {
                    if (j < nums.length && prod * nums[j] < k) {
                        prod *= nums[j];
                        curList.add(nums[j]);
                        j++;
                        flag=true;
                        res++;
                    } else {
                        break;
                    }
                }
                if (flag){
                    resList.add(curList);
                    //System.out.println("Added currList "+ curList);
                    flag=false;
                }
            }
            
        }
        System.out.println("resList ="+resList);
        return resList.size();
    }
//resList =[[10], [10, 5], [5], [5, 2, 6], [2], [2, 6], [6]]
}



```