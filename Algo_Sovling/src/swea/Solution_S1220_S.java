package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S1220_S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String _in = "";
		
		for (int t = 1; t <= 10; t++) {
			int size = Integer.parseInt(br.readLine());
			int[][]	_map = new int[size][size];
			
			for (int i = 0; i < size; i++) {
				_in = br.readLine();
				st = new StringTokenizer(_in);
				
				for (int j = 0; j < size; j++) {
					_map[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			// eliminate abandoned magnetic
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(_map[j][i] == 1) break;
					_map[j][i] = 8;
				}
				for (int j = size-1; j >= 0; j--) {
					if(_map[j][i] == 2) break;
					_map[j][i] = 8;
				}
			}
						
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				boolean[] check = new boolean[3];
				for (int j = 0; j < size; j++) {
					if(_map[j][i] == 1 && check[1] == false) check[1] = true;
					if(_map[j][i] == 2 && check[2] == false) {
						check[2] = true;
						while(j < size && _map[j][i] != 1) j++;
						j--;
					}
					if(check[1] && check[2]) {
						cnt++; check[1] = false; check[2] = false;
					}
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}
}
