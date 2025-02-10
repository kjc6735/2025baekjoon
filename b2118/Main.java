package b2118;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int arr[] = new int[50_001];
    static HashMap<String,Integer> map = new HashMap<>();
    static int max = 0;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr[1] = Integer.parseInt(br.readLine());
        for(int i = 2; i <= N ; i++){
            arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = 1;
        int front, back ;
        while (start <= end && end <= N) {
            front = arr[end] - arr[start];
            back = arr[N] - front;
            
            if(front < back){
                end ++;
            }else {
                start ++;
            }
            max = max(max, min(front, back));
        }

        System.out.println(max);
    }

    private static int min(int a, int b){
        return a > b ? b : a;
    }

    private static int max(int a, int b){
        return a > b ? a: b;
    }
}
