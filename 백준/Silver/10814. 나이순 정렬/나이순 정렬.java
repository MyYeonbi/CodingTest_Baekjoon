import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Member> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            list.add(new Member(age, name));
        }

        // 나이순 정렬 (안정정렬 유지)
        list.sort(Comparator.comparingInt(m -> m.age));

        StringBuilder sb = new StringBuilder();
        for (Member member : list) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        System.out.print(sb.toString());
    }
}