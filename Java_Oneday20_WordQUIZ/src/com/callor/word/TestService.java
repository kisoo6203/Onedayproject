package com.callor.word;

import com.callor.word.impl.RpServiceImplV2;
import com.callor.word.service.RpServiceV1;

public class TestService {
	
	public static void main(String[] args) {
		
		RpServiceV1 rp = new RpServiceImplV2();
		
		rp.selectMenu();
//		rp.viewWord();
		
	}

}
