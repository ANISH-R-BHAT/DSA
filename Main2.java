package LinkedLists.BasicConcepts;

public class Main2 {
    public static void main(String[] args) {
        DLL list=new DLL();
        list.insertFirst(23);
        list.insertFirst(12);
        list.insertLast(10);
        list.insertLast2(15);
        list.insertUsingIndex(24,0);
        list.display2();
        list.reverseDisplay();
    }
}
