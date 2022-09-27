import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

//	Q1406 BOJ
//	index 위치를 설정해두고 그 위치를 찾아가서 추가/삭제를 하게 만들었더니 시간초과가 떴다.
//	그 작업을 없애고 커서를 해당 위치에 미리 존재하도록 구현하게 만드는 것이 ListIterator 사용 (LIKE 스택)
public class Editor_Q1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();

		LinkedList<Character> list = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

//		커서가 인덱스를 찾아서 움직이게 하는게 아니라
//		해당하는 위치에 계속 있으면서 추가/삭제를 할 수 있게 만들자 -> Iterator
		ListIterator<Character> iter = list.listIterator();
		System.out.println(iter.nextIndex());
//		커서 맨 뒤로 이동
		while (iter.hasNext()) {
			iter.next();
		}

		int loop = Integer.parseInt(br.readLine());
		for (int i = 1; i <= loop; i++) {
			String func = br.readLine();
			switch (func) {
			case "L":
				if (iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case "D":
				if (iter.hasNext()) {
					iter.next();
				}
				break;
			case "B":
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			default:
				char plus = func.charAt(2);
				iter.add(plus);
				break;
			}
		}

		for (Character chr : list) {
			bw.write(chr);
		}

		br.close();
		bw.flush();
		bw.close();
	}
}

// 시간초과 코드
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    private StringBuilder line;
//    private int cursor;
//    
//    void L() {
//        if (cursor == 0) {
//            
//        } else {
//            this.cursor--;
//        }
//    }
//    
//    void D() {
//        if (cursor == line.length()) {
//            
//        } else {
//            this.cursor++;
//        }
//    }
//    
//    void B() {
//        if (cursor == 0) {
//            
//        } else {
//            line.deleteCharAt(cursor - 1);
//            L();
//        }
//    }
//    
//    void P(char input) {
//        line.insert(cursor, input);
//        D();
//    }
//    
//    public static void main(String[] args) throws IOException {
//        Main edit = new Main();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        edit.line = new StringBuilder(br.readLine());
//        edit.cursor = edit.line.length();
//        
//        int loop = Integer.parseInt(br.readLine());
//        for (int i = 1; i <= loop; i++) {
//            String func = br.readLine();
//            switch (func) {
//                case "L":
//                    edit.L();
//                    break;
//                case "D":
//                    edit.D();
//                    break;
//                case "B":
//                    edit.B();
//                    break;
//                default:
//                    edit.P(func.charAt(func.length() - 1));
//                    break;
//            }
//        }
//        br.close();
//        
//        bw.append(edit.line);
//        bw.flush();
//        bw.close();
//    }
//}