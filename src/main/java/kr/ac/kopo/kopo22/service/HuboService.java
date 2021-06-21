package kr.ac.kopo.kopo22.service;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.kopo22.domain.Hubo;
import kr.ac.kopo.kopo22.dao.HuboDao;
import kr.ac.kopo.kopo22.dao.HuboDaoImpl;

public interface HuboService {
	
	int create(Hubo hubo) throws ClassNotFoundException, SQLException; 
	int delete(Hubo hubo) throws ClassNotFoundException, SQLException;
	Hubo selectOne(int id) throws ClassNotFoundException, SQLException;
	List<Hubo> getHuboList() throws ClassNotFoundException, SQLException;
	void printCnd() throws ClassNotFoundException, SQLException;

}
