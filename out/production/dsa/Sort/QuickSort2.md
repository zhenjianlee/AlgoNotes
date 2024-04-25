# QuickSort 2

Question is about quicksort - but with a twist. Need to partition to the sequence of the question.

```
My Output (stdout)

1 2 
1 2 3 
7 8 9 
1 2 3 5 7 8 9 

```

```
Expected Output
2 3
1 2 3
7 8 9
1 2 3 5 7 8 9

```

To implement this, need to follow reference code below. It is almost like merge sort. Create two array list left and right. 



## Reference Code - ankur_sharma - it works!

Put values into left or right depending on value against pivot.

Copy array list to array for left.

Insert pivot.

Copy array list to array for right.

Return pivot index.


```java
Solution in JAVA :- public class Solution {

    static int partition(int ar[], int minpos, int maxpos)
    {
        int p = ar[minpos];
        ArrayList<Integer> leftlist = new ArrayList<Integer>();
        ArrayList<Integer> rightlist = new ArrayList<Integer>();

        for(int i = minpos+1 ; i <= maxpos; i++)
            {
               if(ar[i] > p)
                   rightlist.add(ar[i]);
               else
                   leftlist.add(ar[i]);
            }
        copy(leftlist,ar,minpos);
        int ppos = leftlist.size()+minpos;
        ar[ppos] = p;
        copy(rightlist,ar,ppos+1);

        return minpos + leftlist.size();
    }

     static void copy(ArrayList<Integer> list, int ar[], int startIdx)
     {
             for(int num : list)
            {
               ar[startIdx++] = num;
            }
     }

    static void quickSort(int ar[], int minpos, int maxpos)
   {
        if(minpos >= maxpos) // '<=' is important not to do excessive recursion calls which makes more println
            return;

       int pos = partition (ar,minpos,maxpos);

        quickSort(ar,minpos,pos-1);
        quickSort(ar,pos+1,maxpos);

        printArray(ar,minpos, maxpos);
   }

    static void quickSort(int[] ar)
    {
        quickSort(ar,0,ar.length-1);
    }


    static void printArray(int[] ar,int start, int end) {

        for(int i = start; i <= end;i++) {
            System.out.print(ar[i]+" ");
            } System.out.println(""); }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        quickSort(ar);
    }
}

```


## My Code - can sort but doesnt print the partition as per question requirement

```java
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String total = scanner.nextLine();
        String numbers = scanner.nextLine().replaceAll(" ","");
        //System.out.println(String.format("numbers=%s",numbers));
        int[] arr = new int[numbers.length()];
        for (int i=0; i<numbers.length();i++){
            char ch = numbers.charAt(i);
            if (Character.isDigit(ch)){
                arr[i]=ch-'0';
            }
        }
        quickSort(arr,0,arr.length-1);
        //printArray(arr,0,arr.length-1);
        
    } 
    
    public static void quickSort(int[] arr, int start, int end){
        if (start>end){return;} // '<=' is important not to do excessive recursion calls which makes more println. if left like this there will to additional print array calls.
        
        int pivot = partition(arr, start,end);
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);
        printArray(arr,start,end);
    }
    
    /*       i
       [ 8 , 7 , 9]
    j
    */
    
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[start];
        int i= end+1;
        for (int j=end;j>start;j--){
            if (arr[j]> pivot){
                i--;
                swap(arr,i,j);
            }
        }
        i--;
        swap(arr,i,start);
        
        return i;
    }
    
    private static void swap (int[] arr, int idxA, int idxB){
        int temp = arr[idxA];
        arr[idxA]= arr[idxB];
        arr[idxB]= temp;
    }
    
    
    private static void printArray(int[] arr,int start, int end){
        for(int i =start ; i<=end ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}



```

## Merged code for easy testing and simulation

```java
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int[] arr = new int[total];
        for(int i=0; i<total;i++){
            arr[i]=scanner.nextInt();
        }
    
        quickSort(arr,0,total-1);
    } 
    
    public static void quickSort(int[] arr, int start, int end){
        if (start>=end){return;}
        
        int pivot = partition2(arr, start,end);
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);
        
        printArray(arr,start,end);
    }
    
    
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[start];
        int i= end+1;
        for (int j=end;j>start;j--){
            if (arr[j]> pivot){
                i--;
                swap(arr,i,j);
            }
        }
        i--;
        swap(arr,i,start);
        
        return i;
    }
    
     private static void swap (int[] arr, int idxA, int idxB){
        int temp = arr[idxA];
        arr[idxA]= arr[idxB];
        arr[idxB]= temp;
    }
    
    
    private static int partition2(int ar[], int minpos, int maxpos)
    {
        int p = ar[minpos];
        ArrayList<Integer> leftlist = new ArrayList<Integer>();
        ArrayList<Integer> rightlist = new ArrayList<Integer>();

        for(int i = minpos+1 ; i <= maxpos; i++)
            {
               if(ar[i] > p)
                   rightlist.add(ar[i]);
               else
                   leftlist.add(ar[i]);
            }
        copy(leftlist,ar,minpos);
        int ppos = leftlist.size()+minpos;
        ar[ppos] = p;
        copy(rightlist,ar,ppos+1);

        return minpos + leftlist.size();
    }
    
    private static void copy(ArrayList<Integer> list, int ar[], int startIdx)
     {
             for(int num : list)
            {
               ar[startIdx++] = num;
            }
     }
    
   
    private static void printArray(int[] arr,int start, int end){
        for(int i =start ; i<=end ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}


```