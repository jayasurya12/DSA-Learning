class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}


public class MergeSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: if list is empty or has only one node, it is already sorted
        }
        
        // Find the middle of the list
        ListNode mid = findMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null; // Split the list into two halves
        
        // Recursively sort the two halves
        ListNode sortedLeft = sortList(head);
        ListNode sortedRight = sortList(midNext);
        
        // Merge the sorted halves
        return merge(sortedLeft, sortedRight);
    }
    
    // Function to find the middle of the list using slow and fast pointers
    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // Function to merge two sorted lists
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify code
        ListNode current = dummy;
        
        // Merge the two lists until one of them becomes null
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        
        // Append the remaining nodes of the non-null list
        if (left == null) current.next = right;
        if (right == null) current.next = left;

        return dummy.next; // Return the merged list
    }

    public static void printList(ListNode head, String commaString) {
        System.out.println(commaString);
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("---------------finished;;;;;;;--------------");
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
    
        ListNode Node = new ListNode(2);
        Node.next = new ListNode(4);
        Node.next.next = new ListNode(7);
        Node.next.next.next = new ListNode(3);
        Node.next.next.next.next = new ListNode(10);
        // Print the list of here.
        printList(Node, "Unsorted Linked List");
        ListNode sorted = mergeSort.sortList(Node);
        printList(sorted, "Sorted Linked List");
    }
}
