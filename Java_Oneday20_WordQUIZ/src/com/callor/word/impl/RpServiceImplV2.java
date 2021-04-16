package com.callor.word.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import com.callor.word.model.RpVO;

public class RpServiceImplV2 extends RpServiceImplV1 {

	Integer pPoint = 5;

	@Override
	public void saveScore(Integer nPoint) {
		String fileName = null;
		while (true) {
			System.out.println("저장할 파일 이름을 입력하세요");
			System.out.print("입력>> ");
			fileName = scan.nextLine();
			if (fileName.equals("")) {
				System.out.println("파일 이름은 꼭 입력해주세요");
				continue;
			}
			break;
		}
		String strFileName = "src/com/callor/word/" + fileName + ".txt";

		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(strFileName);
			printWriter = new PrintWriter(fileWriter);

			printWriter.print(pPoint);

			printWriter.flush();
			printWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void loadScore() {

		String fileName = null;

		while (true) {
			System.out.println("불러올 파일 이름을 입력하세요");
			System.out.print("입력>> ");
			fileName = scan.nextLine();
			if (fileName.equals("")) {
				System.out.println("불러올 파일 이름을 입력해주세요");
				continue;
			}
			break;
		}
		String strFileName = "src/com/callor/word/" + fileName + ".txt";

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(strFileName);
			buffer = new BufferedReader(fileReader);

			String read = buffer.readLine();
			Integer nPoint = Integer.valueOf(read);
			pPoint = nPoint;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override    
	public void viewWord() {                                   // 문제 생성 구간
		Random rnd = new Random();
		pPoint = 5;
		while (true) {
			nPoint = 3;
			RpVO vo = this.getWord();
			String strEng = vo.getEng();
			String[] strWords = strEng.split("");
			if (pPoint <= 0) {
				System.out.println("남은 포인트가 없습니다.."); // 건너뛰기로 포인트가
				System.out.println("-".repeat(30));				// 0이 되었을때 발생하는구간
				return;
			}
			for (int i = 0; i < 100; i++) {
				int index1 = rnd.nextInt(strWords.length);
				int index2 = rnd.nextInt(strWords.length);

				String temp;
				temp = strWords[index1];
				strWords[index1] = strWords[index2];
				strWords[index2] = temp;

			}
                                                               // 게임진행구간
			Integer num = 5;
			boolean flag = true;
			while (true) {

				System.out.println("-".repeat(50));
				System.out.println(vo.toString()); // (뜻, 영단어) 보여주기
				System.out.println("다음 배열을 보고 영단어를 완성하세요");
				System.out.printf(" (남은기회 : %d회) (남은포인트 : %d점 \n", nPoint, pPoint);
				System.out.println("(다음문제로 넘어가시려면 : 건너뛰기)");
				System.out.println(Arrays.toString(strWords));
				System.out.println("@@ 메뉴로 돌아가시려면 MENU를 입력해주세요 @@");
				System.out.println("=".repeat(50));
				System.out.print("입력>> ");
				String inputWords = scan.nextLine();
				if (inputWords.equals("MENU")) {
					return;
				}
				if (inputWords.equals("건너뛰기")) {
//					System.out.println("다음 문제를 공개합니다");
//					System.out.println("-".repeat(50));
					pPoint--;  // 시작하자마자 건너뛰면 점수가 -n포인트인데 게임종료가 안된다..?-수정완료
					break;
				}
				if (inputWords.equalsIgnoreCase(vo.getEng())) {
					System.out.println("정답입니다");
					pPoint += num;
					System.out.printf("현재 포인트 : %d\n", pPoint);
					break;
				} else if (nPoint > 1 && pPoint >= 3) {
					System.out.println("오답입니다");
					--nPoint;
					pPoint -= 3;
					System.out.printf("현재남은 기회 : %d\n", nPoint);
					System.out.printf("현재 포인트 : %d\n", pPoint);
					// this.testWord();
					System.out.println("\t\t- 힌트 -");
					System.out.println("영단어의 뜻 >> " + vo.getKor());
					continue;
				} else {
					System.out.println("남은 기회 또는 포인트가 남아 있지 않습니다");
					System.out.println("the end...");
					System.out.println("-".repeat(30));
					flag = false;
					break;

				}

			}
			if (flag == false) {
				return;

			}

		}
	}

}
