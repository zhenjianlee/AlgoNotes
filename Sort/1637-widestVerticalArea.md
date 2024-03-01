# 1637. Widest Vertical Area Between Two Points Containing No Points
Another chance to practise mergeSort

## Question

Solved
Easy
Topics
Companies
Hint

Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.

A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.

Note that points on the edge of a vertical area are not considered included in the area.

 

Example 1:

Input: points = [[8,7],[9,9],[7,4],[9,7]]
Output: 1
Explanation: Both the red and the blue area are optimal.

Example 2:

Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
Output: 3

 

Constraints:

    n == points.length
    2 <= n <= 105
    points[i].length == 2
    0 <= xi, yi <= 109


## First try- practise merge sort on a matrix
Mainly to practise merge sort on a matrix -first time

129ms 5.01%

```java
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {

        mergeSort(points);
        int maxWidth=0;

        for (int i=1; i<points.length; i++){
            maxWidth= Math.max(maxWidth, points[i][0]-points[i-1][0]);
        }
        return maxWidth;
    }

    private void mergeSort(int[][] matrix){

        if (matrix.length<2){
            return;
        }
        int mid = matrix.length/2;
        int[][] left = new int[mid][2] ;
        int[][] right = new int[matrix.length-mid][2];

        for (int i=0; i<mid; i++){
            left[i]=matrix[i];
        }

        for (int j=mid;j<matrix.length;j++){
            right[j-mid]=matrix[j];
        }

        mergeSort(left);
        mergeSort(right);
        merge(matrix,left,right);
    }

    private void merge(int[][] m , int[][] l, int[][] r ){

        int i=0 , j=0, k=0;

        while (i < l.length && j<r.length){
            if (l[i][0]<= r[j][0]){
                m[k]=l[i];
                k++;
                i++;
            }else {
                m[k]=r[j];
                k++;
                j++;
            }
        }

        while (i < l.length){
            m[k]=l[i];
            k++;
            i++;
        }

        while (j < r.length){
            m[k]=r[j];
            k++;
            j++;
        }
    }
}

```


## Second Try - Convert matrix to array

24ms 54.39%

```java
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {

        
        int[] xCoord = new int[points.length];
        for (int i=0; i<points.length;i++){
            xCoord[i]=points[i][0];
        }

        mergeSort(xCoord);
        int maxWidth=0;

        for (int i=1; i<xCoord.length; i++){
            maxWidth= Math.max(maxWidth, xCoord[i]-xCoord[i-1]);
        }
        return maxWidth;
    }

    private void mergeSort(int[] arr){

        if (arr.length<2){
            return;
        }
        int mid = arr.length/2;
        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];

        for (int i=0; i<mid; i++){
            left[i]=arr[i];
        }

        for (int j=mid;j<arr.length;j++){
            right[j-mid]=arr[j];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr,left,right);
    }

    private void merge(int[] a , int[] l, int[] r ){

        int i=0 , j=0, k=0;

        while (i < l.length && j<r.length){
            if (l[i]<= r[j]){
                a[k]=l[i];
                k++;
                i++;
            }else {
                a[k]=r[j];
                k++;
                j++;
            }
        }

        while (i < l.length){
            a[k]=l[i];
            k++;
            i++;
        }

        while (j < r.length){
            a[k]=r[j];
            k++;
            j++;
        }
    }
}


```

