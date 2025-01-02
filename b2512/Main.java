package b2512;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int[10_000];
    static int N;
    static int target = 0;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2512/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]) max = arr[i];
        }
        target = Integer.parseInt(br.readLine());
        int bottom = 0;
        int top = max;
        int sum = 0;
        int mid = 0;
        while (bottom <= top) {
             mid = (bottom + top) / 2;
            int[] result = culc(mid);
            sum = result[1];
            int cnt = result[0];

            if(target - sum >= 0 && cnt > target - sum){

                break;
            }

            if(sum < target) {
                bottom = mid + 1;
            }else if(sum > target){
                top = mid - 1;
            }else {
                break;
            }
        }
    
        System.out.println(mid);

    }

    private static int[] culc(int target){
        int sum = 0;
        int cnt = 0;
        for(int i =0; i < N; i++){
            if(target >= arr[i]) sum += arr[i];
            else {
                sum += target; 
                cnt ++;
            }
        }

        return new int[]{cnt, sum};
    }
}
