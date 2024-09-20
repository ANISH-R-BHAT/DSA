package Recursion.Two;

import java.util.ArrayList;

public class LinearSearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr={7,4,6,7,7,9,7};
        System.out.println(findElement(arr,12));
        System.out.println(helper2(arr,72,0));
//        findAllIndices(arr,7,0);
//        System.out.println(list);
        ArrayList<Integer> list=new ArrayList<>();
//        System.out.println(IndicesList(arr,7,0,list));
        System.out.println(ListOfIndices(arr,7,0));
    }
    static int findElement(int[] nums,int target){
        return helper(nums,target,0);
    }
    private static int helper(int[] nums,int target,int p){
        if(p==nums.length){
            p=-1;
            return p;
        }
        if(nums[p]==target)
            return p;
        return helper(nums,target,p+1);
    }
    private static boolean helper2(int[] nums,int target,int p){
        if(p==nums.length){
            return false;
        }
        return nums[p]==target || helper2(nums,target,p+1);
    }
    static ArrayList<Integer> list=new ArrayList<>();
    private static void findAllIndices(int[] nums,int target,int p){
        if(p==nums.length)
            return;
        if(nums[p]==target)
            list.add(p);
        findAllIndices(nums,target,p+1);
    }

    private static ArrayList<Integer> IndicesList(int[] nums,int target,int p,ArrayList<Integer> list){
        if(p==nums.length)
            return list;
        if(nums[p]==target)
            list.add(p);
        return IndicesList(nums,target,p+1,list);
    }

    private static ArrayList<Integer> ListOfIndices(int[] nums,int target,int p){
        ArrayList<Integer> list=new ArrayList<>();
        if(p==nums.length)
            return list;
        //this will contain answer for that function call only
        if(nums[p]==target){
            list.add(p);
        }
        list.addAll(ListOfIndices(nums,target,p+1));
        return list;
    }
}
