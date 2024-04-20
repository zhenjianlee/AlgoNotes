# 1052- Grumpy Bookstore Owner

Medium - Good sliding window question  - will test understanding on manipulating the window size (shrinking)

## The Question

There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.

Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.

Example 2:

Input: customers = [1], grumpy = [0], minutes = 1
Output: 1

Constraints:

    n == customers.length == grumpy.length
    1 <= minutes <= n <= 2 * 104
    0 <= customers[i] <= 1000
    grumpy[i] is either 0 or 1.


## Second attempt after learning from Crisa Gazzola - 3ms, 93.3%

```java

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int len = customers.length;
        int sum=0;

        for (int i=0; i<len ; i ++){
            if (grumpy[i]==0){
                sum += customers[i];
            }
        }

        int addSum=0;
        int maxSum=0;
        int windowStart=0;

        for (int j=0; j<len;j++){
            if (grumpy[j]==1){
                addSum+=customers[j];
            }

            while (j-windowStart+1>=minutes){
                maxSum = Math.max(maxSum,addSum);
                if (grumpy[windowStart]==1){
                    addSum-=customers[windowStart];
                }
                windowStart++;
            }
        }
        return sum+maxSum;
    } 
}

```


## Proper solution to study - Crisa Gazzola https://leetcode.com/crisa/


All we need to do is find the max number of customers who, without applying the technique, would normally be unsatisfied. Once we have this max, we just add it to the baseline number of customers who would be satisfied if we did not apply the technique.

Steps:

1. Pass through array and calculate the total number of satisifed customers without applying the bookstore owner's "technique". This is calculated by only adding customers on minutes where he is happy.

2. Create a sliding window of size X. The sum of the window will be equal to the number of customers that occur on minutes within the window where the bookstore owner is unhappy.

3. Compare the current sum of this window with the max window sum we have seen thus far. If the current sum is bigger than the max, it becomes the max.

4. Return the baseline number of satisfied customers + the max window sum we found.

```java
public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        
        // find the number of satisfied customers without applying the secret technique
        int satisfiedCustomers = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            } 
        }
        
        int max = 0;
        int currSum = 0;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < customers.length; windowEnd++) {
            if (grumpy[windowEnd] == 1) {
                currSum += customers[windowEnd];
            }
            
            if (windowEnd - windowStart + 1 >= X) {
                max = Math.max(max, currSum);
                if (grumpy[windowStart] == 1) {
                    currSum -= customers[windowStart];
                }
                windowStart++;
            }
        }
        
        return satisfiedCustomers + max;   
}

```

## My first solution (bruteForce , not Sliding Window )-73ms 9.45% (Not optimal)

```java

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] opp = new int[customers.length];
        int len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 1) {
                opp[i] = customers[i];
            }
        }
        // System.out.println(Arrays.toString(opp));
        int maxOpp = Integer.MIN_VALUE;
        int maxOppIdx = -1;

        for (int j = 0; j <= len - minutes; j++) {
            int curOpp = 0;
            for (int k = j; k < j + minutes; k++) {
                curOpp += opp[k];
            }

            if (curOpp > maxOpp) {
                maxOpp = curOpp;
                maxOppIdx = j;
            }

        }
        // System.out.println("maxOpp=" + maxOpp + " maxOppIdx=" + maxOppIdx);
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0 || i == maxOppIdx || (i > maxOppIdx && i < maxOppIdx + minutes)) {
                res += customers[i];
            }

        }

        return res;
    }
}

// [1,0,1,2,1,1,7,5] customers
// [0,1,0,1,0,1,0,1] 1=grumpy, 0=not grumpy
//            S S S
// [1,0,1,0,1,1,7,5] happy customers
//            x
// [0,0,0,2,0,1,0,5] opp
//-----------------------------------------------------
// [3,8,8,7,1] customers
//    x x x
// [3,8,8,7,1] opp

```