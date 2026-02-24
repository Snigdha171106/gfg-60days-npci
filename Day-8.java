import java.util.*;

public class Solution {

    public int equalSumSpan(int[] a1, int[] a2) {
        Map<Integer, Integer> map = new HashMap<>();

        int diff = 0;
        int maxLen = 0;

        map.put(0, -1); 

        for (int i = 0; i < a1.length; i++) {
            diff += a1[i] - a2[i];

            if (map.containsKey(diff)) {
                int len = i - map.get(diff);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(diff, i);
            }
        }

        return maxLen;
    }
}