import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        while (T-- > 0) {
            int N = sc.nextInt(); // 건물의 개수
            int K = sc.nextInt(); // 건설 순서 규칙의 수

            int[] buildTime = new int[N + 1]; // 각 건물의 건설 시간
            for (int i = 1; i <= N; i++) {
                buildTime[i] = sc.nextInt();
            }

            List<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] indegree = new int[N + 1]; // 진입 차수
            for (int i = 0; i < K; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                graph[from].add(to);
                indegree[to]++;
            }

            int W = sc.nextInt(); // 목표 건물

            int[] dp = new int[N + 1]; // 각 건물까지의 최소 시간
            Queue<Integer> queue = new LinkedList<>();

            // 진입 차수가 0인 건물부터 시작
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    dp[i] = buildTime[i];
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next : graph[current]) {
                    // 다음 건물까지의 시간은 현재 건물까지의 시간 + 다음 건물의 건설 시간
                    if (dp[next] < dp[current] + buildTime[next]) {
                        dp[next] = dp[current] + buildTime[next];
                    }
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            System.out.println(dp[W]);
        }
        sc.close();
    }
}