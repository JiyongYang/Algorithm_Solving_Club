package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Item{
	int x;
	int y;
	int dist;
	Item(int y, int x){
		this.x = x;
		this.y = y;
	}
	Item(int y, int x, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	public int getDist() {
		return dist;
	}
	public void setDist(int dist) {
		this.dist = dist;
	}
	
}

public class Main_B16236_S_R {
	static int sy = 0, sx = 0;
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[j][i] = Integer.parseInt(st.nextToken());
				int val = map[j][i];
				if(val == 9) {
					sy = j;
					sx = i;
				}
			}
		}
			
		System.out.println(run(map, 2, 0, 0));
	
		
	}

	private static int run(int[][] map, int size, int eat, int time) {
		boolean[][] visited = new boolean[map.length][map.length];
		
		while(true) {
			Queue<Item> q = new LinkedList<>();
			visited = new boolean[map.length][map.length];
			ArrayList<Item> fishes = new ArrayList<>();
			q.add(new Item(sy, sx, 0));
			visited[sy][sx] = true;
			
			int found = -1;
			while(!q.isEmpty()) {
				Item p = q.poll();
				int y = p.y;
				int x = p.x;
				int move = p.dist;
				
				if(found == move) break;
				
				for (int k = 0; k < 4; k++) {
					int ny = y + dy[k];
					int nx = x + dx[k];
					
					if(ny >= 0 && ny < map.length && nx >= 0 && nx < map.length) {
						if(visited[ny][nx]) continue;
						
						visited[ny][nx] = true;
						
						// movable
						if(size >= map[ny][nx]) {
							// can eat
							if(map[ny][nx] > 0 && size > map[ny][nx]) {
								found = move + 1;
								fishes.add(new Item(ny, nx, move + 1));
							}
							q.add(new Item(ny, nx, move + 1));
						}
					}
				}
			}
			
			if(found == -1) break;
			else {
				if(fishes.size() > 1) Collections.sort(fishes, new Comparator<Item>() {
					@Override
					public int compare(Item p1, Item p2) {
						if(p1.y < p2.y) return -1;
						else if(p1.y == p2.y) {
							if(p1.x < p2.x) return -1;
							else if(p1.x == p2.x) return 0;
							else return 1;
						}
						else return 1;
					}
				});
			}
			
			Item p = fishes.get(0);
			if(found != -1) {
				time += found;
				map[sy][sx] = 0;
				sy = p.y;
				sx = p.x;
				map[sy][sx] = 9;
				if(size == ++eat) {
					size++;
					eat = 0;
				}
			}
			
		}
		
		
		return time;
	}
}

