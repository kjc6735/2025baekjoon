package b24479;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
   
    static int visitied[] = new int[100_001];
    static List<Integer>[] list = new List[100_001];
    static {
        for(int i = 0; i < list.length; i++) list[i] = new ArrayList<>();
    }
    static int N,M,R, INDEX=1;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list[a].add(b);
            list[b].add(a);
        }
        for(int i = 0; i <= N; i++){
            list[i].sort((a,b) -> a - b);
        }
        fn(R);
        for(int i = 1; i <= N ; i++){
            sb.append(visitied[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
    private static void fn(int curr){
        visitied[curr] = INDEX++;
        for(int next : list[curr]){
            if(visitied[next] == 0) {
                fn(next);
            }
        }

        
    }

}
