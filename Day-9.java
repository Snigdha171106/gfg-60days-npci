import java.util.*;

public class Solution {

    public int longestSubarray(int[] arr, int k) {

        int prefix = 0, maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > k)
                prefix += 1;     
            else
                prefix -= 1;    

            if (prefix > 0) {
                maxLen = i + 1;
            } else {
                if (map.containsKey(prefix - 1)) {
                    maxLen = Math.max(maxLen, i - map.get(prefix - 1));
                }
            }

            if (!map.containsKey(prefix)) {
                map.put(prefix, i);
            }
        }

        return maxLen;
    }
}