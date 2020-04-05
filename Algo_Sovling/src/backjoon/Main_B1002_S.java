package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B1002_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			bw.write(solve(x1, y1, r1, x2, y2, r2)+"\n");
		}
		br.close();
		bw.close();
	}
	
	public static int solve(int x1, int y1, int r1, int x2, int y2, int r2)
    {
        double r = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));

        // 6번
        if (x1 == x2 && y1 == y2 && r1 == r2)
            return -1;
        // 1번 5번 7번
        else if (r > r1 + r2 || x1 == x2 && y1 == y2 && r1 != r2 ||  r < Math.abs(r1-r2))
            return 0;
        // 2번 4번
        else if (r == r1 + r2 || Math.abs(r1-r2) == r)
            return 1;
        // 3번
        return 2;
    }
}
