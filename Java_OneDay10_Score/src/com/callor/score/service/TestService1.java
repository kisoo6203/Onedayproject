package com.callor.score.service;

import java.util.List;
import java.util.Scanner;

import com.callor.score.TestVO;

public class TestService1 {
	Scanner scan;
	List<TestVO> scoreList;
	
	public TestService1() {
			
		int intnums;
		
		
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
			String strMenu = scan.nextLine();
			if(strMenu.equals("QUIT")) {
				break;
			}
		}
		System.out.println("업무가 종료되었습니다");	
		
	}
	public void makescore() {
		
	}

}
