package b2583;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N,K ;
    static int map[][] = new int[101][101];
    static int dir[][] = {
        {0,1},{1,0}, {0,-1}, {-1,0}
    };
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2583/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int maxX = max(x1, x2);
            int maxY = max(y1,y2);
            int minX = min(x1,x2);
            int minY = min(y1, y2);

            for(int x = minX; x < maxX; x++){
                for(int y = minY; y < maxY; y++){
                    map[x][y]++;
                }
            }
           
        }

        

        for(int i = 0; i < N;  i++){
            for(int k = 0 ; k < M ; k++){
                if(map[i][k] != 0) continue;
                int cnt = 1;
                map[i][k] = 1;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,k});
                
                while (!queue.isEmpty()) {
                    int curr[] = queue.poll();

                    for(int d = 0; d < 4; d ++){
                        int dx = curr[0] + dir[d][0];
                        int dy = curr[1] + dir[d][1];

                        if(!inRange(dx,dy)) continue;
                        if(map[dx][dy] != 0) continue;
                        cnt ++;
                        queue.add(new int[]{dx,dy});
                        map[dx][dy] = 1;
                    }
                }
                pq.add(cnt);
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb.toString());
    }
    private static boolean inRange(int x, int y){
        return x>= 0 && y>= 0&& x < N && y < M;
    }

    private static int max(int a, int b){
        return a > b ? a : b;
    }
    private static int min(int a, int b){
        return a > b ? b : a;
    }

}
