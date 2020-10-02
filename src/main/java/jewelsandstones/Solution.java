package jewelsandstones;


public class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0) return 0;
        int jewelsCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.contains(S.substring(i, i + 1))) {
                jewelsCount++;
            }
        }
        return jewelsCount;
    }
}
