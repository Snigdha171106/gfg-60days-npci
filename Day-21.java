class Solution {
    String largestSwap(String s) {
        
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        int[] maxIndex = new int[n];
        int maxPos = n - 1;
        
        // store index of maximum digit from right
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] > arr[maxPos])
                maxPos = i;
            maxIndex[i] = maxPos;
        }
        
        // find first position where swap increases value
        for(int i = 0; i < n; i++){
            if(arr[i] < arr[maxIndex[i]]){
                char temp = arr[i];
                arr[i] = arr[maxIndex[i]];
                arr[maxIndex[i]] = temp;
                break;
            }
        }
        
        return new String(arr);
    }
}