package com.callor.word.model;

public class RpVO {
	
	String kor;
	String eng;
	Integer count;

	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RpVO [뜻 = " + kor + " , 영단어 = " + eng + "]";
	}
	
	

}
