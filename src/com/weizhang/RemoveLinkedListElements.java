package com.weizhang;


/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pseudoHead = new ListNode(0);
        pseudoHead.next = head;

        ListNode previous = pseudoHead;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (current.val == val) {
                // remove the node with val
                previous.next = next;
                current.next = null;
            } else {
                previous = current;
            }
            current = next;
        }
        return pseudoHead.next;
    }

}
