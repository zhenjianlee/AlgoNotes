# 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

Too difficult. To revisit. Spent too much time here.

Medium - Harder than Picking Numbers from hackerrank. Cannot solve.

Refer to Lee215 Solution which is fantastic!

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

## Tried to replicate the reference code 

Still dont understand about min and max management in the deque. why peek and why poll at the end? why not peekLast and pollLast?

ChatGPT:-

Let's address your proposed modifications:

Using peekLast() instead of peek(): While it's true that peekLast() would give you the last element of the deque, in this algorithm, peek() 
is used to get the first element of the deque, which represents the minimum or maximum element depending on the deque. Using peekLast() 
instead of peek() would not provide the correct behavior because it would ignore the oldest element in the deque, which is the one that 
should be compared with nums[i] during window contraction.

Using pollLast() instead of poll(): Similarly, using pollLast() instead of poll() would remove the newest element from the deque, which 
is not what you want in this case. You want to remove the oldest element from the deque when contracting the window, so poll() is the 
correct method to use.

In summary, your proposed modifications are incorrect because they would not maintain the correct behavior of the algorithm. 
The original implementation correctly uses peek() and poll() to access and remove elements from the deques, respectively, ensuring 
that the algorithm functions as intended.

```java 

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> maxD = new LinkedList<>();
        Deque<Integer> minD = new LinkedList<>();
        int i = 0;
        int j;
        for (j = 0; j < nums.length; j++) {
            while (!maxD.isEmpty() && nums[j] > maxD.peekLast())
                maxD.pollLast();
            while (!minD.isEmpty() && nums[j] < minD.peekLast())
                minD.pollLast();
            maxD.addLast(nums[j]);
            minD.addLast(nums[j]);
            // System.out.println(String.format("i=%s, j=%s, maxD=%s, minD=%s"
            // ,i,j,maxD.peekLast(),minD.peekLast()));
            System.out.println(j + " " + "maxD=" + maxD.toString());
            System.out.println(j + " " + "minD=" + minD.toString());
            if (maxD.peek() - minD.peek() > limit) { // cannot be peekLast() , will return wrong result!
                if (maxD.peek() == nums[i])
                    maxD.poll(); // cannot be pollLast() , will return wrong result!
                if (minD.peek() == nums[i])
                    minD.poll(); // cannot be pollLast() , will return wrong result!
                i++;
            }
        }
        return j - i;

    }
    /* [8,2,4,7] , limit =4
     * 0 maxD=[8]
     * 0 minD=[8]
     * 1 maxD=[8, 2]
     * 1 minD=[2]
     * 2 maxD=[4]
     * 2 minD=[2, 4]
     * 3 maxD=[7]
     * 3 minD=[2, 4, 7]
     */
}



```


## Reference code from Lee215 with some of my notes

```java

class Solution {
    public int longestSubarray(int[] A, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < A.length; j++) {
            while (!maxd.isEmpty() && A[j] > maxd.peekLast())
                maxd.pollLast();
            while (!mind.isEmpty() && A[j] < mind.peekLast())
                mind.pollLast();
            //System.out.println(String.format("A i=%s, j=%s, maxd=%s , mind=%s ", i, j, maxd.peek(), mind.peek()));
            maxd.add(A[j]);
            mind.add(A[j]);
            //System.out.println(String.format("B i=%s, j=%s, maxd=%s , mind=%s ", i, j, maxd.peek(), mind.peek()));
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == A[i])
                    maxd.poll();
                if (mind.peek() == A[i])
                    mind.poll();
                ++i;
            }
            //System.out.println(String.format("C i=%s, j=%s, maxd=%s , mind=%s ", i, j, maxd.peek(), mind.peek()));
        }

        System.out.println(String.format("Final! i=%s, j=%s",i,j));
        return j - i;
    }
}

/*
 * Input: nums = [8,2,4,7], limit = 4
 *                    i
 *                      j
 * 
 * A i=0, j=0, maxd=null , mind=null x
 * B i=0, j=0, maxd=8 , mind=8 x
 * C i=0, j=0, maxd=8 , mind=8 x
 * A i=0, j=1, maxd=8 , mind=null x
 * B i=0, j=1, maxd=8 , mind=2 x 
 * C i=1, j=1, maxd=2 , mind=2 x ???  , because maxD = 2,8 , 8 was polled off
 * A i=1, j=2, maxd=null , mind=2 x maxd wall polled off because it is smaller than 4
 * B i=1, j=2, maxd=4 , mind=2 x maxd is now 4
 * C i=1, j=2, maxd=4 , mind=2 x
 * A i=1, j=3, maxd=null , mind=2  x maxd was polled off as 4 is smaller than 7
 * B i=1, j=3, maxd=7 , mind=2 x
 * C i=2, j=3, maxd=7 , mind=4 x mind (2) was polled up , so now mind is now 4
 Final! i=2, j=4
 * 
 * 
 */


```


## My Code 2 - Failed Attempt 2

Tried to use min and max but cannot clear test case 3

```java

public int longestSubarray(int[] nums, int limit) {
    //do 1425
    int i=0 , maxSize=0 ,maxVal=nums[0], minVal=nums[0];
    for (int j=0; j<nums.length;j++){
        int compareIJmin = Math.min(nums[i],nums[j]);
        int compareIJmax = Math.max(nums[i],nums[j]);
        minVal=Math.min(compareIJmin, minVal);
        maxVal=Math.min(compareIJmax,maxVal);
        int delta =Math.abs(minVal-maxVal);
        if(delta<=limit){
            maxSize = Math.max(maxSize,j-i);
            System.out.println(String.format("A i=%s, j=%s, nums[i]=%s, nums[j]=%s maxSize=%s , minVal=%s , maxVal=%s"
                    ,i,j,nums[i],nums[j],maxSize, minVal, maxVal));
        }else{
            int key=maxVal;
            while (i!=j){
                i++;
                minVal = Math.min(nums[i],nums[j]);
                maxVal = Math.max(nums[i],nums[j]);
            }
            System.out.println(String.format("B i=%s, j=%s, nums[i]=%s, nums[j]=%s maxSize=%s , minVal=%s , maxVal=%s"
                    ,i,j,nums[i],nums[j],maxSize, minVal, maxVal));
        }
    }
    return maxSize;
}

```


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