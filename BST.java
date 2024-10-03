package BinaryTrees;

public class BST {
    private static class Node{
        int value;
        Node left;
        Node right;
        int height;
        public Node(int value){
            this.value=value;
        }
        public int getValue(){
            return this.value;
        }
    }
    private Node root;
    public BST(){

    }
    public void insert(Node node,int value){
        if(node==null){
            return;
        }
        Node prev=null;
        while(node!=null){
            prev=node;
            if(value<=node.value){
                node=node.left;
            }else{
                node=node.right;
            }
        }
        Node temp=new Node(value);
        if(value<=prev.value){
            prev.left=temp;
        }else{
            prev.right=temp;
        }
    }
    public void insert2(int value){
        insert2(value,null,root);
    }
    public void insert2(int value,Node prev,Node cur){
        if(cur==null && prev==null){
            Node temp=new Node(value);
            root=temp;
            return;
        }
        if(cur==null && prev!=null){
            Node temp=new Node(value);
            if(value<=prev.value){
                prev.left=temp;
            }else{
                prev.right=temp;
            }
            return;
        }
        if(value<=cur.value){
            insert2(value,cur,cur.left);
        }else{
            insert2(value,cur,cur.right);
        }
        cur.height=Math.max(height(cur.left),height(cur.right))+1;
    }
    public void insert3(int value){
        root=insert3(value,root);
    }
    public Node insert3(int value,Node node){
        if(node==null){
            node=new Node(value);
            return node;
        }
        if(value<node.value){
            node.left=insert3(value,node.left);
        }
        if(value>node.value){
            node.right=insert3(value,node.right);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if(node==null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void display(){
        display(root);
    }
    public void populateSorted(int[] nums){
        populateSorted(nums,0,nums.length-1);
    }
    public void populateSorted(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        this.insert3(nums[mid]);
        populateSorted(nums,start,mid);
        populateSorted(nums,mid+1,end);
    }
    public void display(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.value+"  "+node.height);
        display(node.left);
        display(node.right);

    }
    public int height(){
        return height(root);
    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root==null;
    }

    public static void main(String[] args) {
        BST bst=new BST();
//        bst.insert2(15);
//        bst.insert2(8);
//        bst.insert2(6);
//        bst.insert2(20);
//        bst.insert2(10);
//        bst.insert3(15);
//        bst.insert3(8);
//        bst.insert3(6);
//        bst.insert3(20);
//        bst.insert3(10);
//        bst.insert3(11);
        int[] nums={1,2,3,4,5,6,7,8,9,10};
        bst.populateSorted(nums);
        bst.display();
        System.out.println(bst.isBalanced());
    }
}
