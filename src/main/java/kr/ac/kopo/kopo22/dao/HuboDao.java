package kr.ac.kopo.kopo22.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo22.domain.Hubo;

public interface HuboDao {
	// 인터페이스에 선언된 추상 메소드는 모두 public abstract의 특성을 갖기 때문에
	// public abstract를 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다
	
	int create(Hubo hubo) throws ClassNotFoundException, SQLException;
	Hubo selectOne(int id) throws ClassNotFoundException, SQLException;
	List<Hubo> getHuboList() throws ClassNotFoundException, SQLException;
	int delete(Hubo hubo) throws ClassNotFoundException, SQLException;
	void printCnd() throws ClassNotFoundException, SQLException;

}