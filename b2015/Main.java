package b2015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int[200_001], N, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i ++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        Map<Integer,Integer> map = new HashMap<>();
        long cnt = 0;
        map.put(0,1);
        for(int i = 1; i <= N; i++){
            cnt += map.getOrDefault(arr[i] - K,0 );
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(cnt);
    }
    
}
