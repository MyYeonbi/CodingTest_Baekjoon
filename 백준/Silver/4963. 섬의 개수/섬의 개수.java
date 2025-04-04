import java.util.*;

public class Main {

    // 8방향: ↖ ↑ ↗ → ↘ ↓ ↙ ←
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();  // 너비 (열)
            h = sc.nextInt();  // 높이 (행)

            // 입력 종료 조건
            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            // 지도 입력 받기
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int count = 0;

            // 전체 탐색
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        count++;  // 섬 하나 발견!
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
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 8방향 탐색
            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 안 + 땅 + 방문X
                if (nx >= 0 && nx < h && ny >= 0 && ny < w
                        && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}