package _2_Add_Two_Number;

import java.io.Serializable;
import java.util.Objects;

// https://leetcode.com/problems/add-two-numbers/description/
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

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int module = (l1.val + l2.val) % 10;
        int division = (l1.val + l2.val) / 10;
        ListNode result = new ListNode(module);
        while((l1 != null && l1.next != null)
                || (l2 != null && l2.next != null)
                || division != 0) {
            l1 = getNext(l1);
            l2 = getNext(l2);

            module = (getValue(l1) + getValue(l2) + division) % 10;
            division = (getValue(l1) + getValue(l2) + division) / 10;
            ListNode newNode = result;
            while (newNode.next != null) {
                newNode = newNode.next;
            }
            newNode.next = new ListNode(module);
        }
        return result;
    }

    private static ListNode getNext(ListNode l) {
        return l != null ? l.next : null;
    }

    private static int getValue(ListNode l) {
        return Objects.isNull(l) ? 0 : l.val;
    }

    private static ListNode reverse(ListNode args) {
        ListNode node = new ListNode(args.val);
        while (args.next != null) {
            ListNode temp = new ListNode(args.next.val);
            temp.next = node;
            node = temp;
            args = args.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);

        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);

        l1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        addTwoNumbers(l1, l2);
    }
}
