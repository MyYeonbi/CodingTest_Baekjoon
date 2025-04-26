import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 전체 사람 수 (사용하지는 않음)
        int a = sc.nextInt(); // 김지민 번호
        int b = sc.nextInt(); // 라이벌 번호

        int round = 0; // 라운드 수

        while (a != b) { // 둘이 만나기 전까지
            a = (a + 1) / 2; // 다음 라운드 번호
            b = (b + 1) / 2;
            round++; // 라운드 증가
        }

        System.out.println(round); // 만나는 라운드 출력
    }
}