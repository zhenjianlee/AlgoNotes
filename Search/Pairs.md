# Pairs

Intermediate - within an array find pairs where a-b == target value given.

Brute force - can be done using nested loop - but TLE.

My solution - use binary search

Elegant solution - sort the array then use two pointer!

https://www.hackerrank.com/challenges/pairs/problem?isFullScreen=true

## The Question

Given an array of integers and a target value, determine the number of pairs of array elements that have a difference equal to the target value.

Example

There are three values that differ by : , , and . Return .

Function Description

Complete the pairs function below.

pairs has the following parameter(s):

int k: an integer, the target difference
int arr[n]: an array of integers
Returns

int: the number of pairs that satisfy the criterion
Input Format

The first line contains two space-separated integers  and , the size of  and the target value.
The second line contains  space-separated integers of the array .

Constraints

each integer  will be unique
Sample Input

```
STDIN       Function
-----       --------
5 2         arr[] size n = 5, k =2
1 5 3 4 2   arr = [1, 5, 3, 4, 2]

Notes :->After sorted: [1 , 2 , 3,  4,  5]


```
```
Sample Output
3
```

Explanation

There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1]. .

## My Code - using my solution - Naive Binary Search

```java

 public static int pairs(int k, List<Integer> arr) {
    // Write your code here
        int count=0;
        
        arr.sort((a,b)-> a-b);
        //System.out.println(arr.toString());
        HashSet<Integer> set = new HashSet<>();
        
        for (int i=0; i<arr.size() ;i ++){
            int num = arr.get(i);
            if (binarySearch(num+k, arr,set)){count++; set.add(num);}
            if (binarySearch(num-k ,arr,set)){count++; set.add(num);}
        }

        return count;
    }
    
    private static boolean binarySearch(int target, List<Integer> arr, HashSet<Integer> set){
        int low=0;
        int high=arr.size()-1;
        int mid;
        
        while (low<=high){
            mid = low + (high-low)/2;
            //System.out.println(String.format("low=%s , mid= %s, high=%s",low,mid,high));
            int check = arr.get(mid);
            if (check == target && !set.contains(check) ){
                //System.out.println("Found! " + check);
                return true;
                }
            else if ( check > target){
                high=mid-1;
                //System.out.println("a high=mid");
            }else{
                low=mid+1;
                //System.out.println("b low=mid");
            }
            
        }
        return false;
    }
    
    // not in use - TLE
     public static int pairsBrute(int k, List<Integer> arr) {
    // Write your code here
        int count=0;
        for (int i =0; i<arr.size()-1; i++){
            for (int j=i+1;j<arr.size();j++){
                if (Math.abs( arr.get(i) - arr.get(j )) == k){
                    count++;
                }
            }
        }
        return count;


```

## Reference code1 - Elegant two pointer method - agoston_fung

```java

public static int pairs(int k, List<Integer> arr) {
    // Write your code here
    
        int i=0, j=1, count=0;
        
        arr.sort((a,b)->a-b);
        
        while (j<arr.size()){
            int delta = arr.get(j)-arr.get(i);
            if (delta == k){
                count++;
                j++;
            }else if( delta >k){
                i++;
            }else if( delta <k){
                j++;
            }
            
        }
        return count;
   
    }

```

## Reference code2  - HashSet - RANJAN_19BCS009

```java
static int pairs(int k, int[] arr) {
    HashSet<Integer> set = new HashSet<>();
    for(int i=0;i<arr.length;i++) set.add(arr[i]);
    int ans = 0;
    for(int i:set)
        ans+=(set.contains(i+k))?1:0;
    return ans;
}

```