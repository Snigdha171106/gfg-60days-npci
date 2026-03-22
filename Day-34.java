import java.util.*;

class Solution {

    public int orangesRot(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 2)
                    q.add(new int[]{i,j});
                else if(mat[i][j] == 1)
                    fresh++;
            }
        }

        int time = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){

            int size = q.size();
            boolean changed = false;

            for(int i = 0; i < size; i++){

                int[] cur = q.poll();

                for(int[] d : dir){

                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];

                    if(x>=0 && y>=0 && x<n && y<m && mat[x][y]==1){

                        mat[x][y] = 2;
                        fresh--;
                        q.add(new int[]{x,y});
                        changed = true;
                    }
                }
            }

            if(changed) time++;
        }

        return fresh == 0 ? time : -1;
    }
}