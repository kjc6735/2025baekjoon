package b14231;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int arr[] = new int[5000];
    static int dp[] = new int[5001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, -1);
        int result = recur(0);
    }

    private static int recur(int curr){
        if(curr > N) return Integer.MIN_VALUE;
        if(curr == N) return 0;
        if(dp[curr] != -1) return dp[curr];

        dp[curr] = max(recur(curr + 1), recur[ curr + arr[]])
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
    
}
