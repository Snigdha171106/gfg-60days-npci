class Solution {

    boolean canFormPalindrome(String s) {

        int[] freq = new int[26];

        // count frequency
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        int odd = 0;

        // count odd frequencies
        for(int i = 0; i < 26; i++){
            if(freq[i] % 2 != 0)
                odd++;
        }

        return odd <= 1;
    }
}