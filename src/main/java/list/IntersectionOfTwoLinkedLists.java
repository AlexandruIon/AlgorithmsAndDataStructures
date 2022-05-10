package list;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int listALength = 0, listBLength = 0;
        ListNode hA = headA;
        ListNode hb = headB;
        while (hA.next != null) {
            hA = hA.next;
            listALength++;
        }
        while (hb.next != null) {
            hb = hb.next;
            listBLength++;
        }
        hA = headA;
        hb = headB;
        if (listALength > listBLength) {
            int diff = listALength - listBLength;
            while (diff != 0) {
                hA = hA.next;
                diff--;
            }
        } else {
            int diff = listBLength - listALength;
            while (diff != 0) {
                hb = hb.next;
                diff--;
            }
        }
        while (hA != null || hb != null) {
            if (hA.equals(hb)) return hA;
            hA = hA.next;
            hb = hb.next;
        }

        return null;

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;

        while (p != q) {
            p = (p != null) ? p.next : headB;
            q = (q != null) ? q.next : headA;
        }
        return p;
    }

}
