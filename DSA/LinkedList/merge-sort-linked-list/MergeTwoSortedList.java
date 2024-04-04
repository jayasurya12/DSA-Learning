class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int data) {
        this.val = data;
        this.next = null;
    }
}

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null) return B;
        if (B == null) return A;

        ListNode head = null;
        if (A.val < B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }
        ListNode temp = head;
        ListNode h1 = A;
        ListNode h2 = B;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }
        // Handle the case where one list is exhausted but the other still has elements
        if (h1 == null) {
            temp.next = h2;
        }
        if (h2 == null) {
            temp.next = h1;
        }
        // Return the merged list's head
        return head;
    }
    
    public static void main(String[] args) {
        Test test = new Test();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        ListNode merged = test.mergeTwoLists(head1, head2);

        // Print the merged list
        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
    }
}
