import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = 1;
            
            a %= 10;
            if (a == 0) {
                System.out.println(10);
                continue;
            }
            
            // 주기성 적용 (4주기)
            b = (b % 4 == 0) ? 4 : b % 4;
            
            for (int j = 0; j < b; j++) {
                result = (result * a) % 10;
            }
            System.out.println(result == 0 ? 10 : result);
        }
        sc.close();
    }
}