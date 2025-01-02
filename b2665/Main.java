package b2665;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    public static class Node{
        int x; int y;
        public Node(int x, int y){ this.x = x; this.y = y;}
    }
    static int max = Integer.MAX_VALUE;
    static int N;
    static String[] map = new String[50];
    static int[][] dist = new int[50][50];
    static int dir[][] = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2665/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < N; i ++){
            map[i] = br.readLine();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            for(int i = 0; i < 4; i++){
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];
                if(!inRange(dx, dy)) continue;
                if(map[dx].charAt(dy) == '0' && dist[x][y] + 1 >= dist[dx][dy]) continue;
                if(map[dx].charAt(dy) == '1' && dist[x][y] >= dist[dx][dy]) continue;
                queue.add(new Node(dx,dy));
                dist[dx][dy] = map[dx].charAt(dy) == '1' ? dist[x][y] : dist[x][y]+1;
            }
        }
        
        System.out.println(dist[N-1][N-1]);
    }



    private static boolean inRange(int x, int y){
        return x >= 0 && y>= 0 && x < N && y < N;
    }
}
