import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 세로
        M = sc.nextInt(); // 가로

        map = new int[N][M];
        visited = new boolean[N][M];

        // 지도 정보 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt(); // 0 또는 1
            }
        }

        int pictureCount = 0; // 그림(덩어리) 개수
        int maxArea = 0;      // 가장 넓은 그림 넓이

        // 전체를 돌며 BFS 실행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int area = bfs(i, j); // 이 그림의 넓이
                    pictureCount++;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        // 출력
        System.out.println(pictureCount);
        System.out.println(maxArea);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        int area = 1; // 시작점 포함해서 넓이 1

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M
                        && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    area++;
                }
            }
        }

        return area;
    }
}