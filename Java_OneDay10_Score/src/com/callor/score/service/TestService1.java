package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.callor.score.TestVO;

public class TestService1 {
	protected Scanner scan;
	protected List<TestVO> scoreList;
	String strStu;
	String strMenu;
	String strKors;
	String strEngs;
	String strMaths;
	String strScis;
	String strHiss;
	public TestService1() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<TestVO>();
		
	}
	public void makemenu() {
	
		while(true) {
			System.out.println("=".repeat(60));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(60));
			System.out.println("1. 학생별 성적 입력 ");
			System.out.println("2. 학생 성적 리스트 출력 ");
			System.out.println("업무종료. (QUIT 입력)");
			System.out.println("=".repeat(60));
			System.out.print("업무선택 >> ");
			strMenu = scan.nextLine();
			if(strMenu.equals("QUIT")) {
				break;
			}
			Integer intMenu = null;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				System.out.println("메뉴선택 오류!!");
				System.out.println("메뉴는 1 or 2, QUIT만 입력가능");
				continue;
			}
			if(intMenu == 1) {
				this.makescore();
			} else if(intMenu == 2) {
				this.printTestVO();
			}
		}
		System.out.println("- 업무가 종료되었습니다 -");	

	}
	public void makescore() {
		while(true) {
			System.out.println("-".repeat(60));
			System.out.println("학생번호를 입력하세요(입력중단은 QUIT)");
			System.out.println("=".repeat(60));
			System.out.print("번호 >> ");
			strStu = scan.nextLine();
			if(strStu.equals("QUIT")) {
				System.out.println("- 업무가 종료되었습니다 -");
				return;
			}
			Integer intstu = null;
			try {
				intstu = Integer.valueOf(strStu);
			} catch (Exception e) {
				System.out.println("번호입력 오류!!");
				System.out.println("번호는 학생번호, QUIT만 입력가능");
				continue;
			}
			if(intstu == 1) {
				this.inputScore();
			} else if(intstu == 2) {
				this.inputScore();
			} else if(intstu == 3) {
				this.inputScore();
			} else if(intstu == 4) {
				this.inputScore();
			} else if(intstu == 5) {
				this.inputScore();
			} else if(intstu == 6) {
				this.inputScore();
			} else if(intstu == 7) {
				this.inputScore();
			} else if(intstu == 8) {
				this.inputScore();
			} else if(intstu == 9) {
				this.inputScore();
			} else if(intstu == 10) {
				this.inputScore();
			}
			
		}
		
	}
	public void inputScore() {
		Integer intKors = 0;
		Integer intEngs = 0;
		Integer intMaths = 0;
		Integer intScis = 0;
		Integer intHiss = 0;
		
		int intSum = 0;
		float floatAvg = 0.0f;
			
		while(true) {
			System.out.println("-".repeat(60));
			System.out.print(strStu + "번 학생의 성적을 입력하세요");			
			System.out.println("(성적범위 : 0 ~ 100, 입력을중단하려면 QUIT)");
			System.out.println("=".repeat(60));
			System.out.print("국어 >> ");
			strKors = scan.nextLine();
			System.out.print("영어 >> ");
			strEngs = scan.nextLine();
			System.out.print("수학 >> ");
			strMaths = scan.nextLine();
			System.out.print("과학 >> ");
			strScis = scan.nextLine();
			System.out.print("국사 >> ");
			strHiss = scan.nextLine();
			if(strKors.equals("QUIT")) {
				System.out.println("- 입력을 중단하고 메인메뉴로 돌아갑니다 -");
				return;
				
			}
			//Integer intkors = null;
			try {
				intKors = Integer.valueOf(strKors);
				intEngs = Integer.valueOf(strEngs);
				intMaths = Integer.valueOf(strMaths);
				intScis = Integer.valueOf(strScis);
				intHiss = Integer.valueOf(strHiss);
			} catch (Exception e) {
				System.out.println("점수입력 오류 !!");
				System.out.println("점수는 0 ~ 100 까지만 입력하세요. "
						+ "(입력중단은 QUIT)");
						continue;
			}
			if(intKors < 0 || intKors > 100) {
				this.inputScore();
			} else if(intEngs < 0 || intEngs > 100){
				this.inputScore();
			} else if(intMaths < 0 || intMaths > 100){
				this.inputScore();
			} else if(intScis < 0 || intScis > 100){
				this.inputScore();
			} else if(intHiss < 0 || intHiss > 100){
				this.inputScore();
			} else {
				
			}
			
			TestVO testVO = new TestVO();
			
			testVO.setKors(strKors);
			testVO.setEngs(strEngs);
			testVO.setMaths(strMaths);
			testVO.setScis(strScis);
			testVO.setHiss(strHiss);
			scoreList.add(testVO);
			
			
			
			//scoreList.add(vo);
			System.out.println("=".repeat(60));
			System.out.println(strStu +"번 학생의 성적이 추가 되었습니다");
			System.out.println("=".repeat(60));
			System.out.println("국어 : "+testVO.getKors());
			System.out.println("영어 : "+testVO.getEngs());
			System.out.println("수학 : "+testVO.getMaths());
			System.out.println("과학 : "+testVO.getScis());
			System.out.println("국사 : "+testVO.getHiss());
			System.out.println();
			
			System.out.println("계속 입력 하시겠습니까?(Yes:1, No:0)");
			System.out.print("1 or 0 >> ");
			int yesNo = scan.nextInt();
						
			if(yesNo == 1){
				continue;
				//this.inputScore();
			} else {
				this.makemenu();
			}
			
			
		}
			
	}
	public void printTestVO() {
		System.out.println("=".repeat(60));
		System.out.println("순번\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		
	}
	public void printScoreList() {
				
	}
}
