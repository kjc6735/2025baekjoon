package b18352;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] arr = new ArrayList[300_001]; 
    static boolean visited[] = new boolean[300_001];
    static {
        for(int i =0 ; i <= 300_000; i++){
            arr[i] = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{X,0});
        visited[X] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if(curr[1] == K){
                pq.add(curr[0]);
                continue;
            }
            
            for(int next: arr[curr[0]]){
                if(visited[next]) continue;
                visited[next] = true;
                queue.add(new int[]{next, curr[1]+1});
            }
        }
        if(pq.isEmpty()) {
            System.out.println(-1);
            return ;
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb.toString());

    }
}
