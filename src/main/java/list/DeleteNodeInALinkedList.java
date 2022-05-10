package list;

public class DeleteNodeInALinkedList {

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3,null)));
        deleteNode(listNode2);
    }

    public static void deleteNode(ListNode node) {
        ListNode fastNode = node.next;

        while(fastNode!=null){
            node.val = fastNode.val;
            if(fastNode.next != null){
                node = node.next;
                fastNode = fastNode.next;
            }else{
                node.next = null;
                return;
            }
        }
    }

}
