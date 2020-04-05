package test.line190922;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_Q6 {
	static class Number{
		int size;
		int number;
		public Number(int size, int number) {
			this.size = size;
			this.number = number;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "N [s=" + size + ", num=" + number + "]";
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String align = st.nextToken();
		ArrayList<Number> list = new ArrayList<>();
		int maxSize = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			String number = st.nextToken();
			if(size > maxSize) maxSize = size;
			
			for (int j = 0; j < number.length(); j++) {
				list.add(new Number(size, number.charAt(j)-'0'));
			}
			
		}
		StringBuilder sb = new StringBuilder();
		print(list, maxSize, align, sb);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void printInnerDiffSize(StringBuilder sb, Number info, int i, int maxSize, String align) {
		if(align.equals("TOP")) {
			// 출력 케이스
			if(i < 2*info.size-1) {
				printInner(sb, info, i, 0);
			} else {
				for (int os = 0; os < info.size; os++) {
					sb.append(".");
				}
			}
		} else if(align.equals("MIDDLE")){
			// 출력 케이스
			int sPos = ((2*maxSize-1)-(2*info.size-1))/2;
			if(i >= sPos && i < sPos+2*info.size-1) {
				printInner(sb, info, i, sPos);
			} else {
				for (int os = 0; os < info.size; os++) {
					sb.append(".");
				}
			}
		} else {
			// 출력 케이스
			if(i >= ((2*maxSize-1)-(2*info.size-1))) {
				printInner(sb, info, i, ((2*maxSize-1)-(2*info.size-1)));
			} else {
				for (int os = 0; os < info.size; os++) {
					sb.append(".");
				}
			}
		}
	}
	
	public static void print(ArrayList<Number> list, int maxSize, String align, StringBuilder sb) {
		for (int i = 0; i < (2*maxSize-1); i++) {
			for (int q = 0; q < list.size(); q++) {
				Number info = list.get(q);
				switch(info.number) {
				case 0:
					// align 고려
					if(info.size != maxSize) {
						printInnerDiffSize(sb, info, i, maxSize, align);
					} else {
						printInner(sb, info, i, 0);
					}
					break;
				case 1:
					// align 고려
					if(info.size != maxSize) {
						printInnerDiffSize(sb, info, i, maxSize, align);
					} else {
						printInner(sb, info, i, 0);
					}
					break;
				case 2:
					// align 고려
					if(info.size != maxSize) {
						printInnerDiffSize(sb, info, i, maxSize, align);
					} else {
						printInner(sb, info, i, 0);
					}
					break;
				case 3:
					// align 고려
					if(info.size != maxSize) {
						printInnerDiffSize(sb, info, i, maxSize, align);
					} else {
						printInner(sb, info, i, 0);
					}
					break;
				case 4:
					// align 고려
					if(info.size != maxSize) {
						printInnerDiffSize(sb, info, i, maxSize, align);
					} else {
						printInner(sb, info, i, 0);
					}
					break;
				case 5:
					// align 고려
					if(info.size != maxSize) {
						printInnerDiffSize(sb, info, i, maxSize, align);
					} else {
						printInner(sb, info, i, 0);
					}
					break;
				case 6:
					// align 고려
					if(info.size != maxSize) {
						printInnerDiffSize(sb, info, i, maxSize, align);
					} else {
						printInner(sb, info, i, 0);
					}
					break;
				case 7:
					// align 고려
					if(info.size != maxSize) {
						printInnerDiffSize(sb, info, i, maxSize, align);
					} else {
						printInner(sb, info, i, 0);
					}
					break;
				case 8:
					// align 고려
					if(info.size != maxSize) {
						printInnerDiffSize(sb, info, i, maxSize, align);
					} else {
						printInner(sb, info, i, 0);
					}
					break;
				case 9:
					// align 고려
					if(info.size != maxSize) {
						printInnerDiffSize(sb, info, i, maxSize, align);
					} else {
						printInner(sb, info, i, 0);
					}
					break;
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
	}
	
	public static void printInner(StringBuilder sb, Number info, int i, int base) {
		switch(info.number) {
		case 0:
			if(i == 0+base || i == (2*info.size-2)+base) {
				for (int os = 0; os < info.size; os++) {
					sb.append("#");
				}
			} else {
				sb.append("#");
				for (int os = 0; os < info.size-2; os++) {
					sb.append(".");
				}
				sb.append("#");
			}
			break;
		case 1:
			for (int os = 0; os < info.size-1; os++) {
				sb.append(".");
			}
			sb.append("#");
			break;
		case 2:
			if(i==0+base || i==(2*info.size-1)/2+base || i==(2*info.size-2)+base) {
				for (int os = 0; os < info.size; os++) {
					sb.append("#");
				}
			} else if( i>0+base && i<(2*info.size-1)/2+base ) {
				for (int os = 0; os < info.size-1; os++) {
					sb.append(".");
				}
				sb.append("#");
			} else {
				sb.append("#");
				for (int os = 0; os < info.size-1; os++) {
					sb.append(".");
				}
			}
			break;
		case 3:
			if(i==0+base || i==(2*info.size-1)/2+base || i==(2*info.size-2)+base) {
				for (int os = 0; os < info.size; os++) {
					sb.append("#");
				}
			} else {
				for (int os = 0; os < info.size-1; os++) {
					sb.append(".");
				}
				sb.append("#");
			}
			break;
		case 4:
			if(i==(2*info.size-1)/2+base) {
				for (int os = 0; os < info.size; os++) {
					sb.append("#");
				}
			} else if( i < (2*info.size-1)/2+base){
				sb.append("#");
				for (int os = 0; os < info.size-2; os++) {
					sb.append(".");
				}
				sb.append("#");
			} else {
				for (int os = 0; os < info.size-1; os++) {
					sb.append(".");
				}
				sb.append("#");
			}
			break;
		case 5:
			if(i==0+base || i==(2*info.size-1)/2+base || i==(2*info.size-2)+base) {
				for (int os = 0; os < info.size; os++) {
					sb.append("#");
				}
			} else if( i>0+base && i<(2*info.size-1)/2+base ) {
				sb.append("#");
				for (int os = 0; os < info.size-1; os++) {
					sb.append(".");
				}
			} else {
				for (int os = 0; os < info.size-1; os++) {
					sb.append(".");
				}
				sb.append("#");
			}
			break;
		case 6:
			if(i==(2*info.size-1)/2+base || i==(2*info.size-2)+base) {
				for (int os = 0; os < info.size; os++) {
					sb.append("#");
				}
			} else if(i<(2*info.size-1)/2+base ) {
				sb.append("#");
				for (int os = 0; os < info.size-1; os++) {
					sb.append(".");
				}
			} else {
				sb.append("#");
				for (int os = 0; os < info.size-2; os++) {
					sb.append(".");
				}
				sb.append("#");
			}
			break;
		case 7:
			if(i==0+base) {
				for (int os = 0; os < info.size; os++) {
					sb.append("#");
				}
			} else {
				for (int os = 0; os < info.size-1; os++) {
					sb.append(".");
				}
				sb.append("#");
			}
			break;
		case 8:
			if(i==0+base || i==(2*info.size-1)/2+base || i==(2*info.size-2)+base) {
				for (int os = 0; os < info.size; os++) {
					sb.append("#");
				}
			} else {
				sb.append("#");
				for (int os = 0; os < info.size-2; os++) {
					sb.append(".");
				}
				sb.append("#");
			}
			break;
		case 9:
			if(i==0+base || i==(2*info.size-1)/2+base) {
				for (int os = 0; os < info.size; os++) {
					sb.append("#");
				}
			} else if(i>0+base && i<(2*info.size-1)/2+base){
				sb.append("#");
				for (int os = 0; os < info.size-2; os++) {
					sb.append(".");
				}
				sb.append("#");
			} else {
				for (int os = 0; os < info.size-1; os++) {
					sb.append(".");
				}
				sb.append("#");
			}
			break;
		}
	}
}
