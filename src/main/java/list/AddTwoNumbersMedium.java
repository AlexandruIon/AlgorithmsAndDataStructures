package list;

import java.util.Stack;

public class AddTwoNumbersMedium {

    public static void main(String[] args) {
        System.out.println(11 / 10);
        System.out.println(9 / 10);
        System.out.println(11 % 10);
        System.out.println(12 % 10);

//        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3,null)));
//        ListNode listNode2 = new ListNode(4, new ListNode(3, new ListNode(8,null)));
//        addTwoNumbersStacks(listNode1,listNode2);
//
//        ListNode listNode3 = new ListNode(2, new ListNode(4, new ListNode(3,null)));
//        ListNode listNode4 = new ListNode(5, new ListNode(6, new ListNode(4,null)));
//        addTwoNumbersStacks(listNode3,listNode4);

        ListNode listNode5 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
        ListNode listNode6 = new ListNode(9, null);
        addTwoNumbersStacks(listNode5, listNode6);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1.next == null && l2.next == null) {

        }


        return null;
    }

    public static ListNode addTwoNumbersStacks2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;

        int toCarry = 0;

        while (l1 != null || l2 != null) {
            node.next = new ListNode();
            node = node.next;
            int nodeSum = 0;
            if (l1 != null) {
                nodeSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                nodeSum += l2.val;
                l2 = l2.next;
            }

            nodeSum += toCarry;
            int digit = nodeSum % 10;
            toCarry = nodeSum / 10;
            node.val = digit;
        }

        if (toCarry != 0) {
            node.next = new ListNode();
            node = node.next;
            node.val = toCarry;
        }

        return head.next;
    }

    public static ListNode addTwoNumbersStacks(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        while (l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = new ListNode();
        ListNode node = head;

        int toCarry = 0;

        while (!l1Stack.isEmpty() && !l2Stack.isEmpty()) {
            node.next = new ListNode();
            node = node.next;
            int nodeSum = l1Stack.pop() + l2Stack.pop() + toCarry;
            int digit = nodeSum % 10;
            toCarry = nodeSum / 10;
            node.val = digit;

        }
        while (!l1Stack.isEmpty()) {
            node.next = new ListNode();
            node = node.next;
            int nodeSum = l1Stack.pop() + toCarry;
            int digit = nodeSum % 10;
            toCarry = nodeSum / 10;
            node.val = digit;
        }

        while (!l2Stack.isEmpty()) {
            node.next = new ListNode();
            node = node.next;
            int nodeSum = l2Stack.pop() + toCarry;
            int digit = nodeSum % 10;
            toCarry = nodeSum / 10;
            node.val = digit;
        }
        if (toCarry != 0) {
            node.next = new ListNode();
            node = node.next;
            node.val = toCarry;
        }

        // revert list;
        return head.next;
//        ListNode previous = null;
//        while(head !=null){
//            ListNode tmp = head.next;
//            head.next = previous;
//            previous = head;
//            head = tmp;
//        }
//
//
//        return previous.next;

    }

    public ListNode addTwoNumbers2(ListNode sum, ListNode l1, ListNode l2, int carry) {

        if (l1.next == null && l2.next == null) {
            int nodeSum = l1.val + l2.val;
            int digit = nodeSum % 10;
            int toCarry = nodeSum / 10;
            return addTwoNumbers2(new ListNode(digit, null), l1, l2, toCarry);
        }


        return null;
    }

}
