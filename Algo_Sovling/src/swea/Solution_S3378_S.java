package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution_S3378_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int p = 0, q = 0;
	static int R = 0, C = 0, S = 0;
	static ArrayList<String> baseStyle = null;
	static ArrayList<String> myStyle = null;
	static int[] indentation = null;
	
    public static void main(String[] args) throws IOException {
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int t = 1; t <= T; t++) {
    		st = new StringTokenizer(br.readLine());
    		p = Integer.parseInt(st.nextToken());
    		q = Integer.parseInt(st.nextToken());
    		
    		baseStyle = new ArrayList<>();
    		myStyle = new ArrayList<>();
    		indentation = new int[q];
    		
    		for (int i = 0; i < p; i++) {
				baseStyle.add(br.readLine());
			}
    		for (int i = 0; i < q; i++) {
				myStyle.add(br.readLine());
			}
    		
    		getRCS();
    		
    		bw.write("#"+t+" ");
    		for (int i = 0; i < indentation.length; i++) {
				bw.write(indentation[i]+" ");
			}
    		
    		bw.write("\n");
		}
    	
    	bw.close();
    	br.close();
    }
    
    public static void indentation() {
    	int cntR = 0;
    	int cntC = 0;
    	int cntS = 0;
    	for (int os = 0; os < q ; os++) {
    		
    		int indent = R*cntR + C*cntC + S*cntS;
    		if(indentation[os] == 0 || indentation[os] == indent) {
    			indentation[os] = indent;
    		} else {
    			indentation[os] = -1;
    		}
    		
    		for (int i = 0; i < myStyle.get(os).length(); i++) {
    			char ch = myStyle.get(os).charAt(i);
    			switch(ch) {
				case '(':
					cntR++;
					break;
				case ')':
					cntR--;
					break;
				case '{':
					cntC++;
					break;
				case '}':
					cntC--;
					break;
				case '[':
					cntS++;
					break;
				case ']':
					cntS--;
					break;
				}
			}
    	}
    }
    
    public static void getRCS() {
    	R = 0;
    	C = 0;
    	S = 0;
    	
    	for (int r = 1; r <= 20; r++) {
    		for (int c = 1; c <= 20; c++) {
    			for (int s = 1; s <= 20; s++) {
    				if(innerGetRCS(r, c, s)) {
    					R = r;
    					C = c;
    					S = s;
    					indentation();
    				}
    			}
    		}
		}
    }
    
    public static boolean innerGetRCS(int r, int c, int s) {
    	int cntR = 0;
    	int cntC = 0;
    	int cntS = 0;
    	for (String sentence : baseStyle) {
    		int dotCnt = 0;
    		
    		for (int i = 0; i < sentence.length(); i++) {
				char ch = sentence.charAt(i);
				if(ch=='.') dotCnt++;
				else break;
    		}
    		
    		int indent = r*cntR + c*cntC + s*cntS;
    		if(indent != dotCnt) return false;
//    		System.out.println(String.format("!! R(%d, %d) C(%d, %d) S(%d, %d) Indent::{%d/%d}", r, cntR, c, cntC, s, cntS, indent, dotCnt));
			
    		for (int i = 0; i < sentence.length(); i++) {
				char ch = sentence.charAt(i);
				switch(ch) {
				case '(':
					cntR++;
					break;
				case ')':
					cntR--;
					break;
				case '{':
					cntC++;
					break;
				case '}':
					cntC--;
					break;
				case '[':
					cntS++;
					break;
				case ']':
					cntS--;
					break;
				}
			}
		}
    	
    	return true;
    }
}