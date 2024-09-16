package BinarySearch;
import java.util.Scanner;
public class InfiniteArray {
    public static int position(int[]arr,int target){
        int start=0;
        int end=1;
        int temp;
        while(arr[end]<target){
            temp=end;
            end=end+2*(end-start+1);
            start=temp+1;
        }
        return BS(arr,target,start,end);
    }
    public static int BS(int[]arr,int target,int start,int end){
        int mid;
        while(start<=end){
            mid=(start+end)/2;
            if (arr[mid]==target)
                return mid;
            else if(arr[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=2*i;
        }
        System.out.println(position(arr,900));
    }
}
