import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<String, String> charMapping = new HashMap<>();

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        if (sChar.length != tChar.length) {
            return false;
        }

        for (int i = 0; i < sChar.length; i++) {
            if (!charMapping.containsKey(String.valueOf(sChar[i]))) {
                if(charMapping.containsValue(String.valueOf(tChar[i]))){
                    return false;
                }
                charMapping.put(String.valueOf(sChar[i]), String.valueOf(tChar[i]));
            } else if (!charMapping.get(String.valueOf(sChar[i])).equals(String.valueOf(tChar[i]))) return false;
        }

        return true;
    }

    public boolean isIsomorphic2(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] sarr = new int[256];
        int[] tarr = new int[256];

        Arrays.fill(sarr,-1);
        Arrays.fill(tarr,-1);

        for(int i = 0; i< s.length();i++){
            if(sarr[s.charAt(i)]!=tarr[t.charAt(i)]){
                return false;
            }
            sarr[s.charAt(i)] = i;
            tarr[t.charAt(i)] = i;
        }
        return true;
    }
}
