package lecture_4;

import java.util.Stack;

public class PalindromeLinkedList {
	
	private static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int x) {
			val = x;
		}
	}
	
	//Method1. Using O(n) extra space
	public static boolean isPalindrome_1(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode curNode = head;
		
		while (curNode != null) {
			stack.push(curNode);
			curNode = curNode.next;
		}
		
		while (head != null) {
			if (head.val != stack.pop().val) {
				return false;
			}
			
			head = head.next;
		}
		
		return true;
	}
	
	public static boolean isPalindrome_2(ListNode head) {
		
		
		return true;
	}
}
