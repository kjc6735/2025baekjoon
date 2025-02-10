package b14222;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int[100];
    static int used[] = new int[100];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer( br.readLine());
        
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 0,N);
        for(int i = 0; i < N ; i++){
            if(used[arr[i]] == 0){
                used[arr[i]] = 1;
                continue;
            }
            
            for(int mul = 1; mul * K + arr[i] <= N; mul ++){
                if(used[mul * K + arr[i]] == 1) continue;
                used[mul * K + arr[i]] = 1;
                break;
            }
        }

        for(int i = 1; i <= N; i++){
            if(used[i] == 0){
                System.out.println(0);
                return ;
            }
        }
        System.out.println(1);

    }
    
}
