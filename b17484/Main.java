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

        for(int i = 0; i < N; i++){
            st = new StringTokenizer( br.readLine());
            for(int k = 1; k <= M; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int k = 1; k <= M; k++){
            for(int j = 0; j < 3; j++){ // 좌 아 우
                dp[0][k][j] = map[0][k];
            }
        }
        

        for(int i = 1; i <= N; i++){
            for(int k = 1; k <= M; k++){
                for(int j = 0; j < 3; j++){ // 오는 방향 선택 0 == 좌 / 1 == 상 // 2 == 우
                  
                    for(int d = 0; d< 2; d ++){ // 해당 방향이 아닌 곳엣 ㅓ온 걸 골라야함 // 그럼 현재 내가 0에서 온 것을 새려고 하면 0이 아닌 나머지에서 가져와야함 그럼 총 for 이 1개 더 필여ㅛ
                        for(int c = 0 ;c <  2; c ++){
                            
                        }
                        
                    }
                    
                    dp[i][k][j] += map[i][k];
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 1 ; i <= M; i++){
            result = min(dp[N][i][0],dp[N][i][1], dp[N][i][2]);
        }
        System.out.println(result);
    }
    
    static int min(int a, int b){
        return a > b ? b : a;
    }

    static int min(int a, int b, int c){
        return min(min(a,b),c);
    }
}
