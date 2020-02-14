package lecture_4;

/*
 * Leetcode 86. Partition List
 */

public class PartitionList {

	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
		}
	}
	
	// Method one didn't preserve the nodes' order, convert the problem into Netherlands Flag problem
	public static ListNode partition_1(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		
		ListNode curNode = head;
		int i = 0;
		
		while (curNode != null) {
			curNode = curNode.next;
			i++;
		}
		
		ListNode[] nodes = new ListNode[i];
		curNode = head;
		i = 0;
		
		while (curNode != null) {
			nodes[i++] = curNode;
			curNode = curNode.next;
		}
		
		int moreOrEqual = nodes.length;
		i = 0;
		
		while (i != moreOrEqual) {
			if (nodes[i].val < x) {
				i++;
			} else {
				swap(nodes, --moreOrEqual, i);
			}
		}
		
		ListNode resHead = nodes[0];
		curNode = nodes[0];
		
		for (i = 1; i < nodes.length; i++) {
			curNode.next = nodes[i];
			curNode = curNode.next;
		}
		curNode.next = null;
		
		return resHead;
	}
	
	// Method two preserve the original order of the nodes in linked list
	public static ListNode partition2(ListNode head, int x) {
		
		if (head == null) {
			return null;
		}
		
		ListNode lessHead = null;
		ListNode lessTail = null;
		ListNode grEqHead = null;
		ListNode grEqTail = null;
		
		while (head != null) {
			ListNode nextNode = head.next;
			head.next = null;
			
			if (head.val < x) {
				if (lessHead == null) {
					lessHead = head;
					lessTail = head;
				} else {
					lessTail.next = head;
					lessTail = lessTail.next;
				}
			} else {
				if (grEqHead == null) {
					grEqHead = head;
					grEqTail = head;
				} else {
					grEqTail.next = head;
					grEqTail = grEqTail.next;
				}
			}
			
			head = nextNode;
		}
		
		if (lessTail != null) {
			lessTail.next = grEqHead;
		}
		
		return lessHead != null ? lessHead : grEqHead;
	}
	
	// Method three is faster since it eliminate many judging logic in codes 
	private static ListNode smallList = new ListNode(0);
	private static ListNode grEqList = new ListNode(0);
	
	public static ListNode partition_3(ListNode head, int x) {
		
		if (head == null) {
			return null;
		}
		
		ListNode smallHead = smallList;
		ListNode grEqHead = grEqList;
		
		while (head != null) {
			ListNode nextNode = head.next;
			head.next = null;
			
			if (head.val < x) {
				smallList.next = head;
			} else {
				grEqList.next = head;
			}
			
			head = nextNode;
		}
		
		if (smallHead.next != null) {
			smallList.next = grEqHead.next;
		}
		
		return smallHead.next != null ? smallHead.next : grEqHead.next;
	}
	
	private static void swap(ListNode[] arr, int x, int y) {
		ListNode tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}
