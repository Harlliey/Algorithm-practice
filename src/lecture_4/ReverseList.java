package lecture_4;

/*
 * Leetcode 206. Reverse Linked List
 */

public class ReverseList {
	
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode reverse(ListNode head) {
		
		ListNode pre = null;
		ListNode next = null;
		
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
			
		}
		
		return pre;
	}
}
