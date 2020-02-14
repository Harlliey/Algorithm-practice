package lecture_4;

import java.util.Stack;

/*
 * Leetcode 234. Palindrome Linked List
 */

public class PalindromeLinkedList {
	
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
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
	
	//Method2. Using O(n/2) extra space
	public static boolean isPalindrome_2(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		
		Stack<ListNode> stack = new Stack<>();
		ListNode firstNode = head;
		ListNode secondNode = head.next;
		
		while (firstNode.next != null && firstNode.next.next != null) {
			secondNode = secondNode.next;
			firstNode = firstNode.next.next;
		}
		
		ListNode curNode = secondNode;
		
		while (curNode != null) {
			stack.push(curNode);
			curNode = curNode.next;
		}
		
		while (!stack.isEmpty()) {
			if (head.val != stack.pop().val) {
				return false;
			}
			head = head.next;
		}
		
		return true;
	}
	
	//Method3. Using O(1) extra space
	public static boolean isPalindorme_3(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		
		boolean result = true;
		ListNode firstNode = head;
		ListNode secondNode = head;
		
		while (secondNode.next != null && secondNode.next.next != null) {
			firstNode = firstNode.next;
			secondNode = secondNode.next.next;
		}
		
		//Reconstruct the right part of the linked list 
		ListNode preNode = null;
		ListNode curNode = firstNode;
		
		while (curNode != null) {
			ListNode tmpNode = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = tmpNode;
		}
		
		//Palindrome verification
		ListNode recoverHead = preNode;
		
		while (head != null && preNode != null) {
			if (head.val != preNode.val) {
				result = false;
				break;
			}
			
			head = head.next;
			preNode = preNode.next;
		}
		
		//Recover the linked list
		preNode = null;
		curNode = recoverHead;
		
		while (curNode != null) {
			ListNode tmpNode = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = tmpNode;
		}
		
		return result;
	}
}
