import java.util.*;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        while (T-- > 0) {
            M = sc.nextInt(); // 가로
            N = sc.nextInt(); // 세로
            int K = sc.nextInt(); // 배추 위치 개수

            field = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = 1;
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}