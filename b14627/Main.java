package b14627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S, C, arr[] = new int[1_000_000];
    static int min = Integer.MAX_VALUE, max = 0;
    static long sum = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            max = max(max, arr[i]);
        }
        
        
        int start = 1;
        int end = max;
        int length = 0;
        while (start <= end) {
            int mid = (start + end) /2;
            long tmpCnt = 0;
            for(int i = 0; i < S; i++){
                tmpCnt += (arr[i] / mid);
            }
            if(tmpCnt >= C){
                length = mid;
                start = length + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(sum - ((long)length * (long)C));
    }


    private static int max(int a, int b) {
        return a < b ? b : a;
    }
}
