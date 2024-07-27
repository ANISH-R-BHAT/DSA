package BinarySearch;

import java.util.Arrays;

public class BinarySearch2D {
    public static int[] search(int[][] nums,int target){
        int[] position={-1,-1};
        int row=0, column=nums[0].length-1;
        int rowLength=nums.length;
        while(row<rowLength && column>=0){
            if(nums[row][column]==target){
                position[0]=row;
                position[1]=column;
                return position;
            }
            else if(nums[row][column]>target){
                column--;
            }
            else{
                row++;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[][]nums={{1,2,3},{4,5,6},{34,35,100},{46,56,121}};
        int[] position=search(nums,146);
        System.out.println(Arrays.toString(position));
    }
}
