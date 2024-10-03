package BinaryTrees.Questions;

import BinaryTrees.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }
    }
    private Node root;

    public void insert(int value){
        root=insert(value,root);
    }
    public Node insert(int value,Node node){
        if(node==null){
            node=new Node(value);
            return node;
        }
        if(value<node.value){
            node.left=insert(value,node.left);
        }
        if(value>node.value){
            node.right=insert(value,node.right);
        }
        return node;
    }
    public void populateSorted(int[] nums){
        populateSorted(nums,0,nums.length-1);
    }
    public void populateSorted(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        this.insert(nums[mid]);
        populateSorted(nums,start,mid);
        populateSorted(nums,mid+1,end);
    }

    public void display(){
        display(root,new LinkedList<>());
        System.out.println("END");
    }
    private void display(Node node, Queue<Node> queue){
//        if(node==null){
//            queue.remove();
//            return;
//        }
        if(node!=null){
            System.out.print(node.value+" -> ");
            queue.add(node.left);
            queue.add(node.right);
        }
        if(queue.isEmpty()){
            return;
        }
        display(queue.remove(),queue);
    }

    public static void main(String[] args) {
        BFSTraversal tree=new BFSTraversal();
        int[] nums={1,2,3,4,5,6,7,8,9,10,11};
        tree.populateSorted(nums);
        tree.display();
    }
}
