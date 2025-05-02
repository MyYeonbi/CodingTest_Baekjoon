import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextLine());
        }

        List<String> list = new ArrayList<>(set);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length(); // 짧은 게 먼저
                }
                return s1.compareTo(s2); // 길이가 같으면 사전순
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}