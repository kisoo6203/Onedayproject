package com.callor.word.service;

import com.callor.word.model.RpVO;

public interface RpServiceV1 {
	
	public void selectMenu();
	public void inputWord();
	public void lordWord();
//	public RpVO getWord();
	public void viewWord();
	public void saveScore(Integer nPoint);

}
