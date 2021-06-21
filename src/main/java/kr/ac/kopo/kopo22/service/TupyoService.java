package kr.ac.kopo.kopo22.service;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.kopo22.domain.Hubo;
import kr.ac.kopo.kopo22.domain.Tupyo;
public interface TupyoService {
	// �������̽��� ����� �߻� �޼ҵ�� ��� public abstract�� Ư���� ���� ������
	// public abstract�� �����ϴ��� �ڵ������� ������ �������� �ٰ� �ȴ�
	int vote(Tupyo tupyo) throws SQLException, ClassNotFoundException;
	int getTotalVote() throws ClassNotFoundException, SQLException;
	List<Hubo> getResultList() throws ClassNotFoundException, SQLException;	
	List<Tupyo> getTupyoAgeGroup(Hubo hubo) throws ClassNotFoundException, SQLException;
}
