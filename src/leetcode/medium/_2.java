package leetcode.medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 2. Add Two Numbers
class _2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode current = root;
        int ceil = 0;

        while (l1 != null || l2 != null) {
            int value1 = 0;
            if (l1 != null) {
                value1 = l1.val;
            }
            int value2 = 0;
            if (l2 != null) {
                value2 = l2.val;
            }

            int sum = ceil + value1 + value2;
            ceil = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (ceil > 0) {
            current.next = new ListNode(ceil);
        }

        return root.next;
    }

    private void search(ListNode target) {
        if (target.next != null) {
            search(target.next);
        }
        System.out.println(target.val);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
