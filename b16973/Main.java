package b16973;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int map[][] = new int[1001][1001];
    static boolean visited[][] = new boolean[1001][1001];
    static int N,M,H,W;
    static int dir[][] = {
        {0,1},{0,-1}, {1,0}, {-1, 0}
    };
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                if(map[i][k] == 1) visited[i][k] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken()) -1;
        int y1 = Integer.parseInt(st.nextToken()) -1;
        int x2 = Integer.parseInt(st.nextToken()) -1;
        int y2 = Integer.parseInt(st.nextToken()) -1;
        
        visited[x1][y1] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1, 0});
        
        while (!queue.isEmpty()) {
            int curr[] = queue.poll();
            if(curr[0] == x2 && curr[1] == y2) {
                System.out.println(curr[2]);
                return ;
            }
            
            for(int d = 0; d < 4; d++){
                int dx = curr[0] + dir[d][0];
                int dy = curr[1] + dir[d][1];
                if(dx <0 || dy < 0 || dx + H -1 >= N || dy + W - 1 >= M) continue;
                if(visited[dx][dy]) continue;
                
                //{0,1},{0,-1}, {1,0}, {-1, 0}
                boolean check = false;
                if(d == 0){
                    int y = dy + W-1;
                    for(int tmp = dx; tmp < dx + H; tmp++){
                        if(map[tmp][y] == 1){
                            check = true;
                            break;
                        }
                    }
                }else if(d == 1){
                    for(int tmp = dx; tmp < dx + H; tmp++){
                        if(map[tmp][dy] == 1){
                            check = true;
                            break;
                        }
                    }
                }else if(d == 2){
                    int x = dx + H - 1;
                    for(int tmp = dy; tmp < dy + W; tmp++){
                        if(map[x][tmp] == 1){
                            check = true;
                            break;
                        }
                    }
                }else {

                    for(int tmp = dy; tmp < dy + W; tmp++){
                        if(map[dx][tmp] == 1){
                            check = true;
                            break;
                        }
                    }
                }
                if(check) continue;


                visited[dx][dy] = true;
                
                queue.add(new int[]{dx,dy,curr[2] + 1}); 
            }
        }

        System.out.println(-1);
    }
}
