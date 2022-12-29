 package com.smhrd.model;

public class VO {
	//15. 만든후 우클릭 Source using fields 생성
	private String id;
	private String pw;
	private String name;
	
	//16. 생성자 메소드
	public VO(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	//44.메소드 만든거 -> DAO
	public VO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	//17.->JoinCon 이동
	// getter 메소드
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}
	
	
	
	
	
	
	
	
}
