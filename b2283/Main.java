package b2283;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, max = 0;
    static long arr[] = new long[1_000_002], K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        for(int i = 0 ; i <N ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] ++;
            arr[b]--;
            max = max(max, b);
        }

        for(int i = 1; i <= max; i++){
            arr[i] = arr[i-1] + arr[i];
        }
        

        int start = 0;
        int end = 0;
        long sum = arr[0];
        while(end <= max ){

            if(sum == K) {
                System.out.println(start + " " +(end+1));
                return ;
            }

            if(sum < K) {
                end ++;
                sum += arr[end];
            }else {
                if(end == start){
                    end++;
                    sum += arr[end];
                }else{
                   sum -= arr[start];
                    start ++;
                }
            }
        }
        System.out.println("0 0");

    }
    private static int max(int a, int b){
        return a < b ? b : a;
    }
}
