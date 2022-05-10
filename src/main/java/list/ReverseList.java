package list;

public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4)))));
        reverseList(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;

        while (head != null) {
            ListNode next = head.next; // set the next pointer
            head.next = previous; // reverse node
            previous = head;
            head = next; // move forward    // save the current node as previous for next iteration
        }
        return previous;
    }

}
