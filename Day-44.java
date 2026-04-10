class Solution {
    
    public int countStrings(int n) {
        
        long end0 = 1;
        long end1 = 1;
        
        for(int i = 2; i <= n; i++){
            
            long new_end0 = end0 + end1;
            long new_end1 = end0;
            
            end0 = new_end0;
            end1 = new_end1;
        }
        
        return (int)(end0 + end1);
    }
}