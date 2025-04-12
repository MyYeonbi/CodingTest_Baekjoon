import java.util.Scanner;

public class Main {
    static int R, C, max = 0;
    static char[][] board;
    static boolean[] used = new boolean[26]; // 알파벳 사용 여부 (A~Z → 0~25)
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine(); // 개행 제거

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 시작 위치 (0,0) 알파벳 사용 처리
        used[board[0][0] - 'A'] = true;
        dfs(0, 0, 1); // (x, y, depth)

        System.out.println(max);
    }

    static void dfs(int x, int y, int depth) {
        max = Math.max(max, depth); // 최댓값 갱신

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                int alphaIndex = board[nx][ny] - 'A';
                if (!used[alphaIndex]) {
                    used[alphaIndex] = true;       // 알파벳 사용 처리
                    dfs(nx, ny, depth + 1);        // 다음 칸으로 이동
                    used[alphaIndex] = false;      // 백트래킹
                }
            }
        }
    }
}