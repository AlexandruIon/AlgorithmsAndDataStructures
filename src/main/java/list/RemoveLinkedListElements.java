package list;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4)))));
        removeElements(listNode2,6);
    }

    public static ListNode removeElements(ListNode head, int val) {


        ListNode slow = new ListNode();
        ListNode newHead = slow;
        ListNode fast = head;

        while(fast != null){
            if(fast.val == val){
                slow.next = null;
            }else {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        return newHead.next;
    }
}
