package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B2447_NS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] p = new int[N][N];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				p[i][j] = 1;
			}
		}
		
		eraser(N, 0, 0, p);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p.length; j++) {
				if(p[i][j] == 1) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		
		bw.close();
	}
	
	public static void eraser(int n, int sy, int sx, int[][] p) {
		for (int i = 0; i < n/3; i++) {
			for (int j = 0; j < n/3; j++) {
				p[n/3+i+sy][n/3+j+sx] = 0;
				if(sy+n/3*i > p.length-n/3 || sx+n/3*j > p.length-n/3) continue;
				
				if(n/3==1) return;
				eraser(n/3, sy+n/3*i, sx+n/3*j, p);
			}
		}
	}
}

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        process(Integer.parseInt(br.readLine()));
    }

    private static void process(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int x = i, y = j;
                while(x > 0) {
                    if(x % 3 == 1 && y % 3 == 1) {
                        break;
                    }

                    x /= 3;
                    y /= 3;
                }
                sb.append(x == 0 ? '*' : ' ');
//                1,4,7 즉 나머지가 1인 것들만 자기숫자가 나오고 아닌 것들은 0이 된다.
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
*/