public class Demo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtBeginning(9);
        list.insertAtBeginning(5);
        list.insertAtBeginning(6);
        list.insertAtBeginning(2);
        list.insertAtEnd(1000);
        // list.deleteAtPos(0);
        // list.getIndexVal(2);
        // list.updateAtPos(2, 10);
        // list.updateAtPosOfEnd(50);
        list.containsAtVal(510);
        list.searchVal(100);
        // list.deleteAtEnd();
        list.display();
    }
}
