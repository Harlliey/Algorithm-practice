package lecture_4;

/*
 * Leetcode 138. Copy List with Random Pointer
 */

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	
	static class Node {
		int val;
		Node next;
	    Node random;
		
		Node(int x) {
			val = x;
			next = null;
			random = null;
		}
	}
	
	// Method one will use extra space
	public static Node copyRandomList_1(Node head) {
		
		if (head == null) {
			return null;
		}
		
		Map<Node, Node> helpMap = new HashMap<>();
		Node curNode = head;
		
		while (curNode != null) {
			helpMap.put(curNode, new Node(curNode.val));
			curNode = curNode.next;
		}
		
		curNode = head;
		while (curNode != null) {
			helpMap.get(curNode).next = helpMap.get(curNode.next);
			helpMap.get(curNode).random = helpMap.get(curNode.random);
			curNode = curNode.next;
		}
		
		return helpMap.get(head);
	}
	
	// Method two use only O(1) space
	public static Node copyRandomList_2(Node head) {
		
		if (head == null) {
			return null;
		}
		
		Node curNode = head;
		Node nextNode = null;
		
		// First pass, put the dummy nodes into the linked list
		while (curNode != null) {
			nextNode = curNode.next;
			curNode.next = new Node(curNode.val);
			curNode.next.next = nextNode;
			curNode = nextNode;
		}
		
		curNode = head;
		Node curCopyNode = null;
		
		// Second pass, copy the random pointer
		while (curNode != null) {
			curCopyNode = curNode.next;
			curCopyNode.random = curNode.random != null ? curNode.random.next : null;
			curNode = curNode.next.next;
		}
		
		curNode = head;
		Node copyHead = head.next;
		
		// Split the original list and the dummy list
		while (curNode != null) {
			nextNode = curNode.next.next;
			curCopyNode = curNode.next;
			curNode.next = nextNode;
			curCopyNode.next = nextNode != null ? nextNode.next : null;
			curNode = curNode.next;
		}
		
		return copyHead;
	}
}
