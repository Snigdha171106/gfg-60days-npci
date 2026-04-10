import java.util.*;

class Solution {

    public ArrayList<String> graycode(int n) {

        ArrayList<String> res = new ArrayList<>();
        int size = 1 << n;  // 2^n

        for(int i = 0; i < size; i++) {

            int g = i ^ (i >> 1);

            String bin = Integer.toBinaryString(g);

            while(bin.length() < n)
                bin = "0" + bin;

            res.add(bin);
        }

        return res;
    }
}