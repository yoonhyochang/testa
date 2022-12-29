package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class DAO {
	//22. 후 임폴트
	// sql세션을 생성해 줄 factory 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	
	//23. 후 임폴트
	// factory를 사용해서 sql세션(sql실행, close(), 연결(connection)) 생성
	SqlSession sqlSession = sqlSessionFactory.openSession();
	//24.
	// 회원가입
	public int join(VO vo) {
		   //31.retun값 변경 (값을 받아와야하기때문)->JoinCon
		
		int cnt = 0;
		//30. try, catch, finally생성후 29번 집어넣기
		try { // 만약 sql문이 잘못됐다거나, url이 잘못되었다던가하면 세션이 잘 생성이 안될 수도 있음
			
			//25.-> MemberMapper.xml
			// insert("실행할 sql 경로 정의", 넘겨줄 값)
			cnt = sqlSession.insert("com.smhrd.model.DAO.insert", vo);
			//28.cnt 만든후 전역변수 빼기	//27. com.smhrd.model.DAO.insert 경로 가져오기
			
			//29. 파일넘어가면 저장
			if(cnt > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//30. 파일닫기
			sqlSession.close();
		}
		return cnt;
	}
	//21. 메소드만 생성
	public String login(VO vo) {
		String name = null;
		try {
			name = sqlSession.selectOne("com.smhrd.model.DAO.selectOne", vo);
			// select - commit / rollback 생략가능
			
			if(name != null) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return name;
	}
	
	
	
	
}
