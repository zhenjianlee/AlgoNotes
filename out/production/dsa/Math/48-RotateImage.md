# 48 - Rotate Image

Medium - Very popular question - must study! Do 867-Transpose Matrix first!

## The question

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

 

Constraints:

    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000


## The solution (learn from Nick White) - 117ms, 100%

```java

class Solution {
    public void rotate(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        //transpose matrix - rows become cols , cols become rows
        for (int i=0; i<rows; i++){
            // import, j must equal i
            for (int j=i; j<columns;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]= temp;
            }
        }

        //flip rows within matrix
        for (int i=0; i<rows; i++){
            int j=0;
            int k=matrix[i].length-1;
            while (j<k){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]= temp;
                j++;
                k--;
            }  
        }  
    }
}
/*
BEFORE
[1,2,3],
[4,5,6],
[7,8,9]] 

STEP1- TRANSPOSE
[1,4,7],
[2,5,8],
[3,6,9]] 

STEP2- FLIP
[7,4,1],
[8,5,2],
[9,6,3]

DONE!
*/

```