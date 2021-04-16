package com.callor.word.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.RpVO;
import com.callor.word.service.RpServiceV1;

public class RpServiceImplV1 implements RpServiceV1 {

	List<RpVO> rpList;
	Scanner scan;
	int nPoint;
	public RpServiceImplV1() {
		rpList = new ArrayList<RpVO>();
		scan = new Scanner(System.in);
		
		this.inputWord();
	}
	
	@Override
	public void selectMenu() {
		while(true) {
			System.out.println(" 단어맞추기 게임 ");
			System.out.println("1. 시작하기");
			System.out.println("2. 저장하기");
			System.out.println("3. 불러오기");
			System.out.println("4. 종료");
			System.out.print("입력>> ");
			String strNum = scan.nextLine();
			if(strNum.trim().equals("4")) {
				System.out.println(" - 게임을 종료합니다 - ");
				return;
			}
			Integer intNum = null;
			
			try {
				intNum = Integer.valueOf(strNum);
			} catch (NumberFormatException e) {
				System.out.println("-".repeat(30));
				System.out.println(" - 1 ~ 4 까지만 입력해주세요 -");
				System.out.println("-".repeat(30));
				continue;
			}
			if(intNum == 1) {
				this.viewWord();
			} else if(intNum ==2) {
				this.saveScore(nPoint);
			} else if(intNum == 3) {
				this.loadScore();
			}
		}
		
		
		
	}

	@Override
	public void inputWord() {
		
		String fileName = "src/com/callor/word/impl/word.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);
			
			while(true) {
				String reader = buffer.readLine();
				if(reader == null) {
					break;
				}
				
				String[] str = reader.split(":");
				
				RpVO vo = new RpVO();
				vo.setEng(str[0]);
				vo.setKor(str[1]);
				rpList.add(vo);
			}
			buffer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void lordWord() {
		
		while(true) {
			RpVO vo = this.getWord();
			System.out.println("다음 뜻을 보고 영단어를 완성하세요(중지 : QUIT)");
			System.out.println(vo.getKor());
			System.out.println("-".repeat(50));
			System.out.println("입력>> ");
			String strKor = scan.nextLine();
			
			if(strKor.equals("QUIT")) {
				break;
			}
			if(strKor.equalsIgnoreCase(vo.getEng())) {
				System.out.println("정답입니다");

			} else {
				System.out.println("다시 한번 생각해보세요");

			}
						
		}
		
		
	}

	
	protected RpVO getWord() {
		
		Random rnd = new Random();
//		rnd.nextInt(100);
		
		int nSize = rpList.size();
		int num = rnd.nextInt(nSize);
		
		RpVO vo = rpList.get(num);
		return vo;
	}

	@Override
	public void viewWord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveScore(Integer nPoint) {
		
	}
	protected void loadScore() {

	
	}
}
