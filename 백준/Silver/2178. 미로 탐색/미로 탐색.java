import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] distance;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];

        // 1. 입력 받기
        for (int i = 0; i < N; i++) {
            String line = sc.next(); // 한 줄씩 입력 받음
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자 → 숫자
            }
        }

        // 2. BFS 수행
        bfs(0, 0);

        // 3. 도착지의 거리 출력
        System.out.println(distance[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        distance[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 체크 + 이동 가능 + 미방문
                if (nx >= 0 && nx < N && ny >= 0 && ny < M
                        && map[nx][ny] == 1 && !visited[nx][ny]) {

                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[cx][cy] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}