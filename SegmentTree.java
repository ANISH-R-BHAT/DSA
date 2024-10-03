package BinaryTrees;

public class SegmentTree {
    private static class Node{
        int data;
        int start;
        int end;
        Node left;
        Node right;
        public Node(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    private Node root;
    public SegmentTree(int[] arr){
        this.root=constructTree(arr,0,arr.length-1);

    }
    public Node constructTree(int[] arr,int start,int end){
        Node node=new Node(start,end);
        if(start>=end){
            node.data=arr[start];
            return node;
        }
        int mid=start+(end-start)/2;
        node.left=constructTree(arr,start,mid);
        node.right=constructTree(arr,mid+1,end);
        node.data=node.left.data+node.right.data;
        return node;
    }
    public int query(int queryStart,int queryEnd){
        return query(this.root,queryStart,queryEnd);
    }

    private int query(Node node, int queryStart, int queryEnd) {
        if(node.start>queryEnd || node.end<queryStart){
            return 0;
        }
        if(node.start>=queryStart && node.end<=queryEnd){
            return node.data;
        }
        return query(node.left,queryStart,queryEnd)+query(node.right,queryStart,queryEnd);
    }
    public void update(int index,int value){
        this.root=update(root,index,value);
    }

    private Node update(Node node, int index, int value) {
        if(index==node.start && index==node.end){
           node.data=value;
           return node;
        }
        if(index<node.start || index>node.end){
            return node;
        }else{
            node.left=update(node.left,index,value);
            node.right=update(node.right,index,value);
        }
        node.data=node.left.data+node.right.data;
        return node;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println("["+node.start+","+node.end+"] - "+node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        int[] nums={3,8,7,6,-2,-8,4,9};
        SegmentTree tree=new SegmentTree(nums);
        tree.update(3,10);
        tree.preOrder();
//        System.out.println(tree.query(4,4));

    }



}
