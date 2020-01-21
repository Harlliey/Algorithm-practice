package lecture_4;

public class PartitionList {

	private static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int x) {
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
		ListNode moreHead = null;
		ListNode moreTail = null;
		
		return null;
	}
	
	private static void swap(ListNode[] arr, int x, int y) {
		ListNode tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}
