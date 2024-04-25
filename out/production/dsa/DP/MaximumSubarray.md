# The Maximum SubArray - Kadane's Algorithm

Intermediate - use curMax and Max to find the maximum continuous subarray within the array.

Cannot use sliding window or two pointer to solve this problem! Must use Kadane's algorithm!

https://www.hackerrank.com/challenges/maxsubarray/problem?isFullScreen=true

## The Question

We define subsequence as any subset of an array. We define a subarray as a contiguous subsequence in an array.

Given an array, find the maximum possible sum among:

all nonempty subarrays.
all nonempty subsequences.
Print the two values as space-separated integers on one line.

Note that empty subarrays/subsequences should not be considered.

Example

The maximum subarray sum is comprised of elements at inidices . Their sum is . The maximum subsequence sum is comprised of elements at indices  and their sum is .

Function Description

Complete the maxSubarray function in the editor below.

maxSubarray has the following parameter(s):

int arr[n]: an array of integers
Returns

int[2]: the maximum subarray and subsequence sums
Input Format

The first line of input contains a single integer , the number of test cases.

The first line of each test case contains a single integer .
The second line contains  space-separated integers  where .

Constraints
The subarray and subsequences you consider should have at least one element.

```
Sample Input 0
2
4
1 2 3 4
6
2 -1 2 3 4 -5
```
```
Sample Output 0
10 10
10 11

```
Explanation 0
In the first case: The maximum sum for both types of subsequences is just the sum of all the elements since they are all positive.

In the second case: The subarray  is the subarray with the maximum sum, and  is the subsequence with the maximum sum.

```
Sample Input 1
1
5
-2 -3 -1 -4 -6

```
```
Sample Output 1

-1 -1
```
Explanation 1
Since all of the numbers are negative, both the maximum subarray and maximum subsequence sums are made up of one element, .

## My Code

Reference from Nick White explanation - https://www.youtube.com/watch?v=jnoVtCKECmQ

```java
public static List<Integer> maxSubarray(List<Integer> arr) {
    // Write your code here
        int maxSumCon = arr.get(0);
        int curSum = arr.get(0);
                
        for (int i=1;i<arr.size(); i++){ // this is the main logic
            curSum = Math.max(curSum+arr.get(i), arr.get(i));
            maxSumCon= Math.max(curSum,maxSumCon);      
        }
        int maxSum=0;
        boolean flag=true;
        for (int i=0; i<arr.size();i++){
            if (arr.get(i)>0){
                maxSum+=arr.get(i);
                flag=false;
            }
        }
        
        if (flag){
            maxSum=arr.get(0);
            for (int num:arr){
                maxSum=Math.max(num,maxSum);
            }
        }
        //System.out.println("notNegSum="+notNegSum);
        return Arrays.asList(new Integer[]{maxSumCon,maxSum});
    }


```