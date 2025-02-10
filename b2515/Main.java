package b2515;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long result[] = new long[20_000_001];
    static int N;
    static int S;
    static int maxH = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            result[h] = max(result[h], c);
            maxH = max(maxH, h);
        }

        for(int i = 0; i <= maxH; i++){
            if(i < S) continue;
            result[i] = max(result[i - S]+ result[i], result[i - 1]);
        }
        System.out.println(result[maxH]);
    }
    
    static long max(long a, long b){
        return a < b ? b : a;
    }
    static int max(int a, int b){
        return a < b ? b : a;
    }
}
