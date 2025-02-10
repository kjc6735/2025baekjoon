package b19947;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int arr[] = new int[11];
        arr[0]= H;
        for(int y = 1; y <= Y; y++){
            arr[y] =(int)(arr[y-1] * 1.05);
            if(y >= 3) {
                arr[y] = Math.max(arr[y],  (int)(arr[y-3] * 1.2));
            }
            if(y >= 5) {
                arr[y] = Math.max(arr[y], (int)(arr[y-5] * 1.35));
            }
        }

        System.out.println(arr[Y]);
    }
}