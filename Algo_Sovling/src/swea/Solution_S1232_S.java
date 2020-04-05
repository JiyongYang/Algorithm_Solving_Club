package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution_S1232_S {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        for (int t = 1; t <= 10; t++) {
            LinkedList<Integer> numList = new LinkedList<>();
            int sizeOfCode = Integer.parseInt(br.readLine());
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < sizeOfCode; i++) {
                numList.add(Integer.parseInt(st.nextToken()));
            }
             
            int numOfCommand = Integer.parseInt(br.readLine());
            String in = br.readLine();
            String[] coms = in.split(" ");
            int cnt = 0;
            for (int i = 0; i < numOfCommand; i++) {
                String cmd = coms[cnt++];
                switch(cmd) {
                case "I":
                    int x = Integer.parseInt(coms[cnt++]);
                    int y = Integer.parseInt(coms[cnt++]);
                    ArrayList<Integer> nums = new ArrayList<>();
                    for (int j = 0; j < y; j++) {
                        nums.add(Integer.parseInt(coms[cnt++]));
                    }
                    numList.addAll(x, nums);
                    break;
                case "D":
                    int x1 = Integer.parseInt(coms[cnt++]);
                    int y1 = Integer.parseInt(coms[cnt++]);
                    for (int j = 0; j < y1; j++) {
                        numList.remove(x1+1);
                    }
                    break;
                case "A":
                    int y2 = Integer.parseInt(coms[cnt++]);
                    ArrayList<Integer> nums2 = new ArrayList<>();
                    for (int j = 0; j < y2; j++) {
                        nums2.add(Integer.parseInt(coms[cnt++]));
                    }
                    numList.addAll(nums2);
                    break;
                }
                 
            }
             
            System.out.print("#"+t+" ");
            for (int i = 0; i < 10; i++) {
                System.out.print(numList.get(i)+" ");
            }
            System.out.println();
        }
    }
}