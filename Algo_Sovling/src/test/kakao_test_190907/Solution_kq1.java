package test.kakao_test_190907;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_kq1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		s = s.substring(1, s.length()-1);
		
		int len = s.length();
		int minlen = len;
		
		for (int exSize = 1; exSize < len; exSize++) {
			StringBuilder sb = new StringBuilder();
			int offset = 0;
			while(true) {
				if(offset+exSize > len) {
					sb.append(s.subSequence(offset, len));
					break;
				}
				String base = s.substring(offset, offset+exSize);
//				System.out.println("B: "+base);
				int innerOffset = offset+exSize;
				
				if(innerOffset >= len) {
					sb.append(s.subSequence(offset, len));
					break;
				}
				int cnt = 1;
				boolean flg = true;
				while(true) {
					if(innerOffset+exSize > len) {
						if(cnt > 1) sb.append(cnt+""+base);
						else {
							sb.append(base);
						}
						flg = false;
						break;
					}
					String innerS = s.substring(innerOffset, innerOffset+exSize);
//					System.out.println("I:"+innerS);
//					System.in.read();
//					System.in.read();
					if(base.equals(innerS)) {
						cnt++;
						innerOffset+=exSize;
						continue;
					} else {
						if(cnt!=1) sb.append(cnt+""+base);
						break;
					}
				}
//				System.out.println("tsb: "+sb.toString());
				if(cnt==1 && flg) {
					sb.append(base);
				}
				offset += cnt*exSize;
//				System.out.println("tsb: "+sb.toString());
			}
//			System.out.println("SB:"+ sb.toString());
			
			if(minlen > sb.length()) minlen = sb.length();
		}
		bw.write(minlen+"");
		
		
		br.close();
		bw.close();
	}
}
