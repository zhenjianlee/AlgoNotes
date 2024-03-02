# 1365. How Many Numbers Are Smaller Than the Current Number

Practise Selection Vs Insertion Vs Merge Sort Algorithm in this questions

## Question 

Easy
Topics
Companies
Hint
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

 

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 

Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100


## My Code

```java
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //copy new array for ref
        int[] ref = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            ref[i]=nums[i];
        }

        //~~sorting algorithm
        //===================

        //~selection sort -5ms
        //---------------
        for (int i=0; i<ref.length; i++){
            int min= Integer.MAX_VALUE;
            int minIdx=0;
            for (int j=i; j<ref.length; j++){
                if (ref[j]< min){
                    min = ref[j];
                    idx=j;
                }
            }
            int temp = ref[i];
            ref[i]=min;
            ref[minIdx] = temp;
        }

        //~insertion sort - 5ms
        //---------------
        // for (int i=1; i<ref.length; i++){
        //     int key= ref[i];
        //     int j= i-1;

        //     while (j>=0 && ref[j]>key){
        //         ref[j+1]=ref[j];
        //         j--;
        //     }
        //     ref[j+1]=key;
        // }
 

        //~mergeSort -4ms
        //---------------
        // mergeSort(ref);

        // for (int i=0;i<ref.length;i++){
        //     System.out.print(ref[i]+" ");
        // };

        //new array for result
        int[] res = new int[nums.length];
        int i=0;;
        while (i<nums.length){
            int target = nums[i];
            int j=0;
            while (j<ref.length){
                if (ref[j]== target){
                    res[i]=j;
                    break;
                }else{
                    j++;
                }
            }
            i++;
        }

        return res;
    }

    private void mergeSort(int[] array){

        if (array.length<2){
            return;
        }

        int mid = array.length/2;
        int[] left = new int[mid];
        int[] right=new int[array.length-mid];

        for (int i=0;i<left.length;i++){
            left[i]= array[i];
        }

        for (int j=mid; j<array.length; j++){
            right[j-mid]=array[j];
        }

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);

    }

    private void merge(int[] a, int[] l, int[] r){
        int i=0,j=0,k=0;

        while ( i < l.length && j< r.length){
            if (l[i]<= r[j]){
                a[k++]=l[i++];
            }else {
                a[k++]=r[j++];
            }
        }

        while (i <l.length){
            a[k++]=l[i++];
        }

        while (j <r.length){
            a[k++]=r[j++];
        }
    }
}

// nums 8 1 2 2 3
// ref  1 2 2 3 8
// res  4 0 1 1 3

```