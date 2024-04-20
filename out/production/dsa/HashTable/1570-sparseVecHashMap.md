# Premium 1570. Dot Product of Two Sparse Vectors

Practise using HashMap in OOP environment

## Question

Medium
Topics
Companies
Hint

Given two sparse vectors, compute their dot product.

Implement class SparseVector:

    SparseVector(nums) Initializes the object with the vector nums
    dotProduct(vec) Compute the dot product between the instance of SparseVector and vec

A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.

Follow up: What if only one of the vectors is sparse?

 

Example 1:

Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
Output: 8
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8

Example 2:

Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
Output: 0
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0

Example 3:

Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
Output: 6

 

Constraints:

    n == nums1.length == nums2.length
    1 <= n <= 10^5
    0 <= nums1[i], nums2[i] <= 100

## My Code

```java
class SparseVector {

    private HashMap<Integer,Integer>map;
    
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for (int i=0;i<nums.length; i++){
            if (nums[i]!=0){
                map.put(i,nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        HashMap<Integer,Integer> map2 = vec.getMap();
        int sum=0;
        for (Map.Entry<Integer, Integer> entry : this.map.entrySet()){
           int thisVal= entry.getValue();
           int thatVal= map2.getOrDefault(entry.getKey(),0);
           sum+= (thisVal*thatVal);
        }
        return sum;
    }

    private HashMap<Integer,Integer> getMap(){
        return this.map;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);

```

## Notes

I see other solutions accesses the HashMap using vec.map . I was taught never to access values directly but to use getters and setters via function. So code is longer (and maybe takes a few more miliseconds)