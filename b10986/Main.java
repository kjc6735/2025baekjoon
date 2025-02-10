package b10986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long sum[] = new long[1_000_000];
    static int MOD[] =new  int[1_000_000];
    static long C[] = new long[1_000_000];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            long tmp = Long.parseLong(st.nextToken());
            if(i == 0){
                sum[i] = tmp;
            }else {
                sum[i] = sum[i-1] + tmp;
            }
            MOD[i] = (int)(sum[i] % M);
            C[MOD[i]]++;
        }

        long S = C[0];
        for(int i = 0;  i < M; i++) S += Comb(C[i]);
        System.out.println(S);
    }

    static long Comb(long n){
        if (n < 2)
            return 0;
        else
            return n * (n - 1) / 2;
    }
}
