package b32360;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int x; int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class MinPos extends Pos {
        int cnt;
        int thi;
        public MinPos(int x, int y, int cnt, int thi) {
            super(x, y);
            this.cnt = cnt;
            this.thi = thi;

        }
    }

    static int N,M,C,K;
    static char map[][] = new char[100][100];
    static boolean[][][] visited = new boolean[101][101][101];
    static Pos START, END;
    static int dir[][] = {
        {0,1}, {0,-1}, {1,0}, {-1,0}, {0,0}
    };
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N ; i++){
            map[i] = br.readLine().toCharArray();
            for(int k = 0; k < M; k++){
                if(map[i][k] == 'S'){
                    START = new Pos(i, k);
                }else if(map[i][k] == 'E'){
                    END = new Pos(i, k);
                }
            }
        }

        Queue<MinPos> queue = new LinkedList<>();

        queue.add(new MinPos(START.x, START.y, 0,0));
        
        while (!queue.isEmpty()) {
            MinPos curr = queue.poll();
            if(curr.x == END.x && curr.y == END.y && curr.thi > 0){
                System.out.println(curr.cnt);
                return ;
            }
            
            for(int i = 0; i < 5;i++){
                int dx = curr.x + dir[i][0];
                int dy = curr.y + dir[i][1];
                
                if(!inRange(dx, dy)) continue;
                if(map[dx][dy] == '#') continue;
                int nextTHI = map[dx][dy] == 'H' ||  map[dx][dy] == 'S' ? max(0,curr.thi - K) : min(100, curr.thi + C);
                if(nextTHI >= 100 || nextTHI < 0) continue;
                if(visited[dx][dy][nextTHI]) continue;
                visited[dx][dy][nextTHI] = true;
                queue.add(new MinPos(dx, dy, curr.cnt + 1, nextTHI));
            }
        }
        System.out.println(-1);
    }

    static boolean inRange(int x ,int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    static int max (int a, int b){
        return a > b ? a : b;
    }
    static int min (int a, int b){
        return a > b ? b: a;
    }
}
