package problems;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(3,new ListNode(4))));

        System.out.println(deleteDuplicates(listNode2));

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode nodeHead = head;

        while (nodeHead.next != null){
            if(nodeHead.val == nodeHead.next.val){
                nodeHead.next= nodeHead.next.next;
            }else nodeHead = nodeHead.next;
        }

        return head;
    }

}


 class ListNode {
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

