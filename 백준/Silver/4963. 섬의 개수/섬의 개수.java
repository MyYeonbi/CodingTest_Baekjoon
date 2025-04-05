import java.util.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    // 방향 배열(대각선 포함)
    static int[] dx = {-1,-1,-1,1,1,1,0,0};
    static int[] dy = {0,-1,1,0,-1,1,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w &&
                    !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}