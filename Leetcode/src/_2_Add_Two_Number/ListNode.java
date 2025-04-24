package _2_Add_Two_Number;

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

    public int getVal() {
        return val;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        return null;
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
        // generate ListNode l1
        ListNode l1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1.next = l1_2;
        l1_2.next = l1_3;

        // generate ListNode l2
        ListNode l2 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2.next = l2_2;
        l2_2.next = l2_3;

        l1 = reverse(l1);
        l2 = reverse(l2);

        System.out.println("ok");


    }
}
