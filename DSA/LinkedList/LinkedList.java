import java.util.Iterator;

/*
 * Linked List
 * 
 * Insert at Beginning
 * Display
 * Insert at any pos
 * Delete at any pos
 * 
 * generics
 */

public class LinkedList<T> implements Iterable<T> {
    Node head;

    class Node {
        T data;
        Node next;

        Node(T val) {
            data = val;
            next = null;
        }
    }

    LinkedList() {
        head = null;
    }

    public void display() {

        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty. Cannot update the last Node");
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; // Jump...
        }
        System.out.println(); // Add a new line after printing the list.

    }

    public void insertAtBeginning(T val) {

        Node newNode = new Node(val);
        // when the list is empty
        if (head == null) {
            head = newNode;
        } else { // list is not empty
            newNode.next = head;
            head = newNode;
        }

    }

    public void insertAtPos(int pos, T val) {

        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty. Cannot update the last Node");
        }

        if (pos == 0) {
            insertAtBeginning(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;

        for (int i = 1; i < pos; i++) {
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid position: " + pos);
            }
            temp = temp.next;
        }

        if (temp == null) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        newNode.next = temp.next;
        temp.next = newNode;

    }
    
    //Added the new node at last node. 
    public void insertAtEnd(T val) {

        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty. Cannot insert at the end.");
        }
    
        Node newNode = new Node(val);
        Node temp = head;
    
        while (temp.next != null) {
            temp = temp.next;
        }
    
        temp.next = newNode;
    
        System.out.println("Successfully added last node: " + val);

    }
    
    public void deleteAtPos(int pos) {

        if (head == null) {
            throw new IndexOutOfBoundsException("Deletion attempted on empty list");
        }
        if (pos == 0) {
            deleteAtBeginning();
            return;
        }

        Node temp = head;
        Node prev = null;

        for (int i = 0; i < pos; i++) {
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid position: " + pos);
            }
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }
        prev.next = temp.next;
    
    }

    public void deleteAtBeginning() {

        if (head == null) {
            throw new IndexOutOfBoundsException("Deletion attempted on empty list");
        }
        head = head.next;

    }

    public void deleteAtEnd() {

        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty. Cannot delete the last node.");
        }
    
        if (head.next == null) {
            // If there is only one node in the list, set head to null
            head = null;
            System.out.println("Successfully deleted the last node.");
            return;
        }
    
        Node temp = head;
        Node prev = null;
    
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
    
        // Now temp is the last node, and prev is the second-to-last node
        prev.next = null;
    
        System.out.println("Successfully deleted the last node, the node is :" + temp.data);
    }

    public void getIndexVal(int pos) {

        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty. Cannot update the last Node");
        }

        Node temp = head;
        for (int i = 0; i < pos; i++) {
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid position: " + pos);
            }
            temp = temp.next;
        }
        if (temp == null) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }
        System.out.println("Your checking possion value is : " + temp.data);

    }
    //Update at any possition but we won't update at last node.
    public void updateAtPos(int pos, T val) {

        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty. Cannot update the last Node");
        }
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid position: " + pos);
            }
            temp = temp.next;
        }
        if (temp == null) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }
        temp.data = val;

    }
    //Update at last possition only.
    public void updateAtPosOfEnd(T val) {
        
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty. Cannot update the last Node");
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.data = val;
        System.out.println("Last node is updated with value "+ val);

    }
    //Check the value in the list or not
    public void containsAtVal(T val) {

        boolean contain = false;
        Node temp = head;
        while(temp != null) {
            if (temp.data.equals(val)) {
                contain = true;
                break;
            }
            temp = temp.next;
        }
        if (contain) {
            System.out.print("Your data is found: " + contain);
        } else {
            System.out.print("your data "+ val+ " is not found: "+ contain);
        }

    }
    //Search value and return possition.
    public void searchVal(T val) {

        Node temp = head;
        int position = 0;
        boolean found = false;
        while (temp != null) {
            position += 1;
            if (temp.data.equals(val)) {
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (found) {
            System.out.println("Your value " + val + " is found at position: " + position);
        } else {
            System.out.println("Your value " + val + " is not found in the list.");
        }

    }    

    //Reverse Node list.
    public void reverse() {

        Node prev = null;
        Node current = head;
        Node next = head.next;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
