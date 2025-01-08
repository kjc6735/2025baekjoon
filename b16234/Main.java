package b16234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x; int y;
        public Node(int x, int y){
            this.x = x ; this.y = y;
        }
    }
    static boolean[][] visited = new boolean[51][51];
    static int map[][] = new int[51][51];
    static int N;
    static int dir[][] = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N ; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        while (true) {
            boolean check = false;
            clear();
            for(int i = 0; i < N ; i++){
                for(int k = 0; k < N ; k++){
                    if(visited[i][k]) continue;
                    visited[i][k] = true;
                    int sum = map[i][k];
                    Queue<Node> queue = new LinkedList<>();
                    List<Node> updateList = new ArrayList<>();
                    queue.add(new Node(i,k)); 
                    updateList.add(new Node(i,k));
                    while (!queue.isEmpty()) {
                        Node curr = queue.poll();
                        
                        for(int d = 0 ; d < 4; d ++){
                            int dx = curr.x + dir[d][0];
                            int dy = curr.y + dir[d][1];

                            if(!inRange(dx, dy)) continue;
                            if(visited[dx][dy]) continue;
                            int gap = Math.abs(map[curr.x][curr.y] - map[dx][dy]);
                            if(gap < L || gap > R) continue;
                            sum += map[dx][dy];                            
                            queue.add(new Node(dx,dy));
                            visited[dx][dy] = true;
                            updateList.add(new Node(dx,dy));
                        }
                    }
                    if(updateList.size() == 1) continue;

                    check = true;
                    int updateValue = sum / updateList.size();
                    for(Node curr : updateList){
                        map[curr.x][curr.y] = updateValue;
                    }
                }
            }
            if(!check) break;
            else cnt++;
        }
        System.out.println(cnt);

    }


    static void clear(){
        for(int i = 0; i < N ; i++){
            Arrays.fill(visited[i], false);
        }
    }
    static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && y < N && x < N;
    }
}
