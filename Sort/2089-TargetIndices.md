# MergeSort 2089. Find Target Indices After Sorting Array

Learning how to use merge sort as it performs faster i.e. n log n. Selection sort is n2 which is not optimum!


## Question

You are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

 

Example 1:

Input: nums = [1,2,5,2,3], target = 2
Output: [1,2]
Explanation: After sorting, nums is [1,2,2,3,5].
The indices where nums[i] == 2 are 1 and 2.

Example 2:

Input: nums = [1,2,5,2,3], target = 3
Output: [3]
Explanation: After sorting, nums is [1,2,2,3,5].
The index where nums[i] == 3 is 3.

Example 3:

Input: nums = [1,2,5,2,3], target = 5
Output: [4]
Explanation: After sorting, nums is [1,2,2,3,5].
The index where nums[i] == 5 is 4.

 

Constraints:

    1 <= nums.length <= 100
    1 <= nums[i], target <= 100



## Code

```java
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        mergeSort(nums);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            if (nums[i]==target){
                res.add(i);
            }

        }
        return res;
    }

    private void mergeSort(int[] array){
        if (array.length<2){
            return;
        }
        int mid = array.length/2;
        int[] left = new int[mid];
        int[] right = new int[array.length-mid];

        for (int i=0; i<mid;i++){
            left[i]=array[i];
        }

        for (int j=mid;j<array.length;j++){
            right[j-mid] = array[j];
        }

        mergeSort(left);
        mergeSort(right);
        merge(array,left, right);
    }

    private void merge(int[] a, int[] l, int[] r ){

        int i=0;
        int j=0;
        int k=0;
        while (i<l.length && j < r.length){
            if (l[i]<= r[j]){
                a[k]=l[i];
                k++;
                i++;
            } else {
                a[k]=r[j];
                k++;
                j++;
            }
        }

        while (i<l.length){
            a[k]=l[i];
            k++;
            i++;
        }

        while (j<r.length){
            a[k]=r[j];
            k++;
            j++;
        }
    }
}



```