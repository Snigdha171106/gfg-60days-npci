import java.util.*;

class Solution {
    public int kBitFlips(int[] arr, int k) {
        
        int n = arr.length;
        int flips = 0;
        int currFlip = 0;
        int[] hint = new int[n];

        for(int i = 0; i < n; i++) {

            if(i >= k)
                currFlip ^= hint[i - k];

            if((arr[i] ^ currFlip) == 0) {

                if(i + k > n)
                    return -1;

                flips++;
                currFlip ^= 1;

                if(i < n)
                    hint[i] = 1;
            }
        }

        return flips;
    }
}