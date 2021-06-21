package kr.ac.kopo.kopo22.domain;

public class Hubo {
	private int id;
	private String name;
	private int votes;

		
	public Hubo() {
		
	}
	public Hubo(int id, String name, int votes) {
		this.id = id;
		this.name = name;
		this.votes = votes;
	}
	
	public Hubo(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Hubo(int id) {
		this.id = id;
	}	
	public Hubo(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	

}
