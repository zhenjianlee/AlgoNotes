# 509-Fibonacci Number

240315

I was asked this during TATA CS on site 2nd stage interview and nearly could not answer due to panicking.

It is quite embarrasing to almost failing an easy question. It was my first site interview, need more practise.

So i came to do this question on leetcode the next day.

## Question
Easy
Topics
Companies
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Constraints:

0 <= n <= 30

## My solution -using arraylist - 0ms 100% but memory is 40.62Mb 12.28%

```java
class Solution {
    public int fib(int n) {

        if(n==0)return 0;
        else if(n==1 )return 1;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        for (int i = 2; i <= n; i++) {
            int cur = list.get(list.size() - 1) + list.get(list.size() - 2);
            list.add(cur);
        }

        return list.get(list.size()-1);
    }

}
//0 1 2 3 4 5 6 7  8  9 10
//0 1 1 2 3 5 8 13 21 34

```

## Referred recursion answer - i dont understand - 8ms 49.82% , memory is still 40.63Mb 12.28%

Looks very simple but i don't understand.

Here is what Professor GPT says :-

Base Case: The function fib(int n) starts by checking if n is either 0 or 1. In these cases, the Fibonacci sequence is defined to be 0 for n=0 and 1 for n=1. These are known as the base cases of the recursion. When n reaches 0 or 1, the recursion stops and these values are returned.

Recursive Step: If n is not 0 or 1, the function recursively calls itself twice: fib(n - 1) and fib(n - 2). This is because each Fibonacci number (after the first two) is the sum of the two preceding numbers. So, fib(n) is calculated by adding the result of fib(n - 1) and fib(n - 2).

Here's an example of how this works:

If n = 2, it returns fib(1) + fib(0) which equals 1 + 0 = 1.
If n = 3, it returns fib(2) + fib(1) which equals 1 + 1 = 2.
If n = 4, it returns fib(3) + fib(2) which equals 2 + 1 = 3.
And so on.
This recursive approach continues until it reaches the base cases (n = 0 or n = 1), at which point it starts returning values back up the call stack, eventually calculating fib(n).

However, it's worth noting that this recursive solution is not the most efficient for large values of n, as it recalculates the same Fibonacci numbers multiple times. Dynamic programming or memoization techniques can be used to optimize the solution by storing previously calculated Fibonacci numbers and reusing them instead of recalculating.

Let's break down how fib(5) is calculated using the recursive function:

```
fib(5) = fib(4) + fib(3)
```
To calculate fib(5), the function calls itself twice:

fib(4)
fib(3)
Now, let's expand these:

```
fib(4) = fib(3) + fib(2)
fib(3) = fib(2) + fib(1)
```
We need to calculate fib(4), so we'll further expand fib(3):

```
fib(3) = fib(2) + fib(1)
       = 1 + 1
       = 2
```
Now we can calculate fib(4):

```
fib(4) = fib(3) + fib(2)
       = 2 + 1
       = 3
```
We also need to calculate fib(3) for fib(5), but we've already calculated it as 2.

Now, we have fib(4) = 3 and fib(3) = 2. Let's substitute these back into fib(5):

```
fib(5) = fib(4) + fib(3)
       = 3 + 2
       = 5
```
So, fib(5) indeed equals 5.

Each recursive call continues this process of breaking down the problem into smaller subproblems until it reaches the base cases (n = 0 or n = 1), at which point it starts returning values back up the call stack, eventually calculating fib(5) by summing the results of fib(4) and fib(3).

```java
class Solution {
    public int fib(int n) {
        if (n ==1 || n==0){
            return n;
        }

        return fib(n-1)+fib(n-2);
        
    }
}

//0 1 2 3 4 5 6 7  8  9 10
//0 1 1 2 3 5 8 13 21 34


```


## The top solution by others - 0ms 100% - What the heck is this?

KIV!

``` java

class Solution {
    public int fib(int n) {

    int [][]F={{1,1},{1,0}};
    if(n==0) {
        return 0;
    }    
    pwr(F,n-1);
    return F[0][0];
    }
    public void pwr(int [][]F,int n)
    {
        if(n==0 || n==1) {
            return;
        }
        int M[][]={{1,1},{1,0}};
        pwr(F,n/2);
        multi(F,F);
        if(n%2!=0) {
            multi(F,M);
        }
    }
    public void multi(int [][]F,int [][]M)
    {
        int x00=F[0][0] *M[0][0]+F[0][1]* M[1][0];
        int y01=F[0][0]*M[0][1]  + F[0][1]*M[1][1];
        int x10=F[1][0]*M[0][0] + F[1][1]*M[1][0];
        int  y11=F[1][0] *M[0][1]+F[1][1]*M[1][1];

        F[0][0]=x00;
        F[0][1]=y01;
        F[1][0]=x10;
        F[1][1]=y11; 
    }
}
```