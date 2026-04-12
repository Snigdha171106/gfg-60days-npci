class Solution {
    
    public int countIncreasing(int arr[]) {
        
        int n = arr.length;
        int len = 1;
        int count = 0;
        
        for(int i = 1; i < n; i++){
            
            if(arr[i] > arr[i-1]){
                len++;
                count += (len - 1);
            }
            else{
                len = 1;
            }
        }
        
        return count;
    }
}