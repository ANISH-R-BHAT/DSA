package BinarySearch;

public class SquareRoot {
    public static int Root(int num){
        int low=0,high=num,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(mid*mid==num){
                return mid;
            }
            else if(mid*mid>num){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(Root(1000));
    }
}
