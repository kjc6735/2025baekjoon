package b18290;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N,M,K, max = 0;
  static int map[][] = new int[10][10];
  static boolean visited[][] = new boolean[10][10];
  static int dir[][] = {
    {0,1},{0,-1},{1,0},{-1,0}
  };
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    for(int i = 0; i < N ; i++){
      st = new StringTokenizer(br.readLine());
      for(int k = 0; k < M; k++){
        map[i][k] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i = 0; i < N*M; i++){
      int x = i / N;
      int y = i % M;
      fn(i, 1, map[x][y]);
      for(int k = 0; k < N ;k++) Arrays.fill(visited[k], false);
    }
  }

  private static void fn(int curr, int cnt, int sum){
    if(cnt == K){
      if(max < cnt) max = cnt;

      return ;
    }
    if(curr >= 100) return ;

    int x = curr / N;
    int y = curr % M;


    
  }
}
