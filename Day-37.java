import java.util.*;

class Solution {

    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (V == 1) {
            ans.add(0);
            return ans;
        }

        List<Set<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++)
            graph.add(new HashSet<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        ArrayList<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (graph.get(i).size() == 1)
                leaves.add(i);
        }

        int remaining = V;

        while (remaining > 2) {

            remaining -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {

                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);

                if (graph.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }

            leaves = newLeaves;
        }

        ans.addAll(leaves);
        return ans;
    }
}