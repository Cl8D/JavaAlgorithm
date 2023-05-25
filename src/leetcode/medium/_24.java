package leetcode.medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 24. swap nodes in pairs
class _24 {

    public static void main(String[] args) {
        final ListNode node1 = new ListNode(1);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(3);
        final ListNode node4 = new ListNode(4);
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        // ListNode{val=1,
        //          next=ListNode{
        //                  val=2,
        //                  next=ListNode{
        //                          val=3,
        //                          next=ListNode{
        //                              val=4,
        //                              next=null}}}}
        swapPairs(node1);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode current = first;
        // current
        // ListNode{val=0,
        //          next=ListNode{
        //              val=1,
        //              next=ListNode{
        //                      val=2,
        //                      next=ListNode{
        //                              val=3,
        //                              next=ListNode{
        //                                      val=4,
        //                                      next=null}}}}}

        while (current.next != null && current.next.next != null) {
            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = current.next.next;
            current.next.next = temp;
            current = current.next.next;
        }
        return first.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }
}
