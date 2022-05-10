package slidingWindowProblems;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstringE {

    public static void main(String[] args) {

        System.out.println(longestNiceSubstring("YazaAay"));
    }

    public static String longestNiceSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int a_pointer = 0;
        int b_pointer = 0;

        boolean isNice = false;

        while (b_pointer < s.length()) {
            char current_char = s.charAt(b_pointer);
            char current_char_upper = Character.toUpperCase(current_char);
            char current_char_lower = Character.toLowerCase(current_char);

            if (!chars.contains(current_char) && Character.isLowerCase(current_char) && chars.contains(current_char_upper)) {
                chars.add(current_char);
                sb.append(current_char); // append to nice nicest string
                b_pointer++; // continue
                isNice = true;
                continue;
            }

            if (!chars.contains(current_char) && Character.isUpperCase(current_char) && chars.contains(current_char_lower)) {
                chars.add(current_char);
                sb.append(current_char); // append to nice nicest string
                b_pointer++; // continue
                isNice = true;
                continue;
            }

            // first occurrence and there is no upper/lower
            if (!chars.contains(current_char)) {
                chars.add(current_char);
                if(!isNice && b_pointer>1){
                    chars.remove(s.charAt(a_pointer));
                    if (sb.length() > 0) sb.deleteCharAt(a_pointer);
                }
                a_pointer++;
                continue;
            }

            if(chars.contains(current_char)){
                b_pointer++;
            }
        }
        return sb.toString();
    }
}
