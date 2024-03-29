// Problem Description
// Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.



// Problem Constraints
// 1 <= |A| <= 105



// Input Format
// The first and the only argument of input contains a pointer to the head of the given linked list.



// Output Format
// Return 0, if the linked list is not a palindrome.

// Return 1, if the linked list is a palindrome.



// Example Input
// Input 1:

// A = [1, 2, 2, 1]
// Input 2:

// A = [1, 3, 2]


// Example Output
// Output 1:

//  1 
// Output 2:

//  0 


// Example Explanation
// Explanation 1:

//  The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
// Explanation 2:

//  The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].



class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) { 
        val = x; 
        next = null; 
    }
}

public class PalindromLinkedList {
    static int size(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    static ListNode rev(ListNode head, int mid) {
        ListNode temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }
     
        ListNode prev = null;
        ListNode curr = temp;
        while (curr != null) {
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
       
        return prev;
    }

    public int lPalin(ListNode A) {
        if (A == null || A.next == null) // Empty or single node list
            return 1;
        
        int n = size(A);
        int mid = (n + 1) / 2;
        ListNode r = rev(A, mid);
        
        ListNode c1 = A;
        ListNode c2 = r;
        while (c2 != null) {
            if (c1.val != c2.val)
                return 0; // Not a palindrome
            c1 = c1.next;
            c2 = c2.next;
        }
        return 1; // Palindrome
    }

    public static void main(String[] args) {
        PalindromLinkedList palindrom = new PalindromLinkedList();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(1);
        System.out.println("Example 1:");
        System.out.println("Input: 1 -> 2 -> 3 -> 2 -> 1");
        System.out.println("Output: " + palindrom.lPalin(head1));

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.println("\nExample 2:");
        System.out.println("Input: 1 -> 2 -> 3");
        System.out.println("Output: " + palindrom.lPalin(head2));

        // Example 3
        ListNode head3 = new ListNode(1);
        System.out.println("\nExample 3:");
        System.out.println("Input: 1");
        System.out.println("Output: " + palindrom.lPalin(head3));

        // Example 4
        ListNode head4 = null;
        System.out.println("\nExample 4:");
        System.out.println("Input: (Empty List)");
        System.out.println("Output: " + palindrom.lPalin(head4));
    }
}
