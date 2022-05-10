import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        isAnagram("rat", "car");
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] array = new int[256];
        Arrays.fill(array, 0);

        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)] += 1;
            array[t.charAt(i)] -= 1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
