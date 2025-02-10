package b1059;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.IntToDoubleFunction;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[] arr= new int[L];
        int maxValue = 0;
        for(int i = 0; i < L ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
            maxValue = maxValue < arr[i] ? arr[i] : maxValue;
        }
        int N = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        if(set.contains(N)){
            System.out.println( 0);
            return ;
        }
        int min = 0;
        int max = 0;
        for(int i = 0; i < L ; i++){
            if(arr[i] > N){
                max = arr[i];
                break;
            }
        }

        for(int i = L-1 ;  i >= 0; i--){
            if(arr[i] < N){
                min = arr[i];
                break;
            }
        }
        min +=1;
        max -= 1;
       
        int result = 0;
        
        // min < N 구간 더하기
        result += (N-min) * (max - N + 1);
        // N ~ max;
        result += (max - N);

        System.out.println(result);




    }
}
