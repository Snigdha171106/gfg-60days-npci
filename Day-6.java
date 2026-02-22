import java.util.*;

public class Solution {

    public int subarrayXor(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        int prefixXor = 0;
        int count = 0;

        freq.put(0, 1);

        for (int num : arr) {
            prefixXor ^= num;

            int required = prefixXor ^ k;

            if (freq.containsKey(required)) {
                count += freq.get(required);
            }

            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}