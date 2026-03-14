class Solution {

    public String minWindow(String s, String p) {

        int[] count = new int[256];

        for (char c : p.toCharArray()) {
            count[c]++;
        }

        int start = 0, minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int needed = p.length();

        for (int end = 0; end < s.length(); end++) {

            if (count[s.charAt(end)] > 0) {
                needed--;
            }

            count[s.charAt(end)]--;

            while (needed == 0) {

                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                count[s.charAt(start)]++;

                if (count[s.charAt(start)] > 0) {
                    needed++;
                }

                start++;
            }
        }

        if (minLen == Integer.MAX_VALUE) return "";

        return s.substring(minStart, minStart + minLen);
    }
}