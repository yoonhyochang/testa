package com.smhrd.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//필요한 파라미터만 받는 생성자 (해당 파라미터는 final 혹은 @NonNull 이여야함)
@RequiredArgsConstructor
//모든 파라미터 받는 생성자
@AllArgsConstructor
//기본 생성자
@NoArgsConstructor  
//getter
@Getter
//setter @Setter
//@Data : 한꺼번에 모두 설정
public class VO {
	@NonNull
	private String id;
	@NonNull
	private String pw;
	private String nick;
	
	// 실제로 값이 바뀌는건 VO 객체의 값이 아닌 디비안에서 바뀌는 것이기때문에 setter 안만듬
}
