package test.nhn_190929;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_Q2 {
	static class Item implements Comparable<Item>{
		int idx;
		int data;
		int frequency;
		public Item(int idx, int data, int frequency) {
			super();
			this.idx = idx;
			this.data = data;
			this.frequency = frequency;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Item [idx=" + idx + ", data=" + data + ", frequency=" + frequency + "]";
		}
		@Override
		public int compareTo(Item o) {
			if(frequency == o.frequency)
				return idx - o.idx;
			else
				return o.frequency - frequency;
		}
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[101];
		int gIdx = 0;
		ArrayList<Item> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equalsIgnoreCase("enqueue")) {
				int data = Integer.parseInt(st.nextToken());
				cnt[data]++;
				list.add(new Item(gIdx++, data, 1));
			} else {
				if(list.size()==0) {
					bw.write("-1 ");
				} else {
					// freqeuncy update;
					for (Item item : list) {
						item.frequency = cnt[item.data];
					}
					// dequeue
					Collections.sort(list);
					Item item = list.remove(0);
					cnt[item.data]--;
					bw.write(item.data+" ");
				}
			}
		}
		
		bw.close();
		br.close();
	}
}
