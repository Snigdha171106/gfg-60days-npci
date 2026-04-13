class Solution {

    public int[] nextPalindrome(int[] num) {

        int n = num.length;

        // Step 1: check if all digits are 9
        boolean all9 = true;
        for(int i = 0; i < n; i++){
            if(num[i] != 9){
                all9 = false;
                break;
            }
        }

        if(all9){
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        int[] res = num.clone();

        // Step 2: mirror left → right
        for(int i = 0; i < n/2; i++){
            res[n-1-i] = res[i];
        }

        // Step 3: check if mirrored > original
        boolean greater = false;
        for(int i = 0; i < n; i++){
            if(res[i] > num[i]){ 
                greater = true;
                break;
            }
            if(res[i] < num[i]) break;
        }

        if(greater) return res;

        // Step 4: increment middle
        int carry = 1;
        int mid = (n-1)/2;

        while(mid >= 0 && carry > 0){
            int sum = res[mid] + carry;
            res[mid] = sum % 10;
            carry = sum / 10;
            mid--;
        }

        // Step 5: mirror again
        for(int i = 0; i < n/2; i++){
            res[n-1-i] = res[i];
        }

        return res;
    }
}