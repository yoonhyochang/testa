package com.smhrd.database;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//myBatis 설정파일을 읽어 db 커녁션 후 세션 반환
//SqlSessionFactoryBuilder : MyBatis 설정파일 바탕으로 SqlSessionFactory 생성

public class SqlSessionManager { // DB 연결, 연결해제
	public static SqlSessionFactory sqlSession;

	static {
		// myBatis 설정파일 경로 -> db 연결
		String resource = "com/smhrd/database/mybatis-config.xml"; // 나중에 수정할 부분은 이부분밖에 없음
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			//SqlSessionFactory : SqlSession(db연결, Sql 실행, 트랜잭션 관리) 생성
			sqlSession = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// dao(class)에서 사용
	public static SqlSessionFactory getSqlSession() {
		return sqlSession;
	}
}
