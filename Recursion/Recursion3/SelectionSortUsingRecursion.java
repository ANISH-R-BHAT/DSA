package Recursion.Three;

import java.util.Arrays;

public class SelectionSortUsingRecursion {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
//        selectionSort(arr,arr.length-1);
        sort(arr,0,0,0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr,int last){
        if(last==0)
            return;
        int index=maxElementIndex(arr,0,last,0);
        int temp=arr[last];
        arr[last]=arr[index];
        arr[index]=temp;
        selectionSort(arr,last-1);
    }
    static int maxElementIndex(int[] arr,int p,int end,int index){
        if(p>end)
            return index;
        if(arr[index]<arr[p]){
            index=p;
        }
        return maxElementIndex(arr,p+1,end,index);
    }
    static void sort(int[] arr,int i,int j,int max){
        if(i==(arr.length-i-1)){
            return;
        }
        if(j<(arr.length)-i-1){
            if(arr[max]<arr[j]){
                sort(arr,i,j+1,j);
            }
            else{
                sort(arr,i,j+1,max);
            }
        }
        else{
            int temp=arr[max];
            arr[max]=arr[(arr.length-i-1)];
            arr[(arr.length)-i-1]=temp;
            sort(arr,i+1,0,0);
        }
    }
}
