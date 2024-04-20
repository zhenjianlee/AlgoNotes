# 221- Maximal Square

Medium - DP Bottom Up Question, can be solved with brute force but the code is too spaghetti

Watch https://www.youtube.com/watch?v=6X7Ha2PrDmM for explanation on question and DP solution.

## The question

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 

Example 1:
```
Input: matrix = [
    ["1","0","1","0","0"],
    ["1","0","1","1","1"],
    ["1","1","1","1","1"],
    ["1","0","0","1","0"]]
Output: 4
```
Example 2:
```
Input: matrix = [
    ["0","1"],
    ["1","0"]]
Output: 1
```
Example 3:
```
Input: matrix = [["0"]]
Output: 0
```
 

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 300
    matrix[i][j] is '0' or '1'.

Seen this question in a real interview before?
1/4
Yes
No
Accepted
667.1K
Submissions
1.4M
Acceptance Rate
46.4%


## The proper solution - Editorial

```java

class Solution {
    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int curMax=0;

        int[][] dp = new int[rows+1][cols+1]; // if row and cols are not added will not work for small matrix

        for (int i=1; i<=rows;i++){ // need <= row to work
            for (int j=1; j<=cols;j++){ // need <= cols to work
                if (matrix[i-1][j-1]=='1'){
                    int topleft = dp[i-1][j-1];
                    int left= dp[i-1][j];
                    int top= dp[i][j-1];
                    dp[i][j]= Math.min(topleft,Math.min(left,top))+1;
                    curMax=Math.max(curMax,dp[i][j]);
                } 
            }
        }
        return curMax*curMax;
    }
}


/*
 [i-1,j-1]    [i ,j-1]


 [i-1  ,j ]   [i  ,j ]
*/

```java