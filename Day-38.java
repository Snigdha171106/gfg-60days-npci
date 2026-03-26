import java.util.*;

class Solution {

    public int countPaths(int V, int[][] edges) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        for(int[] e: edges){
            adj.get(e[0]).add(new int[]{e[1],e[2]});
            adj.get(e[1]).add(new int[]{e[0],e[2]});
        }

        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[V];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){

            long[] cur = pq.poll();
            int node = (int)cur[0];
            long d = cur[1];

            if(d > dist[node]) continue;

            for(int[] next: adj.get(node)){

                int v = next[0];
                int wt = next[1];

                long newDist = d + wt;

                if(newDist < dist[v]){

                    dist[v] = newDist;
                    ways[v] = ways[node];
                    pq.add(new long[]{v,newDist});
                }

                else if(newDist == dist[v]){

                    ways[v] += ways[node];
                }
            }
        }

        return ways[V-1];
    }
}