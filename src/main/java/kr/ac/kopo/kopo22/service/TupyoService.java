package kr.ac.kopo.kopo22.service;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.kopo22.domain.Hubo;
import kr.ac.kopo.kopo22.domain.Tupyo;
public interface TupyoService {
	// 인터페이스에 선언된 추상 메소드는 모두 public abstract의 특성을 갖기 때문에
	// public abstract를 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다
	int vote(Tupyo tupyo) throws SQLException, ClassNotFoundException;
	int getTotalVote() throws ClassNotFoundException, SQLException;
	List<Hubo> getResultList() throws ClassNotFoundException, SQLException;	
	List<Tupyo> getTupyoAgeGroup(Hubo hubo) throws ClassNotFoundException, SQLException;
}
