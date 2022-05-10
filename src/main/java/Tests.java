import java.util.HashMap;
import java.util.Map;

public class Tests {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hhMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hhMap.containsKey(target - nums[i])) {
                return new int[]{hhMap.get(target - nums[i]), i};
            }
            hhMap.put(nums[i], i);
        }
        return new int[1];
    }

    public static boolean isPalindrome(int x) {

        if (Math.abs(x) != x) return false;

        int sum = 0;
        int number = x;

        while (number > 0) {
            int lastDigit = number % 10;
            sum = (sum * 10) + lastDigit;
            number = number / 10;
        }
        return sum == x;
    }

    public static String longestCommonPrefix(String[] strs) {
        String asd = "";
        String asd2 = "";

        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                String slowString = strs[i];
                String fastString = strs[j];

                for (int x = 0; x < slowString.length() && x < fastString.length(); x++) {
                    if (slowString.charAt(x) == fastString.charAt(x)) {
                        asd2 = asd2 + slowString.charAt(x);
                    } else {
                        break;
                    }
                }

                if (asd2.length() >= asd.length()) {
                    asd = asd2;
                }
                asd2 = "";
            }

        }
        return asd;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length <= 1) return strs[0];
        String currentPrefix = compareTwoString(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            String s = compareTwoString(currentPrefix, strs[i]);
            if (s.equals("")) return "";
            currentPrefix = s;
        }
        return currentPrefix;
    }


    public static String compareTwoString(String str1, String str2) {
        StringBuilder longest = new StringBuilder();
        for (int i = 0, j = 0; i < str1.length() && j < str2.length(); i++, j++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                longest.append(str1.charAt(i));
                continue;
            }
            break;
        }
        return longest.toString();
    }


    //    public static void main(String[] args) {
//        System.out.println(isPalindrome(121));
//
//        System.out.println(longestCommonPrefix(new String[]{"asd", "asf"}));
//
//        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        System.out.println((mergeTwoLists3(listNode1, listNode2)));
//    }
    public static ListNode mergeTwoLists3(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode tail = head; // keep a reference to the fist node

        while (true) {

            // if either list runs out use the other list
            if (list1 == null) {
                tail.next = list2;
                break;
            }
            if (list2 == null) {
                tail.next = list1;
                break;
            }

            // compare the data of the two lists whichever lists is smaller, append it into tail
            // and advance the head to the next node
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        return head.next;
    }


//    public static void main(String[] args) {
////        removeDuplicates(new int[]{1, 1, 1, 1});
////        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
////        System.out.println(removeDuplicates(new int[]{1, 1}));
////        System.out.println(removeElementSlow(new int[]{1, 1, 2, 3}, 2));
//        System.out.println(removeElementSlow2(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
//    }

    public static int removeDuplicates(int[] nums) {

        int indexPositionInArray = 0;
        // index to start the search
        int currentPosition = 0;
        // value found
        int currentValue = 0;

        while (true) {
            // get the value we are looping for
            currentValue = nums[currentPosition];
            //start the search at the next index value
            int counter = currentPosition + 1;

            // search until we have found a different value
            while (counter < nums.length && currentValue == nums[counter]) {
                counter++;
            }

            nums[indexPositionInArray] = currentValue;

            // set the current position to the new value
            currentPosition = counter;
            indexPositionInArray += 1;
            if (currentPosition == nums.length) break;
        }
        return indexPositionInArray;
    }

    public static int removeDuplicates2(int[] nums) {
        int prev = nums[0];
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                j++;
                nums[j] = nums[i];
                prev = nums[i];
            }
        }
        return j + 1;
    }

    public int removeElement(int[] nums, int val) {
//        int fistValue = nums[0];
//        int position = 0;
        int openPosition = -1;
        int moved = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                openPosition = i;
            } else {
                if (openPosition != -1) {
                    nums[openPosition] = nums[i];
                    openPosition = -1;
                }
            }
        }
        return moved;
    }

    public static int removeElementSlow(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter++;
            if (val == nums[i]) {
                nums[i] = -1;
                counter--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != -1) {
                        nums[i] = nums[j];
                        nums[j] = -1;
                        break;
                    }
                }
            }
        }
        return counter;
    }

    public static int removeElementSlow2(int[] nums, int val) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{0, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{0, 3, 5, 6}, 2));
//        System.out.println(searchInsert(new int[]{0, 3, 5, 6}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        return rank(target, nums, 0, nums.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }

}


class ListNode {
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}