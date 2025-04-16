import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N, M;
    static char[][] grid;
    static Set<Integer> squares = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new char[N][M];
        
        // 표 입력
        for (int i = 0; i < N; i++) {
            grid[i] = sc.next().toCharArray();
        }
        
        // 가능한 모든 제곱수 미리 생성 (1~999999999)
        generateSquares();
        
        int maxSquare = -1;
        
        // 모든 시작점과 등차 조합 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int di = -N; di <= N; di++) {
                    for (int dj = -M; dj <= M; dj++) {
                        if (di == 0 && dj == 0) continue;
                        
                        StringBuilder num = new StringBuilder();
                        int x = i, y = j;
                        
                        while (x >= 0 && x < N && y >= 0 && y < M) {
                            num.append(grid[x][y]);
                            int current = Integer.parseInt(num.toString());
                            if (squares.contains(current)) {
                                maxSquare = Math.max(maxSquare, current);
                            }
                            x += di;
                            y += dj;
                        }
                    }
                }
            }
        }
        System.out.println(maxSquare);
    }
    
    static void generateSquares() {
        for (int i = 0; i <= 31623; i++) { // 31623² ≈ 1e9
            squares.add(i * i);
        }
    }
}