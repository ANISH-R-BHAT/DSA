package BinaryTrees.Questions;
import java.util.*;

public class LevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private class Node{
        int val;
        Node left;
        Node right;
        Node next;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize= queue.size();
            List<Integer> list=new ArrayList<>(levelSize);
            for(int i=0;i<levelSize;i++){
                TreeNode cur=queue.poll();
                list.add(cur.val);
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize= queue.size();
            List<Integer> list=new ArrayList<>(levelSize);
            for(int i=0;i<levelSize;i++){
                TreeNode cur=queue.poll();
                list.add(cur.val);
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            result.add(0,list); //Just modified this line :)
        }
        return result;
    }

     //https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
     public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            double sum=0;
            for(int i=0;i<levelSize;i++){
                TreeNode cur=queue.poll();
                sum+=cur.val;
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            result.add(sum/levelSize);
        }
        return result;
    }

    public TreeNode findSuccessor(TreeNode root,int key){
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){ //for loop is not necessary here
            TreeNode cur=queue.poll();
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
            if(key==cur.val){
                return queue.peek();
            }
        }
        return null;
    }

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
        boolean rev=false;//Be cautious of this line(VIP)
        while(!deque.isEmpty()){
            int levelSize= deque.size();
            List<Integer> list=new ArrayList<>(levelSize);
            if(rev){
                for(int i=0;i<levelSize;i++){
                    TreeNode cur=deque.removeLast();
                    if(cur.right!=null){ //Be cautious whether to add left element first or right one
                        deque.addFirst(cur.right);
                    }
                    if(cur.left!=null){
                        deque.addFirst(cur.left);
                    }
                    list.add(cur.val);
                }
            }else{
                for(int i=0;i<levelSize;i++){
                    TreeNode cur=deque.removeFirst();
                    if(cur.left!=null){
                        deque.addLast(cur.left);
                    }
                    if(cur.right!=null){
                        deque.addLast((cur.right));
                    }
                    list.add(cur.val);
                }
            }
            rev=!rev;
            result.add(list);
        }
        return result;
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize= queue.size();
            Node cur=root;
            for(int i=0;i<levelSize;i++){
                cur=queue.poll();
                if(!queue.isEmpty()){
                    cur.next=queue.peek();
                }
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            cur.next=null;
        }
        return root;
    }

    //Same problem but different approach
    public Node connect2(Node root){
        return connect2(root,root);
    }
    private Node connect2(Node root,Node node){
        if(node==null){
            return null;
        }
        node.left.next=node.right;
        /*
            if(node.next==null){
                node.right.next=null;
            }else{
                node.right.next=node.next.left;
            }
        */
        if(node.next!=null){ //we can also write above code block instead of this, however we used this since next will be null by default
            node.right.next=node.next.left;
        }
        connect2(root,node.left);
        connect2(root,node.right);
        return root;
    }
    public Node connect3(Node root){
        if(root==null){
            return null;
        }
        Node leftmost=root;
        while(leftmost.left!=null){
            Node cur=leftmost;
            while(cur!=null){
                cur.left.next=cur.right;
                if(cur.next!=null){
                    cur.right.next=cur.next.left;
                }
                cur=cur.next;
            }
            leftmost=leftmost.left;
        }
        return root;
    }

    //https://leetcode.com/problems/binary-tree-right-side-view/description/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            TreeNode cur=root;
            for(int i=0;i<levelSize;i++){
                cur=queue.poll();
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            result.add(cur.val);
        }
        return result;
    }

    //https://leetcode.com/problems/cousins-in-binary-tree/
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx=findNode(root,x);
        TreeNode yy=findNode(root,y);

        return (levelOf(root,xx,0)==levelOf(root,yy,0) && !isSiblings(root,xx,yy));
    }
    private TreeNode findNode(TreeNode node,int x) {
        if(node==null){
            return null;
        }
        if(node.val==x){
            return node;
        }
        TreeNode n=findNode(node.left,x);
        if(n!=null){
            return n;
        }
        return findNode(node.right,x);
    }
    private int levelOf(TreeNode node,TreeNode xx,int level) {
        if(node==null){
            return 0;
        }
        if(node==xx){
            return level;
        }
        int l=levelOf(node.left,xx,level+1);
        if(l!=0){
            return l;
        }
        return levelOf(node.right,xx,level+1);
    }
    private boolean isSiblings(TreeNode node,TreeNode xx, TreeNode yy) {
        if(node==null){
            return false;
        }
        /*
            if((node.left==xx && node.right==yy) || (node.left==yy && node.right==xx)){
                return true;
            }
            boolean result=isSiblings(node.left,xx,yy);
            if(result){
                return result;
            }
            return isSiblings(node.right,xx,yy);
        */
        //The above code is reduced into single line of code:
        return((node.left==xx && node.right==yy) || (node.left==yy && node.right==xx) || isSiblings(node.left,xx,yy) || isSiblings(node.right,xx,yy));
    }
}
