package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_B6987_S {
    static int[] case1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int[] case2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
    static int[] win = new int[6];
    static int[] draw = new int[6];
    static int[] lose = new int[6];
    static boolean backtracking;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t = 0; t < 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int reusltWin = 0;
            int resultDraw = 0;
            int resultLose = 0;
            backtracking = false;
            for (int i = 0; i < 6; i++) {
                reusltWin += win[i] = Integer.parseInt(st.nextToken());
                resultDraw += draw[i] = Integer.parseInt(st.nextToken());
                resultLose += lose[i] = Integer.parseInt(st.nextToken());
            }
            if(reusltWin+ resultDraw + resultLose != 30) backtracking = false;
            else run(0);
            
            sb.append((backtracking ? 1 : 0) +" ");
        }
        System.out.println(sb.toString());
    }
    
    static void run(int step) {
        if(backtracking) return ;
        
        if(step == 15) {
            backtracking = true;
            return ;
        }
        
        int team1 = case1[step];
        int team2 = case2[step];
        
        if(win[team1] > 0 && lose [team2] >0) {
            win[team1]--;
            lose[team2]--;
            run(step+1);
            win[team1]++;
            lose[team2]++;
        }
        if(lose[team1] > 0 && win [team2] >0) {
            lose[team1]--;
            win[team2]--;
            run(step+1);
            lose[team1]++;
            win[team2]++;
        }
        if(draw[team1] > 0 && draw[team2] >0) {
            draw[team1]--;
            draw[team2]--;
            run(step+1);
            draw[team1]++;
            draw[team2]++;
        }    
    }
}
