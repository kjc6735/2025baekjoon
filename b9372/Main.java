package b9372;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int visited[] = new int[1001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<Integer>[] arr = new ArrayList[1001];
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(arr[a] == null) arr[a] = new ArrayList<>();
                if(arr[b] == null) arr[b] = new ArrayList<>();

                arr[a].add(b);
                arr[b].add(a);
            }
            int minCnt = Integer.MAX_VALUE;


            for(int start = 1; start <= N ; start++){
                Arrays.fill(visited, 0);

                int cnt = 0; // 탄 횟수
                
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                visited[start] ++;
                while (!queue.isEmpty()) {
                    
                    int curr = queue.poll();
                    
                    for(int next: arr[curr]){
                        if(arr[next].size() == 1 && visited[next] != 0) continue;
                        else if(arr[next].size() != 1 && arr[next].size() -1 == visited[next]) continue;
                        queue.add(next);
                        visited[next]+=1;
                        cnt ++;
                        break;
                    }
                }
                minCnt = minCnt > cnt ? cnt : minCnt;
            }
            sb.append(minCnt).append("\n");
        }

        System.out.println(sb.toString());
        
    }
}
