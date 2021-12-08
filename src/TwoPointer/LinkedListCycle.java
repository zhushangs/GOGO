package TwoPointer;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LinkedListCycle<ListNode> {
    //Leetcode 141

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        //we use two pointer to see if they will finally meet
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != null && fast != null && fast.next != null){
            //the fast will catch up the slow if the linked list has a cycle in it
            if(slow == fast){
                return true;
            }
            //the slow moves only one step
            //the fast moves two steps
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}


/*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */
