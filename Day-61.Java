class Solution {

    public int maxOnes(int arr[]) {

        int n = arr.length;
        int ones = 0;

        // count original 1s
        for(int x : arr){
            if(x == 1) ones++;
        }

        int maxGain = 0;
        int curr = 0;

        for(int i = 0; i < n; i++){

            int val = (arr[i] == 0) ? 1 : -1;

            curr = Math.max(val, curr + val);
            maxGain = Math.max(maxGain, curr);
        }

        return ones + maxGain;
    }
}