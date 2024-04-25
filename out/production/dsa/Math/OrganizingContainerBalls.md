# Organizing Containers of Balls

Matrix questions - check if 2D array , possible to rearrange each ball type to its corresponding container

Container arr.get (i) , i is the container
Ball type = j, column.get(j)=count of ball

## The question
https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem?isFullScreen=true

## The solution

My solution only solved 2 test cases. Because , I did not take into account the total for each container AND I don't understand why need to sort

Referenced:-
I think a little simpler to explain is:
1. Make a table of box totals (capacity of each box)
2. Make a table of ball totals (total quantity of each ball type)
3. Sort both tables
4. If they are identical print Possible, otherwise print Impossible

```java
public static String organizingContainers(List<List<Integer>> container) {
    // Write your code here
    boolean flag=true;
    long[] mapBallsTotal = new long[container.size()];
    long[] mapContainerTotal = new long[container.size()];

    for (int i=0; i<container.size();i++){
        for (int j=0; j<container.get(i).size();j++){
            mapBallsTotal[j]+=container.get(i).get(j);
            mapContainerTotal[i] += container.get(i).get(j);
        }
    }
    printArray(mapBallsTotal,"mapBallsTotal unsorted");
    printArray(mapContainerTotal,"mapContainerTotal unsorted");

    // must sort, else it would not work!
    Arrays.sort(mapBallsTotal);
    Arrays.sort(mapContainerTotal);

    printArray(mapBallsTotal,"mapBallsTotal SORTED");
    printArray(mapContainerTotal,"mapContainerTotal SORTED");

    for(int i=0; i<container.size(); i++){
        if (mapBallsTotal[i] != mapContainerTotal[i])flag=false;
    }
    //System.out.println("MapBallsTotal="+Arrays.toString(mapBallsTotal));
    //System.out.println("mapContainerTotal="+Arrays.toString(mapContainerTotal));
    if (flag)return "Possible";
    return"Impossible";

}

private static void printArray(long[]arr, String message){
    System.out.println("------"+message+"------");
    System.out.println(Arrays.toString(arr));
}
    
    /*
     Case 1 - Possible
     ______
                   0  1                 0  1
    container 0 : [1, 1] container 1 : [1, 1]
    
    type 0 : 2 , type 1 : 2 , total : 4
     
     
     Case 2 - Impossible
     ______
                    0  1                0  1
     container 0 : [0, 2] container 1 :[1, 1]
     
     type 0 : 1 , type 1 : 3 , total : 4
     
     Sample Case 3 (Possible but returned Impossible) -
     ----------------
                    0 1 2                0 1 2                0 1 2
     container 0 : [0 2 1] container 1 :[1 1 1] container 2 :[2 0 0]
    
                    1 1 2                0 1 2                0 0 
                    0 1 2                1 1 2                 0 0
                    0 
    
     container0: 3 , container1: 3 , container2: 2
     type 0 : 3 , type 1 : 3 , type 2: 2 , total = 8
     
     

     */
```

Maybe below is the reason why it needs to be sorted. 

The total number of balls and its containers are rearranged after swapping. 

So we need to sort it out to see if all tallies!

```dtd
    ------- TEST CASE EXAMPLE ----- 
        1 -> TEST CASE

        4 -> 4 ROWS AND COLUMNS

        997612619 934920795 998879231 999926463
        960369681 997828120 999792735 979622676
        999013654 998634077 997988323 958769423
        997409523 999301350 940952923 993020546

        ------mapBallsTotal unsorted------
        [3954405477, 3930684342, 3937613212, 3931339108]

        ------mapContainerTotal unsorted------
        [3931339108, 3937613212, 3954405477, 3930684342]

        ------mapBallsTotal SORTED------
        [3930684342, 3931339108, 3937613212, 3954405477]

        ------mapContainerTotal SORTED------
        [3930684342, 3931339108, 3937613212, 3954405477]

```
