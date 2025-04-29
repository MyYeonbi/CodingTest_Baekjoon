import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(sc.nextLine());
            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(sc.nextLine());
            }

            list.sort(new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    if (s1.equals(s2)) return 0;
                    if (s1.startsWith(s2)) return 1;
                    if (s2.startsWith(s1)) return -1;

                    int len = Math.min(s1.length(), s2.length());
                    for (int i = 0; i < len; i++) {
                        char c1 = s1.charAt(i);
                        char c2 = s2.charAt(i);
                        if (c1 == c2) continue;

                        if (c1 == '-' && c2 != '-') return 1;
                        if (c1 != '-' && c2 == '-') return -1;

                        char lc1 = Character.toLowerCase(c1);
                        char lc2 = Character.toLowerCase(c2);
                        if (lc1 != lc2) return lc1 - lc2;

                        if (Character.isUpperCase(c1) && Character.isLowerCase(c2)) return -1;
                        if (Character.isLowerCase(c1) && Character.isUpperCase(c2)) return 1;
                    }
                    return s1.length() - s2.length();
                }
            });

            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}