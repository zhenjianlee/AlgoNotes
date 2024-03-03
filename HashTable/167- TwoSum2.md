# 167. Two Sum II - Input Array Is Sorted - HashMap Vs Binary Search

Same same with Two Sum - except that it is sorted. we can can actually use Binary Search.

But i still use hash map here.

I will implement a binary search and put the md file under Search.

## Question

Medium
Topics
Companies
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].


## My Code - HashMap 6ms, 17.8 %

```java

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i=0; i<numbers.length; i++){
            int curNum= numbers[i];
            int toFind = target-numbers[i];
            if (!map.containsKey(curNum)){
                map.put(toFind,i+1);
                //System.out.println(map);
            }else{
                res[0]=map.get(curNum);
                res[1]=i+1;
                return res;
            }
        }
        return res;
    }
}
```


## My Code - Binary Search 4ms  21.46%

```java

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        for (int i=0; i<numbers.length;i++){
            int curNum=numbers[i];
            int findNum=target-curNum;
            int searchedIdx = binarySearch(numbers, findNum, i);
            if ( searchedIdx != -1){
                return new int[]{i+1,searchedIdx+1};
            }
        }
        return new int[]{-1,-1};
    }

    private int binarySearch(int[] array,int find, int curIdx){
        int low =0;
        int high= array.length-1;
        int mid=low+(high-low)/2;

        while (low<=high){
            mid=low+(high-low)/2;
            if (array[mid]==find && mid!= curIdx){
                return mid;
            }else if (array[mid]>find){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
}
```

## Other peoples code - Binary search 2ms - 88.49%



```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n - 1;
        int mid = 0;
        int ans[] = new int[2];
        while (i < j) {
            mid = (i + j) / 2;
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            } else if (sum < target) {
                if (numbers[j] + numbers[mid] < target) {
                    i = mid + 1;
                } else {
                    i++;
                }

            } else {
                if (numbers[i] + numbers[mid] > target) {
                    j = mid - 1;
                } else {
                    j--;
                }
            }

        }
        return ans;
    }
}

```