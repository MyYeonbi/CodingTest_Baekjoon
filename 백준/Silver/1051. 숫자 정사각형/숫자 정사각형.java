import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 행의 수
        int M = sc.nextInt(); // 열의 수
        sc.nextLine(); // 개행 문자 처리

        int[][] board = new int[N][M];

        // 직사각형 입력 받기
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int maxSize = 1; // 최소 정사각형 크기

        // 가능한 모든 정사각형 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 정사각형의 한 변의 길이
                for (int k = 1; i + k < N && j + k < M; k++) {
                    if (board[i][j] == board[i][j + k] &&
                        board[i][j] == board[i + k][j] &&
                        board[i][j] == board[i + k][j + k]) {
                        int size = (k + 1) * (k + 1);
                        if (size > maxSize) {
                            maxSize = size;
                        }
                    }
                }
            }
        }

        System.out.println(maxSize);
    }
}