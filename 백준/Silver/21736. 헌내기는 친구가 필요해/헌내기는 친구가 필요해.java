import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static int friendCount = 0; // 친구(P)를 만난 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 개행 제거

        map = new char[N][M];
        visited = new boolean[N][M];

        int startX = 0;
        int startY = 0;

        // 지도 입력 받기 + 시작점 'I' 찾기
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        // 결과 출력
        System.out.println(friendCount == 0 ? "TT" : friendCount);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            // 친구 만나면 카운트 증가
            if (map[cx][cy] == 'P') {
                friendCount++;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M
                        && !visited[nx][ny]
                        && map[nx][ny] != 'X') { // 벽(X)은 못 감
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}