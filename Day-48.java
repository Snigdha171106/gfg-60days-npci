class Solution {

    public int totalWays(int[] arr, int target) {

        int sum = 0;
        for(int x : arr) sum += x;

        if(sum < Math.abs(target) || (sum + target) % 2 != 0)
            return 0;

        int s1 = (sum + target) / 2;

        int[] dp = new int[s1 + 1];
        dp[0] = 1;

        for(int num : arr){
            for(int j = s1; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }

        return dp[s1];
    }
}