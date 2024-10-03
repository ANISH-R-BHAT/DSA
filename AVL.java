package BinaryTrees;

public class AVL {
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
    public AVL(){

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
        if(value<=node.value){
            node.left=insert(value,node.left);
        }
        if(value>node.value){
            node.right=insert(value,node.right);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return rotateNode(node);
    }
    private Node rotateNode(Node node){
        //Left Load
        if(height(node.left)-height(node.right)>1){
            //Left-Left
            if(height(node.left.left)-height(node.left.right)>0){
                return rightRotate(node);
            }
            //Left-Right
            if(height(node.left.right)-height(node.left.left)>0){
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        //Right Load
        if(height(node.left)-height(node.right)<-1){
            //Right-Right
            if(height(node.right.right)-height(node.right.left)>0){
                return leftRotate(node);
            }
            //Right-Left
            if(height(node.right.left)-height(node.right.right)>0){
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node node) {
        Node c=node.left;
        Node temp=c.right;
        c.right=node;
        node.left=temp;
        node.height=Math.max(height(node.left),height(node.right))+1;
        c.height=Math.max(height(c.left),height(c.right))+1;
        return c;
    }

    private Node leftRotate(Node node) {
        Node p=node.right;
        Node temp=p.left;
        p.left=node;
        node.right=temp;
        node.height=Math.max(height(node.left),height(node.right)+1);
        p.height=Math.max(height(p.left),height(p.right)+1);
        return p;
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

    public static void main(String[] args) {
        AVL tree=new AVL();
        for(int i=0;i<1000;i++){
            tree.insert(i);
        }
        System.out.println(tree.height());
    }
}
