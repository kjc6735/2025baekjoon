package b2167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][] = new int[305][305];
    static int sum[][] = new int[305][305];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // input
        for(int i = 1; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 1; k <= M ; k++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][k] = tmp;
            }
        }

        //sum
        for(int i = 1; i <=N; i++) sum[i][1] = sum[i-1][1] + arr[i][1];
        for(int i = 1; i <=M; i++) sum[1][i] = sum[1][i-1] + arr[1][i];

        for(int i = 1; i <= N ; i++){
            for(int k = 1; k <= M ; k++){
                sum[i][k] = arr[i][k] + sum [i-1][k] + sum[i][k - 1] - sum[i-1][k-1];
            }
        }
    
        StringBuilder sb = new StringBuilder();

        // query cnt
        int queryCnt = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < queryCnt; t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int result = sum[x][y] + sum[i-1][k-1] - sum[i-1][y]- sum[x][k-1];
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
