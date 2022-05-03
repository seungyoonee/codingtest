public class mergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public static ListNode mergeLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

        ListNode output = new ListNode(0);
        ListNode ptr = output;
        int input = 0;
		
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				input = l2.val;
				l2 = l2.next;
			}
			else {
				input = l1.val;
				l1 = l1.next;
			}
			ptr.next = new ListNode(input);
			ptr = ptr.next;
		}

		while (l1 != null) {
			input = l1.val;
			ptr.next = new ListNode(input);
			ptr = ptr.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			input = l2.val;
			ptr.next = new ListNode(input);
			ptr = ptr.next;
			l2 = l2.next;
		}

		return output.next;
    }

    public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode dummy1 = l1;
		dummy1.next = new ListNode(2);
		dummy1 = dummy1.next;
		dummy1.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		ListNode dummy2 = l2;
		dummy2.next = new ListNode(3);
		dummy2 = dummy2.next;
		dummy2.next = new ListNode(4);

		ListNode output = mergeLists(l1, l2);
		while (output != null) {
			System.out.println(output.val);
			output = output.next;
		}
    }
}
