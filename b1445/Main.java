package b1445;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N,M;
  static char[][] arr= new char[50][50];
  
  static class Position {
    int x; int y; int gCnt; int gNextCnt; int moveCnt;
    public Position(int x, int y){
      this.x = x;
      this.y = y;
    }
    public Position(int x, int y, int gCnt, int gNextCnt, int moveCnt){
      this.x = x;
      this.y = y;
      this.gCnt = gCnt;
      this.gNextCnt = gNextCnt;
    }
  }

  static int[][][] visitied = new int[50][50][10];

  static int dir[][] = {
    {0,1}, {0,-1}, {1,0}, {-1,0}
  };
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    Position start = null;
    Position dest = null;
    for(int i = 0; i < N ; i++){
      arr[i] = br.readLine().toCharArray();
      for(int k = 0; k < M ; k++){
        if(arr[i][k] == 'S') start = new Position(i, k);
        if(arr[i][k] == 'F') dest = new Position(i, k);
      
      }
    }


    for(int i = 0; i < N ; i++){
      for(int k = 0; k < M ; k++){
        Arrays.fill(visitied[i][k], Integer.max(Integer.MAX_VALUE, Integer.MAX_VALUE));
        if(arr[i][k] != 'g') continue;
        
        for(int d = 0 ; d < 4; d ++){
          int dx = i + dir[d][0];
          int dy = k + dir[d][1];
          if(!inRange(dx, dy)) continue;
          if(arr[dx][dy] != '.') continue;
          arr[dx][dy] = 't';
        }
      }
    }


    Queue<Position> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      Position curr = queue.poll();
      
      for(int d = 0; d < 4 ; d ++){
        int dx = curr.x + dir[d][0];
        int dy = curr.y + dir[d][1];
        if(!inRange(dx, dy)) continue;
        
        int gCnt = curr.gCnt;
        int gNextCnt = curr.gNextCnt;
        if(arr[dx][dy] == 'g') gCnt++;
        if(arr[dx][dy] == 't') gNextCnt ++;
        

        //visitied[dx][dy][0] -> gCnt;
        //visitied[dx][dy][1] -> gNectCnt;
        if(visitied[dx][dy][0] < gCnt ) continue;
        if(visitied[dx][dy][0] == gCnt && visitied[dx][dy][1]<= gNextCnt) continue;
        
        visitied[dx][dy][0] = gCnt;
        visitied[dx][dy][1] = gNextCnt;
        queue.add(new Position(dx, dy, gCnt, gNextCnt, 0));
        
      }
    }

    System.out.println(visitied[dest.x][dest.y][0] + " " +visitied[dest.x][dest.y][1] );
  }

  public static boolean inRange(int x, int y){
    return x >= 0 && y >= 0 && x < N && y < M;
  }
}
