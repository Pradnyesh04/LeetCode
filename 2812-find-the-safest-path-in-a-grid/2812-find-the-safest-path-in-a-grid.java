import java.util.*;

class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int[][] best = new int[n][n];
        for (int[] row : best) {
            Arrays.fill(row, -1);
        }

        pq.offer(new int[]{dist[0][0], 0, 0});
        best[0][0] = dist[0][0];

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int safe = cur[0];
            int x = cur[1];
            int y = cur[2];

            if (x == n - 1 && y == n - 1) {
                return safe;
            }

            if (safe < best[x][y]) {
                continue;
            }

            for (int[] d : dir) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                int newSafe = Math.min(safe, dist[nx][ny]);

                if (newSafe > best[nx][ny]) {
                    best[nx][ny] = newSafe;
                    pq.offer(new int[]{newSafe, nx, ny});
                }
            }
        }

        return 0;
    }
}