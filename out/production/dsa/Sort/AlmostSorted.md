# Almost Sorted

https://www.hackerrank.com/challenges/almost-sorted/

## The Question

Given an array of integers, determine whether the array can be sorted in ascending order using only one of the following operations one time.

Swap two elements.
Reverse one sub-segment.
Determine whether one, both or neither of the operations will complete the task. Output is as follows.

If the array is already sorted, output yes on the first line. You do not need to output anything else.

If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:

If elements can only be swapped,  and , output swap l r in the second line.  and  are the indices of the elements to be swapped, assuming that the array is indexed from  to .
If elements can only be reversed, for the segment , output reverse l r in the second line.  and  are the indices of the first and last elements of the subarray to be reversed, assuming that the array is indexed from  to . Here  represents the subarray that begins at index  and ends at index , both inclusive.
If an array can be sorted both ways, by using either swap or reverse, choose swap.

If the array cannot be sorted either way, output no on the first line.
Example

Either swap the  and  at indices 3 and 4, or reverse them to sort the array. As mentioned above, swap is preferred over reverse. Choose swap. On the first line, print yes. On the second line, print swap 3 4.

Function Description

Complete the almostSorted function in the editor below.

almostSorted has the following parameter(s):

int arr[n]: an array of integers
Prints

Print the results as described and return nothing.
Input Format

The first line contains a single integer , the size of .
The next line contains  space-separated integers  where .

Constraints



All  are distinct.

Output Format

If the array is already sorted, output yes on the first line. You do not need to output anything else.

If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:

a. If elements can be swapped,  and , output swap l r in the second line.  and  are the indices of the elements to be swapped, assuming that the array is indexed from  to .

b. Otherwise, when reversing the segment , output reverse l r in the second line.  and  are the indices of the first and last elements of the subsequence to be reversed, assuming that the array is indexed from  to .

 represents the sub-sequence of the array, beginning at index  and ending at index , both inclusive.

If an array can be sorted by either swapping or reversing, choose swap.

If you cannot sort the array either way, output no on the first line.
Sample Input 1

STDIN   Function
-----   --------
2       arr[] size n = 2
4 2     arr = [4, 2]
Sample Output 1

yes  
swap 1 2
Explanation 1

You can either swap(1, 2) or reverse(1, 2). You prefer swap.

Sample Input 2

3
3 1 2
Sample Output 2

no
Explanation 2

It is impossible to sort by one single operation.

Sample Input 3

6
1 5 4 3 2 6
Sample Output 3

yes
reverse 2 5
Explanation 3

You can reverse the sub-array d[2...5] = "5 4 3 2", then the array becomes sorted.

## My Code - Try to replicate referenced Code

```java
public static void almostSorted(List<Integer> arr) {
    // Write your code here
    //for swap operation
    int countSort=0;
    List<Integer> indexesSwap = new ArrayList<>();
    
    //for reverse operation
    int window=0;
    List<Integer> indexesRev = new ArrayList<>();
    
    //reference sorted array
    List<Integer> sorted = new ArrayList<>(arr);
    Collections.sort(sorted);
        
        //swap
        for (int i=0;i<arr.size();i++){
            if (arr.get(i)!=sorted.get(i)){
                countSort++;
                indexesSwap.add(i+1);
                indexesSwap.add(sorted.indexOf(arr.get(i))+1);
            }
        }
        
        //reverse
        for (int i=0; i<arr.size()-1;i++){
            if (arr.get(i) > arr.get(i+1)){
                window++;
            } else{
                if (window>1){
                    List<Integer> startArray= new ArrayList<>(arr.subList(0,i-window));
                    List<Integer> revArray = new ArrayList<>(arr.subList(i-window,i+1));   
                    List<Integer> endArray = new ArrayList<>(arr.subList(i+1,arr.size())); 
                    Collections.reverse(revArray);
                    //rev function, arr=[1 2] [3, 4, 5] [6]
                     /*
                        0 1 2 3 4 5 - Idx
                        1 5 4 3 2 6 - Arr
                          |     i 
                          i-win   
                        window=3
                    */
                    arr.clear();
                    arr.addAll(startArray);
                    arr.addAll(revArray);
                    arr.addAll(endArray);
                    
                    indexesRev.add(i-window+1);
                    indexesRev.add(i+1);
                    
                    //System.out.println("rev function, arr="+startArray.toString()+" "+revArray.toString()+ " "+endArray.toString());
                    break;  
                }else{
                    window=0;
                }
            }
        }
        if (countSort==2){
            System.out.println("yes");
            System.out.println("swap "+indexesSwap.get(0)+" "+indexesSwap.get(1));
        }else if (arr.equals(sorted)){
            System.out.println("yes");
            System.out.println("reverse "+indexesRev.get(0)+" "+indexesRev.get(1));
        }else{
            System.out.println("no");
        }
    }

```

## Referenced Code 

khalidmarwa786

https://www.hackerrank.com/challenges/almost-sorted/forum

```java
public static void almostSorted(List<Integer> arr) {
    List<Integer> sorted = new ArrayList<>(arr);
    Collections.sort(sorted);
    int swapCount = 0;
    int segmentSize = 0;
    List<Integer> indices = new ArrayList<>();

    // Swap
    for (int i = 0; i < arr.size(); i++) {
        if (arr.get(i) != sorted.get(i)) {
            swapCount++;
            indices.add(i + 1);
            indices.add(arr.indexOf(sorted.get(i)) + 1);
        }
    }

    // Reverse
    for (int i = 0; i < arr.size() - 1; i++) {
        if (arr.get(i) > arr.get(i + 1)) {
            segmentSize++;
        } else {
            if (segmentSize > 1) {
                List<Integer> startArr = new ArrayList<>(arr.subList(0, i - segmentSize));
                List<Integer> subArr = new ArrayList<>(arr.subList(i - segmentSize, i + 1));
                List<Integer> endArr = new ArrayList<>(arr.subList(i + 1, arr.size()));

                Collections.reverse(subArr);
                arr.clear();
                arr.addAll(startArr);
                arr.addAll(subArr);
                arr.addAll(endArr);

                indices.add(i + 1);
                indices.add(i - segmentSize + 1);
                break;
            }
            segmentSize = 0;
        }
    }

    if (swapCount == 2) {
       System.out.println("yes");
       System.out.println("swap " + indices.get(0) + " " + indices.get(1));
    } else if (arr.equals(sorted)) {
       System.out.println("yes");
       System.out.println("reverse " + indices.get(indices.size() - 1) + " " + indices.get(indices.size() - 2));
    } else {
       System.out.println("no");
    }
}

```