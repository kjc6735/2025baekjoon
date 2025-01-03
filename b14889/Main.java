package b14889;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    static int[][] map = new int[20][20];
    static int MIN = Integer.MAX_VALUE;
    static int N;
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b14889/input.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N ; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        fn(0, new boolean[20]);
        System.out.println(MIN);
    }

    private static void fn(int index,boolean visited[]){
        if(index == 20){
            ArrayList<Integer> aTeam = new ArrayList<>();
            ArrayList<Integer> bTeam = new ArrayList<>();
            for(int i = 0; i < N ; i++){
                if(visited[i]) aTeam.add(i);
                else bTeam.add(i);
            }
            if(aTeam.size() != (N/2)) return ;
            int aTeamScore = calc(aTeam, 0);
            int bTeamScore = calc(bTeam, 0);
            int result =  Math.abs(aTeamScore - bTeamScore);
            MIN = result < MIN ? result : MIN;
            return ;
        }

        visited[index] = true;
        fn(index + 1,visited);
        visited[index] = false;
        fn(index + 1, visited);
    }

    private static int calc(List<Integer> arr, int index){
        if(index == arr.size()) return 0;
        int sum = 0;
        for(int i = index; i < arr.size(); i++){
            sum += map[arr.get(i)][arr.get(index)];
            sum += map[arr.get(index)][arr.get(i)];
        }
        return sum + calc(arr, index + 1);
    }
}