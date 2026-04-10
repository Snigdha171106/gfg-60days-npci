import java.util.*;

class Solution {

    public int[] stableMarriage(int[][] men, int[][] women) {

        int n = men.length;

        int[] womenPartner = new int[n];
        int[] menPartner = new int[n];
        int[] nextProposal = new int[n];

        Arrays.fill(womenPartner, -1);
        Arrays.fill(menPartner, -1);

        int[][] ranking = new int[n][n];

        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                ranking[w][women[w][i]] = i;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) freeMen.add(i);

        while (!freeMen.isEmpty()) {

            int m = freeMen.poll();
            int w = men[m][nextProposal[m]];
            nextProposal[m]++;

            if (womenPartner[w] == -1) {
                womenPartner[w] = m;
                menPartner[m] = w;
            }
            else {

                int current = womenPartner[w];

                if (ranking[w][m] < ranking[w][current]) {

                    womenPartner[w] = m;
                    menPartner[m] = w;
                    menPartner[current] = -1;

                    freeMen.add(current);
                }
                else {
                    freeMen.add(m);
                }
            }
        }

        return menPartner;
    }
}