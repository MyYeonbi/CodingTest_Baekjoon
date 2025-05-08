import java.util.*;

public class Main {
    static final int SIZE = 5;
    static List<Point> pieces = new ArrayList<>();
    static int minMoves = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[SIZE][SIZE];

        // 입력 및 조각 위치 저장
        for (int i = 0; i < SIZE; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == '*') {
                    pieces.add(new Point(i, j));
                }
            }
        }

        // 모든 위치 조합 생성
        List<Point> allPositions = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                allPositions.add(new Point(i, j));
            }
        }

        // 조각 수만큼의 위치 조합을 생성하고 처리
        combine(allPositions, new Point[pieces.size()], 0, 0);

        System.out.println(minMoves);
    }

    // 조합 생성
    static void combine(List<Point> positions, Point[] temp, int start, int depth) {
        if (depth == temp.length) {
            if (isConnected(temp)) {
                permute(temp, 0, new boolean[temp.length], new Point[temp.length]);
            }
            return;
        }
        for (int i = start; i < positions.size(); i++) {
            temp[depth] = positions.get(i);
            combine(positions, temp, i + 1, depth + 1);
        }
    }

    // 인접성 확인
    static boolean isConnected(Point[] points) {
        Set<Point> set = new HashSet<>(Arrays.asList(points));
        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();

        queue.add(points[0]);
        visited.add(points[0]);

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                Point neighbor = new Point(nx, ny);
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && set.contains(neighbor) && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return visited.size() == points.length;
    }

    // 순열 생성 및 거리 계산
    static void permute(Point[] targets, int depth, boolean[] used, Point[] current) {
        if (depth == targets.length) {
            int total = 0;
            for (int i = 0; i < current.length; i++) {
                total += Math.abs(pieces.get(i).x - current[i].x) + Math.abs(pieces.get(i).y - current[i].y);
            }
            minMoves = Math.min(minMoves, total);
            return;
        }
        for (int i = 0; i < targets.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current[depth] = targets[i];
                permute(targets, depth + 1, used, current);
                used[i] = false;
            }
        }
    }

    // Point 클래스 정의
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // equals 및 hashCode 오버라이드
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}