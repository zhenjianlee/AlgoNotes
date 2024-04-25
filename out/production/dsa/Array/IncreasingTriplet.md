# 334 -Increasing Triplet Subsequence

Medium - brute force TLE, three pointer doesnt work.

Need to find the the minimum numbers and the third larger number.

https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75

## Reference Code

```java

public boolean increasingTriplet(int[] nums) {

        int firstMin= Integer.MAX_VALUE;
        int secondMin= Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++ ){
            int num=nums[i];
            if (num <=firstMin){
                firstMin=num;
            }else if(num<= secondMin){
                secondMin= num;
            }else{
                System.out.println(String.format("TRUE! i=%s ,firstMin=%s, secondMin=%s, num=%s",i,num,firstMin,secondMin));
                return true;
            }
            System.out.println(String.format("i=%s ,firstMin=%s, secondMin=%s, num=%s",i,num,firstMin,secondMin));
        }
        return false;
        
    }



```

Test Case 1 -True
```
[1,5,0,4,1,3]

        i=0 ,firstMin=1, secondMin=1, num=2147483647
        i=1 ,firstMin=5, secondMin=1, num=5
        i=2 ,firstMin=0, secondMin=0, num=5
        i=3 ,firstMin=4, secondMin=0, num=4
        i=4 ,firstMin=1, secondMin=0, num=1
        TRUE! i=5 ,firstMin=3, secondMin=0, num=1


```

Test Case 2 - True

```
[20,100,10,12,5,13]

        i=0 ,firstMin=20, secondMin=20, num=2147483647
        i=1 ,firstMin=100, secondMin=20, num=100
        i=2 ,firstMin=10, secondMin=10, num=100
        i=3 ,firstMin=12, secondMin=10, num=12
        i=4 ,firstMin=5, secondMin=5, num=12
        TRUE! i=5 ,firstMin=13, secondMin=5, num=12   --> ?? should be 10,12,13!


```


Test Case 3- False

```
[0,4,2,1,0,-1,-3]

        i=0 ,firstMin=0, secondMin=0, num=2147483647
        i=1 ,firstMin=4, secondMin=0, num=4
        i=2 ,firstMin=2, secondMin=0, num=2
        i=3 ,firstMin=1, secondMin=0, num=1
        i=4 ,firstMin=0, secondMin=0, num=1
        i=5 ,firstMin=-1, secondMin=-1, num=1
        i=6 ,firstMin=-3, secondMin=-3, num=1

```

Test Case 4 - True

```

[1,6,2,5,1]

        i=0 ,firstMin=1, secondMin=1, num=2147483647
        i=1 ,firstMin=6, secondMin=1, num=6
        i=2 ,firstMin=2, secondMin=1, num=2
        TRUE! i=3 ,firstMin=5, secondMin=1, num=2

```

## Failed attempts

### Brute force - TLE

```


class Solution {
    public boolean increasingTriplet(int[] nums) {
        for (int i=0;i< nums.length-2;i++){     
            for (int j=i+1; j< nums.length-1; j++){
                if (nums[i]> nums[j])continue;
                for (int k=j+1; k<nums.length;k++){
                    if (nums[j]> nums[k])continue;
                    else if (nums[i]< nums[j] && nums[j]< nums[k]){
                        System.out.println(String.format("i=%s,j=%s,k=%s",i,j,k));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


```

### Three pointers - cannot pass all test cases

```java



class Solution {
    public boolean increasingTriplet(int[] nums) {

        for (int i=0 ; i<nums.length-2;i++){
            int j= i+1, k=nums.length-1;

            if ( nums[i] < nums[j] && nums[j]< nums[j+1]){
                System.out.println(String.format("TRUE i=%s, j=%s, k=%s",i,i+1,i+2));
                return true;
            }
            int j2=j;
            int k2=k;
            while(k2>j){
                 while(j2<k){
                    System.out.println(String.format("FINDING i=%s, j2=%s, k2=%s",i,j2,k2));
                    if (nums[i]<nums[j2]&& nums[j2]< nums[k2]){
                        System.out.println(String.format("TRUE i=%s, j=%s, k=%s",i,j,k));
                        return true;
                    }
                    j2++;
                 }
                 k2--;
                
            }
           
           
        }
        return false;
    }
}

/*
 0 1 2 3 4
[1,6,2,5,1] - answer is 0 , 2 , 3



 0 1          2 3 4
[4,5,2147483647,1,2]  ans = 0 , 1 , 2

 0 1 2 3 4 5
[1,5,0,4,1,3]

*/


```