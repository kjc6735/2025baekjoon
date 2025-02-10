package b14846;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][][] arr = new int[301][301][11];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        for(int i = 1; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 1; k <= N ; k++){
                int tmp = Integer.parseInt(st.nextToken());
                for(int t = 0 ; t <= 10 ; t++){
                    arr[i][k][t] = arr[i][k-1][t] + arr[i-1][k][t] - arr[i-1][k-1][t];
                }
                arr[i][k][tmp]+=1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int queryCnt = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < queryCnt; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            sb.append(calc(x1,y1,x2,y2)).append("\n");
            
        }

        System.out.println(sb.toString());

    }

    private static int calc(int x1,int y1,int x2,int y2){
        int cnt = 0;
        for(int i = 1; i <11; i++){
            if(arr[x2][y2][i] -arr[x2][y1-1][i] - arr[x1-1][y2][i] + arr[x1-1][y1-1][i] != 0){
                cnt ++;
            }
        }
        return cnt;
    }
    
}
