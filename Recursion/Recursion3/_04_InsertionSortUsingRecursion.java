package Recursion.Three;

import java.util.Arrays;

public class InsertionSortUsingRecursion {
    public static void main(String[] args) {
        int[] arr={-1,5,4,3,2,1};
        insertionSort(arr,1,1);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr,int i,int j){
        if(i==arr.length)
            return;
        if(j>=1){
            if(arr[j-1]>arr[j]){
                int temp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;
                insertionSort(arr,i,j-1);
            }
            else{
                insertionSort(arr,i+1,i+1);
            }
        }
        else{
            insertionSort(arr,i+1,i+1);
        }
    }
}
