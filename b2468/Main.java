package b2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[100][100];
    static int N;
    static int[][] dir = {
        {0,1},{0,-1}, {-1,0}, {1,0}
    };
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N ; k++){
                map[i][k ] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;

        int safeArea = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int h = 0; h <= 100; h++){
            for(int i =0; i < N ; i++){
                for(int k = 0; k < N ; k++){
                    if(map[i][k] <= h) continue;
                    if(set.contains(i*100 + k)) continue;
                    queue.add(new int[]{i,k});
                    set.add(i*100+k);
                    cnt ++;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for(int d = 0; d < 4; d++){
                            int dx = curr[0] + dir[d][0];
                            int dy = curr[1] + dir[d][1];
                            if(!inRange(dx, dy)) continue;
                            if(set.contains(dx*100 + dy)) continue;
                            if(map[dx][dy] <= h) continue;
                            queue.add(new int[]{dx,dy});
                            set.add(dx * 100 + dy);
                        }
                    }
                }
            }
            if(safeArea < cnt) safeArea = cnt;
            cnt = 0;
            set.clear();
        }

        System.out.println(safeArea);
    }


    private static boolean inRange(int x, int y){
        return x>= 0 && y >= 0 && x < N && y < N;
    }
    
}
