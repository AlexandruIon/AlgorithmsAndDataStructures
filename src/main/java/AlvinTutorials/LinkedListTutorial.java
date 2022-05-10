package AlvinTutorials;

public class LinkedListTutorial {


    // time O(N)
    // space o(1)
    public static NodeLinked reverse(NodeLinked head) {

        NodeLinked prev = null;
        NodeLinked current = head;

        while (current != null) {
            NodeLinked next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // n = length of list 1
    // m = length of list 2
    // Time O(Min(n,m))
    // Space O(1)
    public static NodeLinked zipperList(NodeLinked l1, NodeLinked l2) {
        NodeLinked tail = l1;
        NodeLinked current_1 = l1.next;
        NodeLinked current_2 = l2;
        int count = 0;

        while (current_1 != null && current_2 != null) {
            if (count % 2 == 0) {
                tail.next = current_2;
                current_2 = current_2.next;
            } else {
                tail.next = current_1;
                current_1 = current_1.next;
            }
            tail = tail.next;
            count++;
        }

        if (current_1 != null) tail.next = current_1;
        if (current_2 != null) tail.next = current_2;

        return null;
    }

}

class NodeLinked {

    String value;
    NodeLinked next;

    public NodeLinked(String value, NodeLinked next) {
        this.value = value;
        this.next = next;
    }

}