package kr.ac.kopo.kopo22.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo22.domain.Hubo;

public interface HuboDao {
	// �������̽��� ����� �߻� �޼ҵ�� ��� public abstract�� Ư���� ���� ������
	// public abstract�� �����ϴ��� �ڵ������� ������ �������� �ٰ� �ȴ�
	
	int create(Hubo hubo) throws ClassNotFoundException, SQLException;
	Hubo selectOne(int id) throws ClassNotFoundException, SQLException;
	List<Hubo> getHuboList() throws ClassNotFoundException, SQLException;
	int delete(Hubo hubo) throws ClassNotFoundException, SQLException;
	void printCnd() throws ClassNotFoundException, SQLException;

}