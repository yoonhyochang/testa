package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class DAO {
	// 세션을 생성해 줄 수 있는 factory 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	// factory를 사용해서 세션 생성(sql 실행, close(), 연결(connection))
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	// 회원가입
	public int join(VO vo) {
		int cnt = 0;
		try { // 만약 sql문이 잘못됐다거나, url이 잘못되었다거나하면 세션이 잘 생성이 안될 수도있음
			// 실행
			// insert("실행할 sql 경로 정의", 넘겨줄 값)
			cnt = sqlSession.insert("com.smhrd.model.DAO.insert", vo);
			if(cnt>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	public String login(VO vo) {
		String nick = null;

		try {
			nick = (String)sqlSession.selectOne("com.smhrd.model.DAO.selectOne", vo);
			// select - commit/rollback 생략가능
			if(nick!=null) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}finally {
			sqlSession.close();
		}
		return nick;
	}
	
	public int update(VO vo) {
		int cnt = 0;
		try {
			cnt = sqlSession.insert("com.smhrd.model.DAO.update", vo);
			if(cnt>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}finally {
			sqlSession.close();
		}
		return cnt;
	}

	public int delete(String id) {
		int cnt = 0;
		try {
			cnt = sqlSession.insert("com.smhrd.model.DAO.delete", id);
			if(cnt>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
}
