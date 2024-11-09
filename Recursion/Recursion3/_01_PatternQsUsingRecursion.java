package Recursion.Three;

public class PatternQsUsingRecursion {
    public static void main(String[] args) {
        printTriangle(4,0);
        printTriangle2(4,0);
    }
    static void printTriangle(int row,int col){
        if(row==0)
            return;
        if(row>col){
            System.out.print("*");
            printTriangle(row,col+1);
        }
        else{
            System.out.println();
            printTriangle(row-1,0);
        }
    }

    static void printTriangle2(int row,int col){
        if(row==0)
            return;
        if(row>col){
            printTriangle2(row,col+1);
            System.out.print("*");
        }
        else{
            printTriangle2(row-1,0);
            System.out.println();
        }
    }
}
