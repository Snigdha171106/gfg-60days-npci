import java.util.*;

class Solution {

    public List<Integer> find3Numbers(int[] arr) {

        int n = arr.length;

        int[] smaller = new int[n];
        int[] greater = new int[n];

        Arrays.fill(smaller, -1);
        Arrays.fill(greater, -1);

        int minIndex = 0;

        for(int i = 1; i < n; i++){
            if(arr[i] <= arr[minIndex])
                minIndex = i;
            else
                smaller[i] = minIndex;
        }

        int maxIndex = n - 1;

        for(int i = n - 2; i >= 0; i--){
            if(arr[i] >= arr[maxIndex])
                maxIndex = i;
            else
                greater[i] = maxIndex;
        }

        for(int i = 0; i < n; i++){
            if(smaller[i] != -1 && greater[i] != -1){

                List<Integer> res = new ArrayList<>();
                res.add(arr[smaller[i]]);
                res.add(arr[i]);
                res.add(arr[greater[i]]);

                return res;
            }
        }

        return new ArrayList<>();
    }
}