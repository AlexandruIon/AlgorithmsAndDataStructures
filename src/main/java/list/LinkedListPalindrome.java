package list;

import java.util.ArrayList;
import java.util.List;

public class LinkedListPalindrome {

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(1, new ListNode(2, null));
        isPalindrome(listNode2);
    }

    public static boolean isPalindrome(ListNode head) {

        List<Integer> values = new ArrayList<>();

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int size = values.size();
        if (size % 2 == 0) {
            for (int i = 0, j = size - 1; i <= size / 2 && j >= size / 2; i++, j--) {
                if (!values.get(i).equals(values.get(j))) return false;
            }
        } else {
            for (int i = 0, j = size - 1; i < (size / 2) - 1 && j > (size / 2) + 1; i++, j--) {
                if (!values.get(i).equals(values.get(j))) return false;
            }
        }

        return true;
    }
}
