import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 1~N
        M = sc.nextInt(); // M개 고르기

        visited = new boolean[N + 1]; // 1-based index
        result = new int[M]; // 결과 저장용

        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            // M개 모두 골랐을 경우 출력
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        // 1부터 N까지 시도
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i; // 현재 위치에 숫자 저장
                dfs(depth + 1);    // 다음 깊이로
                visited[i] = false; // 백트래킹
            }
        }
    }
}