package kr.ac.kopo.kopo22.service;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.kopo22.dao.TupyoDao;
import kr.ac.kopo.kopo22.dao.TupyoDaoImpl;
import kr.ac.kopo.kopo22.domain.Hubo;
import kr.ac.kopo.kopo22.domain.Tupyo;
public class TupyoServiceImpl implements TupyoService {

	private static TupyoDao dao = new TupyoDaoImpl();
	
	@Override
	public int vote(Tupyo tupyo) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return dao.vote(tupyo);
	}

	@Override
	public int getTotalVote() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.getTotalVote();
	}

	@Override
	public List<Hubo> getResultList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.getResultList();
	}

	@Override
	public List<Tupyo> getTupyoAgeGroup(Hubo hubo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getTupyoAgeGroup(hubo);
	}
	
}
