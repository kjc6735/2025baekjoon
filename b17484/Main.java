package b17484;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int map [][] = new int [8][8];
    static int dp [][][] = new int [8][8][3];
    static {
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++){
                Arrays.fill(dp[i][k], Integer.MAX_VALUE);
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N ; i++){}
      
    }
    
    static int min(int a, int b){
        return a > b ? b : a;
    }

    static int min(int a, int b, int c){
        return min(min(a,b),c);
    }
}
