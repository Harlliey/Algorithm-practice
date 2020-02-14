package lecture_4;
import java.lang.Math;

/*
	Leetcode 160. Intersection of Two Linked Lists 
*/

public class IntersectionOfTwoLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	// Solution one is my first attempt of the problem, though it passed the test, ethe code is complex and inefficient
	private static ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		ListNode curA = headA;
		int countA = 0;
		while (curA.next != null) {
			countA ++;
			curA = curA.next;
		}

		ListNode curB = headB;
		int countB = 0;
		while (curB.next != null) {
			countB ++;
			curB = curB.next;
		}

		if (curA != curB) {
			return null;
		}

		int stride = Math.abs(countA - countB);
		
		if (countA > countB) {
			while (stride != 0) {
				headA = headA.next;
				stride --;
			}

			while (headA != headB) {
				headA = headA.next;
				headB = headB.next;
			}

			return headA;
		} else {
			while (stride != 0) {
				headB = headB.next;
				stride --;
			}

			while (headA != headB) {
				headA = headA.next;
				headB = headB.next;
			}

			return headB;
		}
	}

	// Solution two is a more efficient way with clean and fewer codes
	private static ListNode getIntersectionNode_2 (ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		ListNode ptr_1  = headA;
		ListNode ptr_2 = headB;

		while (ptr_1 != ptr_2) {
			ptr_1 = ptr_1.next;
			ptr_2 = ptr_2.next;

			if (ptr_1 == ptr_2) {
				return ptr_1;
			}

			if (ptr_1 == null) {
				ptr_1 = headB;
			}

			if (ptr_2 == null) {
				ptr_2 = headA;
			}
		}

		return ptr_1;
	}
}
