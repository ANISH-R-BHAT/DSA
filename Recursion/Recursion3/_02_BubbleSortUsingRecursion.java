package Recursion.Three;

import java.util.Arrays;

public class BubbleSortUsingRecursion {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1,8};
        bubbleSort(arr,0,0);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr, int i, int j){
        if(i==(arr.length)-1){ //or i==0
            return;
        }
        if(j<(arr.length)-i-1){ //or i>j
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
            bubbleSort(arr,i,j+1);
        }
        else{
            bubbleSort(arr,i+1,0); //or i-1
        }
    }
}
