public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

		return dummyHead.next;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
		ListNode dummy1 = l1;
		dummy1.next = new ListNode(4);
		dummy1 = dummy1.next;
		dummy1.next = new ListNode(3);
        
		ListNode l2 = new ListNode(5);
		ListNode dummy2 = l2;
		dummy2.next = new ListNode(6);
		dummy2 = dummy2.next;
		dummy2.next = new ListNode(4);

        ListNode sum = addTwoNumbers(l1, l2);
		while (sum != null) {
			System.out.println(sum.val);
			sum = sum.next;
		}
    }
}
