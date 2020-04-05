package backjoon;
import java.io.IOException;
import java.util.*;

public class Main_J2247_S {
	static class Stu implements Comparable<Stu>{
		int s;
		int e;
		public Stu(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Stu o) {
			return s == o.s ? e-o.e : s - o.s; 
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + e;
			result = prime * result + s;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Stu other = (Stu) obj;
			if (e != other.e)
				return false;
			if (s != other.s)
				return false;
			return true;
		}
	}
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	Stu[] st = null;
    	HashSet<Stu> hs = new HashSet<>();
    	for (int i = 0; i < N; i++) {
    		hs.add(new Stu(sc.nextInt(), sc.nextInt()));
//    		st[i] = new Stu(sc.nextInt(), sc.nextInt());
		}
    	
    	st = hs.toArray(new Stu[hs.size()]);
    	
    	Arrays.sort(st);
    	
    	int start = st[0].s;
    	int end = st[0].e;
    	int maxRange = end-start;
    	int maxGap = 0;
    	for (int i = 1; i < st.length; i++) {
			if(st[i].s <= end) {
				if(st[i].e > end) end = st[i].e;
				int inRange = end-start;
				if(inRange > maxRange) maxRange = inRange;
				
			} else {
				int inGap = st[i].s - end;
				if(maxGap < inGap) maxGap = inGap;
				start = st[i].s;
				end = st[i].e;
			}
		}
    	System.out.println(maxRange+" "+maxGap);
    }
}