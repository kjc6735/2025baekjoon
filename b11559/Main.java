package b11559;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.channels.Pipe.SourceChannel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  static char EMPTY = '.';
  static char R = 'R';
  static char G = 'G';
  static char B = 'B';
  static char P = 'P';
  static char Y = 'Y';
  static char arr[][] = new char [12][6];
  static int dir[][] = {
    {0,1}, {0,-1}, {1,0}, {-1,0}
  };
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int result = 0;
    for(int k = 0; k < 12; k++){
      arr[k] = br.readLine().toCharArray();
    }
    
    while (true) {
      int cnt = 0;
      for(int i = 11; i >= 0; i--){
        for(int k = 0; k < 6; k++){
          if(arr[i][k] == EMPTY) continue;
          Queue<int[]> tmp = new LinkedList<>();
          Queue<int[]> queue = new LinkedList<>();
          Set<String> set = new HashSet<>();

          queue.add(new int[]{i,k, arr[i][k]});
          tmp.add(new int[]{i,k,arr[i][k]});
          set.add(i + " " + k);
          while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int v = curr[2];
            
            for(int d = 0; d < 4; d ++){
              int dx = x + dir[d][0];
              int dy = y + dir[d][1];
  
              if(!inRange(dx, dy)) continue;
              if(arr[dx][dy] != v) continue; 
              if(set.contains(dx + " " + dy)) continue;
              
              set.add(dx + " " + dy);
              queue.add(new int[]{dx,dy, arr[dx][dy]});
              tmp.add(new int[]{dx,dy, arr[dx][dy]});
            }
          }
          boolean isBoom = tmp.size() >= 4;
          if(!isBoom) continue;
        
          boom(tmp);
          cnt ++;
        }
      }
      
      if(cnt == 0) break;
      mapClear();
    
      result++;
    }
    
    System.out.println(result);
  }

  private static void boom(Queue<int[]> tmp){
      while (!tmp.isEmpty()) {
        int[] t = tmp.poll();
        arr[t[0]][t[1]] = EMPTY;
      }
  }

  private static void mapClear(){
    for(int k = 0 ; k < 6; k++){
      for(int i = 11; i >= 0; i--){
        if(arr[i][k] == EMPTY) continue;
        int tmp = i;

        while (tmp < 11 && arr[tmp + 1][k] == EMPTY){
          arr[tmp+1][k] = arr[tmp][k];
          arr[tmp][k] = EMPTY;
          tmp++;
        }
      }
    }
  }

  private static boolean inRange(int x, int y){
    return 12 > x && x >= 0 && 6 > y && y >= 0;
  }

}

