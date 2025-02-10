package b30106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int map[][] = new int[501][501];
    static boolean visited[][] = new boolean[501][501];
    static int dir [][] = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    static int N,M,K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());
        
        // 입력
        for(int i =0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0 ; k < M ; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        for(int i =0; i < N ; i++){
            for(int k = 0 ; k < M ; k++){
                if(visited[i][k]) continue;
                cnt ++;
                Queue<int[]> queue = new LinkedList<>();

                queue.add(new int[]{i,k});
                visited[i][k] = true;
                
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    
                    for(int d = 0 ;d < 4; d ++){
                        int dx = curr[0] + dir[d][0];
                        int dy = curr[1] + dir[d][1];
                        if(!inRange(dx, dy)) continue;
                        if(visited[dx][dy]) continue;
                        int gap = Math.abs(map[curr[0]][curr[1]] - map[dx][dy]);
                        if(gap > K) continue;
                        visited[dx][dy] = true;
                        queue.add(new int[]{dx,dy});
                    }
                }

            }
        }
        System.out.println(cnt);    
    }

    static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }

}
