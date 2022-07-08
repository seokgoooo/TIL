import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		절대경로
		File trueFile = new File("d:\\SG\\JAVA\\Lotto.java");
		System.out.println(trueFile.getName());
		System.out.println(trueFile.getPath());
		System.out.println(trueFile.exists());

		File falseFile = new File("d:\\SG\\JAVA\\TEST.txt");
		System.out.println(falseFile.getName());
		System.out.println(falseFile.getPath());
		System.out.println(falseFile.exists());

		File dirFile = new File("d:\\SG\\JAVA");
		System.out.println(dirFile.getName());
		System.out.println(dirFile.getPath());
		System.out.println(dirFile.exists());

		System.out.println("파일인가요? " + dirFile.isFile());
		System.out.println("디렉토리인가요? " + dirFile.isDirectory());

		System.out.println("--상대경로와 절대경로-----------Test 2-----------------------");

//		상대경로			(.\\) 현재경로 (현재 프로젝트 경로) 를 의미한다
		File pathFile = new File(".\\");
		System.out.println(pathFile.getName());
		System.out.println(pathFile.getPath());
		System.out.println(pathFile.exists());

//		AbsolutePath 는 경로의 .을 그대로 나타낸다
		System.out.println(pathFile.getAbsolutePath());
		try {

//			CanonicalPath 는 경로의 .을 해석해서 나타내준다
//			Checked Exception - 무조건 처리해줘야 하는 예외 (컴파일시 발생)
			System.out.println(pathFile.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		File pathFileParent = new File("..\\");
		System.out.println(pathFileParent.getAbsolutePath());
		try {
			System.out.println(pathFileParent.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File pathGetFile = pathFile.getCanonicalFile().getParentFile();
			System.out.println(pathGetFile.getAbsolutePath());
			System.out.println(pathGetFile.getCanonicalPath());

//			표현방식이 달라서 다르다고 나온다		같게 만들고 싶다면 표현방식을 같게 만들어주자
			System.out.println(pathFileParent.equals(pathGetFile));

			System.out.println(pathFileParent.compareTo(pathGetFile));
			System.out.println(pathFileParent.getCanonicalFile().equals(pathGetFile));
			System.out.println(pathFileParent.getCanonicalFile().compareTo(pathGetFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("--Path와 File의 차이------Test 3-----------------------");

//		Path 는 경로를 반환, File 은 File 을 반환
		File makeDir = new File("d:\\filetest");
		System.out.println("있나? " + makeDir.exists());
		System.out.println("폴더임? " + makeDir.isDirectory());
		System.out.println("파일명? " + makeDir.isFile());

		boolean resultDir = makeDir.mkdir();
		System.out.println("디렉토리 생성여부? " + resultDir);

		File makeDirABC = new File("d:\\filetest\\abc");
		boolean resultDirABC = makeDirABC.mkdir();
		System.out.println(resultDirABC);

		try {
			File makeDirABCParent = new File("d:\\filetest\\abc\\..\\def");
			makeDirABCParent.mkdir();

			// 위의 경로를 Canonical 로 똑같이 쓸 수 있다.
			File makeDirABCtest = makeDirABCParent.getCanonicalFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File makeTextFile = new File("d:\\filetest\\mytext.txt");
		try {
			System.out.println("생성됨? " + makeTextFile.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("--파일 이름을 바꾸고 삭제--------Test 4-----------------------");

		File makeNewTextFile = new File("d:\\filetest\\한글이름.txt");
		try {
			System.out.println("생성됨 ? " + makeNewTextFile.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}

		makeNewTextFile.renameTo(new File("d:\\filetest\\rename.txt"));

		File makeDelTextFile = new File("d:\\filetest\\mytext.txt");
		makeDelTextFile.delete();

		System.out.println("--파일을 읽어보자------------Test 5-----------------------");

		File readTextFile = new File("d:\\filetest\\text.txt");
		Scanner scan = null;

		try {
			scan = new Scanner(readTextFile);

//			처음부터 끝까지 읽어주기 위해 while문 사용
			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
		} finally {
			if (scan != null) {
				scan.close();
			}
		}

		System.out.println("--파일 쓰기 연습--------Test 6-----------------------");
		FileOutputStream fos = null;
		String line = "Hello";
		File practice = new File("d:\\filetest\\practice.txt");

		try {
			fos = new FileOutputStream(practice);
			fos.write(line.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("--파일 읽기 연습--------Test 7-----------------------");
		FileInputStream fls = null;
		try {
			int length = (int) practice.length();
			byte[] buf = new byte[length];

			fls = new FileInputStream(practice);
			fls.read(buf);

			String result = new String(buf);
			System.out.println(result);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fls != null) {
				try {
					fls.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("--파일 문장 단위 쓰기 연습--------Test 8-----------------------");
		File lineFile = new File("d:\\filetest\\lineio.txt");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(lineFile));

			pw.println("문자열 한줄을 출력합니다.");
			pw.println(10);
			pw.println(15.15);
			pw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

		System.out.println("--파일 버퍼 사용 읽기 연습--------Test 8-----------------------");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(lineFile));

			String lineBf;
			while ((lineBf = br.readLine()) != null) {
				System.out.println(lineBf);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}