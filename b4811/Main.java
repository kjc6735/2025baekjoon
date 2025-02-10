package b4811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long arr[] = new long[31];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr[1] = 1;
        for(int i = 2; i <= 30; i++){
            arr[i] = arr[i-1] +(i-1)+ 1;
        }
        
        int n = 0;
        while (
            (n = Integer.parseInt(br.readLine())  )  != 0
        ) {
            System.out.println(arr[n]);
        }
    }    
}
