import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;

        // 덱 초기화 (1~N)
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            int position = 0;
            
            // 타겟의 위치 찾기
            for (int num : deque) {
                if (num == target) break;
                position++;
            }

            int leftCost = position;
            int rightCost = deque.size() - position;

            if (leftCost <= rightCost) {
                // 왼쪽 이동
                for (int j = 0; j < leftCost; j++) {
                    deque.addLast(deque.pollFirst());
                }
                count += leftCost;
            } else {
                // 오른쪽 이동
                for (int j = 0; j < rightCost; j++) {
                    deque.addFirst(deque.pollLast());
                }
                count += rightCost;
            }
            deque.pollFirst(); // 타겟 제거
        }
        System.out.println(count);
        sc.close();
    }
}