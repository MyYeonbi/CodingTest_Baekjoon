import java.util.*;

public class Main {
    // 방향 배열 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1 };

    // 변수 선언
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> countList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int count = bfs(i, j);
                    countList.add(count);
                }
            }
        }

        Collections.sort(countList);
        System.out.println(countList.size());
        for (int count : countList) {
            System.out.println(count);
        }
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY});
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N
                        && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    count++;
                }
            }
        }

        return count;
    }
}