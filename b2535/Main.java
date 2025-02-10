package b2535;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->  b[2] - a[2]);
        int[] country = new int[101];
        StringTokenizer st;
        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b,c});
        }
        StringBuilder sb  =new StringBuilder();
        int cnt = 0;
        while (cnt != 3) {
            int curr[] = pq.poll();
            if(country[curr[0]] >= 2 ) continue;
            country[curr[0]]+=1;
            cnt ++;
            sb.append(curr[0]).append(" ").append(curr[1]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
