package slidingWindowProblems;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharactersM {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");

    }

    public static int lengthOfLongestSubstring(String s) {
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;

        HashSet<Character> asd = new HashSet<>();

        while (b_pointer < s.length()) {

            if (!asd.contains(s.charAt(b_pointer))) {
                asd.add(s.charAt(b_pointer++));
                max = Math.max(max, asd.size());
            } else {
                asd.remove(s.charAt(a_pointer++));
            }
        }
        return max;
    }

}
