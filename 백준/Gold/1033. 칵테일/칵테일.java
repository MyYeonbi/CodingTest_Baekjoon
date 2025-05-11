import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] weight;
    static boolean[] visited;
    static ArrayList<Node>[] graph;

    static class Node {
        int to;
        int p, q;

        Node(int to, int p, int q) {
            this.to = to;
            this.p = p;
            this.q = q;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new long[N];
        visited = new boolean[N];
        graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        long lcm = 1;
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, p, q));
            graph[b].add(new Node(a, q, p));

            lcm = lcm * (p * q / gcd(p, q));
        }

        weight[0] = lcm;
        dfs(0);

        long mgcd = weight[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, weight[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(weight[i] / mgcd).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(int current) {
        visited[current] = true;
        for (Node node : graph[current]) {
            if (!visited[node.to]) {
                weight[node.to] = weight[current] * node.q / node.p;
                dfs(node.to);
            }
        }
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}