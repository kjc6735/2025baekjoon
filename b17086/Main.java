package b17086;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  static int dir[][] ={
    {0,1},{0,-1}, {1,0}, {-1,0}, {1,1},{1,-1}, {-1,1}, {-1, -1}
  };
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<int[]> queue = new LinkedList<>();
    String str[] = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);
    int map[][] = new int[N][M];
    
    for(int i = 0; i < N ; i++){
      StringTokenizer st = new StringTokenizer( br.readLine());
      for(int k = 0; k < M ; k++){
        map[i][k] = Integer.MAX_VALUE;
        int tmp = Integer.parseInt(st.nextToken());
        if(tmp == 1) {
          map[i][k] = -1;
          queue.add(new int[]{i,k});
        }
      }
    }
    
    while (!queue.isEmpty()) {
      int[] curr = queue.poll();

      for(int i = 0; i < 8; i++){
        int x = curr[0] + dir[i][0];
        int y = curr[1] + dir[i][1];
        
        if(x < 0 || y < 0 || x >= N || y >= M) continue;
        if(map[x][y] < 0) continue;
        if(map[x][y] < map[curr[0]][curr[1]] + 1) continue;
        map[x][y] = map[curr[0]][curr[1]] == -1 ? 1 : map[curr[0]][curr[1]] + 1;
        queue.add(new int[]{x,y});
      }
    }
    int max = 0;
    for(int i = 0; i < N ; i++){
      for(int k = 0; k < M ; k++){
        if(map[i][k] > max){
          max = map[i][k];
        }
      }
    }
    System.out.println(max);

  }
}
