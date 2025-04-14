import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt();
            int n = sc.nextInt();
            int count = 0;
            
            for (int i = 0; i < n; i++) {
                int cx = sc.nextInt(), cy = sc.nextInt(), r = sc.nextInt();
                boolean startIn = isInside(x1, y1, cx, cy, r);
                boolean endIn = isInside(x2, y2, cx, cy, r);
                
                if (startIn ^ endIn) { // XOR: 하나만 true일 때
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
    
    private static boolean isInside(int x, int y, int cx, int cy, int r) {
        return Math.pow(x - cx, 2) + Math.pow(y - cy, 2) < Math.pow(r, 2);
    }
}