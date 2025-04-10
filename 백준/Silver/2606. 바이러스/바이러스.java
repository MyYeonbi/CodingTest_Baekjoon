import java.util.*;

public class Main{
    static int c;
    static int n;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        
        graph = new ArrayList[c+1];
        visited = new boolean[c+1];
        
        for (int i = 1; i <= c ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        
        bfs(1);
        
        System.out.println(count -1); //1번 컴퓨터 제외
    }
    
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            count++;
            
            for (int next: graph[now]){
                if (!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}