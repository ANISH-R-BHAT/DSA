package LinkedLists.BasicConcepts;

public class Main {
    public static void main(String[] args) {
        LL list=new LL();
        list.insertFirst(20);
        list.insertFirst(10);
        list.insertFirst(8);
        list.insertFirst(15);
        list.insertFirst(5);
        list.insertFirst(9);
        list.display();
//        list.reverseLLUsingRecursion();
//        list.reverseLL();
        list.reversePartOfLL();
        list.display();
    }
}
