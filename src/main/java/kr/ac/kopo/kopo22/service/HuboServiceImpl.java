package kr.ac.kopo.kopo22.service;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.kopo22.domain.Hubo;
import kr.ac.kopo.kopo22.dao.HuboDao;
import kr.ac.kopo.kopo22.dao.HuboDaoImpl;

public class HuboServiceImpl implements HuboService {
	
	private static HuboDao dao = new HuboDaoImpl();

	@Override
	public int create(Hubo hubo) throws ClassNotFoundException, SQLException {
//		HuboDao dao = new HuboDaoImpl();
		return dao.create(hubo);
	}

	@Override
	public int delete(Hubo hubo) throws ClassNotFoundException, SQLException {
		return dao.delete(hubo);		
	}
	
	public Hubo selectOne(int id) throws ClassNotFoundException, SQLException {
		return dao.selectOne(id);
	}
	public List<Hubo> getHuboList() throws ClassNotFoundException, SQLException {
		return dao.getHuboList();
	}

	@Override
	public void printCnd() throws ClassNotFoundException, SQLException {
	
	}

}
