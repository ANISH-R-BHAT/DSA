package BinaryTrees;

import java.util.Scanner;

public class BinaryTree {
    public BinaryTree(){

    }
    private Node root;
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }
    }

    public void populate(Scanner scanner){
        System.out.println("Enter the root node:");
        int value=scanner.nextInt();
        root=new Node(value);
        populate(scanner,root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter the left of "+node.value);
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of "+node.value);
            int value=scanner.nextInt();
            node.left=new Node(value);
            populate(scanner,node.left);
        }

        System.out.println("Do you want to enter the right of "+node.value);
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of "+node.value);
            int value=scanner.nextInt();
            node.right=new Node(value);
            populate(scanner,node.right);
        }
    }
    public void display(){
        display(root,"");
    }
    private void display(Node node,String indent){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            System.out.println(indent+"\t"+node.value);
            return;
        }
        display(node.right,indent+"\t");
        System.out.println(indent+node.value);
        display(node.left,indent+"\t");
    }

    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        tree.populate(new Scanner(System.in));
        tree.display();
    }
}
