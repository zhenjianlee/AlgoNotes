# 867- Transpose Matrix

 Easy - A prelude do a more difficult problem(rotate image)

 ## The Question

Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

Example 1:
```
Input: matrix = [

    [1,2,3],
    [4,5,6],
    [7,8,9]]


Output: [

    [1,4,7],
    [2,5,8],
    [3,6,9]
    
    ]

```

```
Example 2:

Input: matrix = [

    [1,2,3],
    [4,5,6]
    
    ]

Output: [

    [1,4],
    [2,5],
    [3,6]
    
    ]
```

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109


## The solution

Explained by Nick White clearly here :- https://www.youtube.com/watch?v=VDw9y6nX_ss

```java

class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows= matrix.length;
        int columns = matrix[0].length;

        int res[][] = new int[columns][rows];

        for (int i=0;i<rows;i++){
            for (int j=0; j<columns;j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}

```