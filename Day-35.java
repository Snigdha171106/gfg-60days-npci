import java.util.*;

class Solution {

    public int longestCycle(int V, int[][] edges) {

        int[] next = new int[V];
        Arrays.fill(next, -1);

        for(int[] e : edges) {
            next[e[0]] = e[1];
        }

        boolean[] visited = new boolean[V];
        int ans = -1;

        for(int i = 0; i < V; i++) {

            if(visited[i]) continue;

            Map<Integer,Integer> map = new HashMap<>();
            int node = i;
            int time = 0;

            while(node != -1 && !visited[node]) {

                visited[node] = true;
                map.put(node, time++);

                node = next[node];

                if(node != -1 && map.containsKey(node)) {
                    ans = Math.max(ans, time - map.get(node));
                    break;
                }
            }
        }

        return ans;
    }
}  