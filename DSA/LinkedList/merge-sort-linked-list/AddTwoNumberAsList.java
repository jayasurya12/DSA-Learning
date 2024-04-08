class ListNode {
    int val;
    ListNode next;    
    ListNode (int val) { this.val = val; next = null; }
}


public class AddTwoNumberAsList {

    public ListNode addTwoNumbers(ListNode A, ListNode B) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode t1 = A;
        ListNode t2 = B;
    
        int carry = 0;
    
        while (t1 != null || t2!= null) {
        
            int sum = carry;
            if (t1 != null) sum += t1.val;
            if (t2 != null) sum += t2.val;
    
            ListNode sumNode = new ListNode(sum % 10);
        
            carry = sum / 10;
            curr.next = sumNode;
            curr = curr.next;
    
            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;

        }

        if (carry != 0) {
            ListNode carryNode = new ListNode(carry);
            curr.next = carryNode;
        }
    
        return dummy.next;
    }

    

    public static void main(String[] args) {
        AddTwoNumberAsList test = new AddTwoNumberAsList();
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        ListNode merged = test.addTwoNumbers(head1, head2);

        // Print the merged list
        while (merged != null) {
            System.out.print(merged.val);
            merged = merged.next;
        }
    }
}