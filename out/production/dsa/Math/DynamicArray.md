# Dynamic Array

Easy question - but it gave me alot of trouble.

Important note - the .set() method for ArrayList is only for updating the value in that index. It cannot add a new index (i.e. will not go beyond the max index).

https://www.hackerrank.com/challenges/dynamic-array/problem?isFullScreen=true

## The question

Its a pain in the ass. I will not write it here.


## The Code

Pay attention to the way to manipulate 2D ArrayList. The gap in my knowledge gave me alot of trouble for this question.

```java
 public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
    
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();
        int lastAnswer=0;
        
        for (int i=0; i<n;i++){
            arr.add(new ArrayList<Integer>());
        }
        
        for(List<Integer> list : queries){
            int operation = list.get(0);
            int x = list.get(1);
            int y = list.get(2);
            int idx = (x^lastAnswer)%n;
            if (operation ==1){
                
                //This will not work!!
                /*
Java, you cannot directly add an element at a specific index in an ArrayList if the list does not have enough elements to reach that index. The .set() method in ArrayList is used to replace an element at a specific index, not to add a new element at an index beyond the current size of the list.
                // List<Integer> newList= new ArrayList<>();
                // newList.add(y);
                // arr.set(idx,newList);
                */
                arr.get(idx).add(y);
            }else if (operation == 2){
                lastAnswer=arr.get(idx).get(y%arr.get(idx).size());
                answers.add(lastAnswer);
            }
        }
        System.out.println(answers.toString());
        return answers;

    }

```