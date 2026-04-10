import java.util.*;

class Solution {

    public int minCost(int[][] houses) {

        int n = houses.length;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        int cost = 0;

        for(int i = 0; i < n; i++){

            int u = -1;

            for(int j = 0; j < n; j++){
                if(!visited[j] && (u == -1 || dist[j] < dist[u]))
                    u = j;
            }

            visited[u] = true;
            cost += dist[u];

            for(int v = 0; v < n; v++){

                if(!visited[v]){

                    int d = Math.abs(houses[u][0] - houses[v][0]) +
                            Math.abs(houses[u][1] - houses[v][1]);

                    dist[v] = Math.min(dist[v], d);
                }
            }
        }

        return cost;
    }
}