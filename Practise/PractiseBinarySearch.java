package Practise;

public class PractiseBinarySearch {
    
    public static void main(String[] args){
        int[] array = new int[]{ 1 , 32, 68 , 91, 100 , 130 , 150};

        int idx = binarySearch(array, 32);
        System.out.println("The index found in array is ="+idx);
    }   

    private static int binarySearch(int[] a, int target){

        int low =0;
        int high = a.length-1;
        int mid = low +(high-low)/2;

        while (low<=high){
            mid = low +(high-low)/2;
            if (a[mid]==target)return mid;
            else if (a[mid]>target){
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return -1;
    }
}
