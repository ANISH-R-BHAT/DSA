package BinarySearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[]arr={-22,3,9,45,333,456};
        int[]a={334,333,23,9,0,-98};
        System.out.println(BS(arr,22));
        System.out.println(BS(a,0));
    }
    public static int BS(int[]arr,int target){
        int start=0,end=(arr.length-1),mid;
        while(start<=end){
            mid=(start+end)/2;
            if (arr[mid]==target)
                return mid;
            if(arr[0]<arr[arr.length-1]){
                if(arr[mid]<target)
                    start=mid+1;
                else if(arr[mid]>target)
                    end=mid-1;
            }
            else{
                if(arr[mid]>target)
                    start=mid+1;
                else if(arr[mid]<target)
                    end=mid-1;
            }

        }
        return -1;
    }
}
