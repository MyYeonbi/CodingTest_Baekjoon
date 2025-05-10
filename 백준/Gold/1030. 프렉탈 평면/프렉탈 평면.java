import java.io.*;
import java.util.*;

public class Main {
    static int s, N, K, R1, R2, C1, C2;
    static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        int rows = R2 - R1 + 1;
        int cols = C2 - C1 + 1;
        result = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(result[i], '0');
        }

        draw(0, 0, (int) Math.pow(N, s), false);

        StringBuilder sb = new StringBuilder();
        for (char[] row : result) {
            sb.append(row).append('\n');
        }
        System.out.print(sb.toString());
    }

    static void draw(int x, int y, int size, boolean filled) {
        if (x > C2 || x + size <= C1 || y > R2 || y + size <= R1) {
            return;
        }

        if (size == 1) {
            if (y >= R1 && y <= R2 && x >= C1 && x <= C2) {
                result[y - R1][x - C1] = filled ? '1' : '0';
            }
            return;
        }

        int newSize = size / N;
        int start = (N - K) / 2;
        int end = start + K;

        for (int i = 0; i < N; i++) {
            int ny = y + i * newSize;
            for (int j = 0; j < N; j++) {
                int nx = x + j * newSize;
                boolean nextFilled = filled || (i >= start && i < end && j >= start && j < end);
                draw(nx, ny, newSize, nextFilled);
            }
        }
    }
}