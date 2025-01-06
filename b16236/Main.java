package b16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Pos implements Comparable<Pos>{
        int x; int y; int cnt = 0;

        public Pos(int x, int y){ 
            this.x = x;
            this.y = y;
        }
        public Pos(int x, int y, int cnt){ 
            this(x,y);
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pos a){
            if(this.cnt != a.cnt) return Integer.compare(this.cnt, a.cnt);
            if(this.x != a.x)return Integer.compare(this.x, a.x);
            return Integer.compare(this.y, a.y);
        } 
    }
    static int N;
    static int[][] map = new int[20][20];
    static int dir[][] = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Pos curr = null;
        int size = 2;
        int eat = 0;
        int move = 0;
        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N ; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                if(map[i][k] == 9){
                    curr = new Pos(i, k,0);
                    map[i][k] = 0;
                }
            }
        }

        while (true) {
            PriorityQueue<Pos> queue = new PriorityQueue<>();

            boolean[][] visited = new boolean[N][N];

            queue.add(new Pos(curr.x, curr.y, 0));

            visited[curr.x][curr.y] = true;

            boolean check = false;

            while (!queue.isEmpty()) {
                curr = queue.poll();
                if(map[curr.x][curr.y] != 0 && map[curr.x][curr.y] < size){
                    map[curr.x][curr.y] = 0;
                    eat ++;
                    move += curr.cnt;
                    check = true;
                    break;
                }


                for(int d = 0; d < 4; d++){
                    int dx = curr.x + dir[d][0];
                    int dy = curr.y + dir[d][1];

                    if(!inRange(dx, dy)) continue;
                    if(visited[dx][dy])continue;
                    if(map[dx][dy] > size) continue;
                    queue.add(new Pos(dx,dy, curr.cnt + 1));

                    visited[dx][dy] = true;
                }
            }

            if(!check) break;
            if(size == eat){
                size++;
                eat = 0;
            }
        }
        System.out.println(move);
    }    

    private static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
