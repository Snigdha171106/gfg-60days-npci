import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countSubarrays(int[] arr) { // Changed return type to int
        int n = arr.length;
        int[] nse = new int[n];
        
        // Using Deque as it is faster than Stack in Java
        Deque<Integer> stack = new ArrayDeque<>();

        // Find Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = stack.peek();
            }
            
            stack.push(i);
        }

        int totalSubarrays = 0; // Changed to int to match the error's expectation
        for (int i = 0; i < n; i++) {
            totalSubarrays += (nse[i] - i);
        }

        return totalSubarrays;
    }
}