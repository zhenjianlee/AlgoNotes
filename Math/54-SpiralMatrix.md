# 54-Spiral Matrix

Medium - matrix array manipulation

## The Question

Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:

```
Input: matrix = [
    [1,2,3],
    [4,5,6],
    [7,8,9]]
Output: 
    [1,2,3,6,9,8,7,4,5]

```


Example 2:

```
Input: matrix = [
    [ 1, 2, 3, 4],
    [ 5, 6, 7, 8],
    [ 9,10,11,12]]

Output: [1,2,3,4,8,12,11,10,9,5,6,7]

```

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100



## My solution after leaning from techwired8 - 0ms 100%

Similar to below but I included breaks instead of if. Because the while loop will only check condition after 1 full loop is run.

This will cause errors in between condition checks.

Break it out immediately so we don't introduce unwanted results.

```java

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length<=0)return res;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top=0,bottom=rows-1,left=0,right=cols-1;

        while (top<=bottom && left<=right){

            for (int i=left; i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            //System.out.println("Step 1:"+ res.toString());

            for (int j=top;j<=bottom;j++){
                res.add(matrix[j][right]);
            }
            right--;
            //System.out.println("Step 2:"+ res.toString());
            if (top>bottom || left>right) break; // if (top>bottom)break; proper way
            for (int k=right;k>=left;k--){
                res.add(matrix[bottom][k]);
            }
            bottom--;
            //System.out.println("Step 3:"+ res.toString());
            if (top>bottom || left>right) break; // if (left>right)break; proper way
            for (int l=bottom;l>=top;l--){
                res.add(matrix[l][left]);
            }
            left++; 
            //System.out.println("Step 4:"+ res.toString());

        }
        return res;
    }
}

```



## Proper solution from techwired8

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols-1, top = 0, bottom = rows-1;
        
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}

```


## Unsuccesful Code submission - stuck at case 7/25

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();


        int rows = matrix.length;
        int cols = matrix[0].length;

        int curRow = 0;
        int curCol = cols - 1;
        

        while (curRow < rows - 1 && curCol > 0) {

            //System.out.println("Step 1 : curRow=" + curRow + " rows=" + rows + " curCol=" + curCol + " cols=" + cols);
            for (int i = curRow; i < cols - 1; i++) {
                res.add(matrix[curRow][i]);
            }
            //System.out.println(res.toString());
            curRow++;

            if (curRow >= rows - 1 || curCol < 0)break;

            //System.out.println("Step 2 : curRow=" + curRow + " rows=" + rows + " curCol=" + curCol + " cols=" + cols);
            //Step 2 : curRow=2 curCol=1 
            for (int j = curRow - 1; j < rows; j++) {
                res.add(matrix[j][curCol]);
            }
            //System.out.println(res.toString());
            curCol--;

            if (curRow >= rows - 1 || curCol < 0)break;

            //System.out.println("Step 3 : curRow=" + curRow + " rows=" + rows + " curCol=" + curCol + " cols=" + cols);
            for (int k = curCol; k > 0; k--) {
                res.add(matrix[rows - curRow][k]);
            }
            //System.out.println(res.toString());

            if (curRow >= rows - 1 || curCol < 0)break;

            /*
             * curCol=1
             * cols = 3
             * 
             * i need= 0;
             * 
             * adjust curCol = 2
             * cols = 3
             * 
             */
            //System.out.println("Step 4 : curRow=" + curRow + " rows=" + rows + " curCol=" + curCol + " cols=" + cols);
            for (int l = rows - curRow; l >= curRow; l--) {
                res.add(matrix[l][(cols - 1) - (curCol + 1)]);
            }
            //System.out.println(res.toString());

            if (curRow >= rows - 1 || curCol < 0)break;

        }
        return res;
    }
}

/*
 * x x x x xxxxxxxxx
 * output: [1,2,3,3,6,9,9,8,7,7,4,4,5,6,5,8,5,4]
 * need : [1,2,3,6,9,8,7,4,5]
 * 
 */

```